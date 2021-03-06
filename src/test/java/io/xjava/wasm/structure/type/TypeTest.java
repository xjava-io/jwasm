/*
 * Copyright 2022 xjava.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.xjava.wasm.structure.type;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author AlphaLxy
 * @date 2022/07/14
 */
class TypeTest {

    @Test
    void testFunctionType() {
        FunctionType functionType;
        Set<FunctionType> set;

        functionType = new FunctionType(Collections.emptyList(), Collections.emptyList());
        assertTrue(functionType.getParameterTypes().isEmpty());
        assertTrue(functionType.getResultTypes().isEmpty());

        assertEquals(functionType, new FunctionType(new ArrayList<>(), new ArrayList<>()));
        assertEquals(functionType.hashCode(), new FunctionType(new ArrayList<>(), new ArrayList<>()).hashCode());

        set = new HashSet<>();
        set.add(functionType);
        set.add(functionType);
        assertEquals(1, set.size());

        List<ValueType> parameterTypes = Arrays.asList(NumberType.I32, NumberType.I64, ReferenceType.FUNC_REF);
        List<ValueType> resultTypes = Arrays.asList(NumberType.F32, NumberType.F64, VectorType.V128);
        functionType = new FunctionType(parameterTypes, resultTypes);
        assertFalse(functionType.getParameterTypes().isEmpty());
        assertFalse(functionType.getResultTypes().isEmpty());

        FunctionType newFunctionType = new FunctionType(new ArrayList<>(parameterTypes), new ArrayList<>(resultTypes));
        assertEquals(functionType, newFunctionType);
        assertEquals(functionType.hashCode(), newFunctionType.hashCode());

        set = new HashSet<>();
        set.add(functionType);
        set.add(functionType);
        assertEquals(1, set.size());

        assertThrows(NullPointerException.class, () -> new FunctionType(null, null));

        assertTrue(Arrays.asList(null, new Object(), functionType).contains(functionType));
    }

    @Test
    void testGlobalType() {
        GlobalType globalType;

        globalType = new GlobalType(true, NumberType.I64);
        assertTrue(globalType.isMutable());
        assertFalse(globalType.isImmutable());
        assertEquals(NumberType.I64, globalType.getValueType());

        globalType = new GlobalType(false, VectorType.V128);
        assertFalse(globalType.isMutable());
        assertTrue(globalType.isImmutable());
        assertEquals(VectorType.V128, globalType.getValueType());

        assertThrows(NullPointerException.class, () -> new GlobalType(false, null));
    }

    @Test
    void testMemoryType() {
        MemoryType memoryType;

        memoryType = new MemoryType(0, null);
        assertEquals(0, memoryType.getMin());
        assertNull(memoryType.getMax());

        memoryType = new MemoryType(0, 0);
        assertEquals(0, memoryType.getMin());
        assertEquals(0, memoryType.getMax());
    }

    @Test
    void testTableType() {
        TableType tableType;

        tableType = new TableType(0, null, ReferenceType.FUNC_REF);
        assertEquals(0, tableType.getMin());
        assertNull(tableType.getMax());
        assertEquals(ReferenceType.FUNC_REF, tableType.getRefType());

        tableType = new TableType(0, 0, ReferenceType.EXTERN_REF);
        assertEquals(0, tableType.getMin());
        assertEquals(0, tableType.getMax());
        assertEquals(ReferenceType.EXTERN_REF, tableType.getRefType());

        assertThrows(NullPointerException.class, () -> new TableType(0, 0, null));
    }

    @Test
    void testNumberType() {
        for (NumberType type : NumberType.values()) {
            assertFalse(type.isVectorType());
            assertFalse(type.isReferenceType());
            assertTrue(type.isNumberType());
        }

        assertEquals(32, NumberType.I32.getBitWidth());
        assertEquals(0x7F, NumberType.I32.toByte());
        assertEquals(64, NumberType.I64.getBitWidth());
        assertEquals(0x7E, NumberType.I64.toByte());
        assertEquals(32, NumberType.F32.getBitWidth());
        assertEquals(0x7D, NumberType.F32.toByte());
        assertEquals(64, NumberType.F64.getBitWidth());
        assertEquals(0x7C, NumberType.F64.toByte());

        // only 4 NumberType in WebAssembly Specification Release 2.0
        assertEquals(4, NumberType.values().length);
    }

    @Test
    void testReferenceType() {
        for (ReferenceType type : ReferenceType.values()) {
            assertFalse(type.isVectorType());
            assertTrue(type.isReferenceType());
            assertFalse(type.isNumberType());
        }
        assertEquals(0x70, ReferenceType.FUNC_REF.toByte());
        assertEquals(0x6F, ReferenceType.EXTERN_REF.toByte());

        // only 2 ReferenceType in WebAssembly Specification Release 2.0
        assertEquals(2, ReferenceType.values().length);
    }

    @Test
    void testVectorType() {
        for (VectorType type : VectorType.values()) {
            assertTrue(type.isVectorType());
            assertFalse(type.isReferenceType());
            assertFalse(type.isNumberType());
        }
        assertEquals(128, VectorType.V128.getBitWidth());
        assertEquals(0x7B, VectorType.V128.toByte());

        // only 1 VectorType in WebAssembly Specification Release 2.0
        assertEquals(1, VectorType.values().length);
    }

    @Test
    void testVectorShape() {
        assertEquals(8, VectorShape.I8X16.getLaneBitWidth());
        assertEquals(NumberType.I64, VectorShape.I8X16.getPackedNumberType());
        assertEquals(16, VectorShape.I8X16.getNumberOfLanes());

        assertEquals(16, VectorShape.I16X8.getLaneBitWidth());
        assertEquals(NumberType.I64, VectorShape.I16X8.getPackedNumberType());
        assertEquals(8, VectorShape.I16X8.getNumberOfLanes());

        assertEquals(32, VectorShape.I32X4.getLaneBitWidth());
        assertEquals(NumberType.I64, VectorShape.I32X4.getPackedNumberType());
        assertEquals(4, VectorShape.I32X4.getNumberOfLanes());

        assertEquals(64, VectorShape.I64X2.getLaneBitWidth());
        assertEquals(NumberType.I64, VectorShape.I64X2.getPackedNumberType());
        assertEquals(2, VectorShape.I64X2.getNumberOfLanes());

        assertEquals(32, VectorShape.F32X4.getLaneBitWidth());
        assertEquals(NumberType.F32, VectorShape.F32X4.getPackedNumberType());
        assertEquals(4, VectorShape.F32X4.getNumberOfLanes());

        assertEquals(64, VectorShape.F64X2.getLaneBitWidth());
        assertEquals(NumberType.F64, VectorShape.F64X2.getPackedNumberType());
        assertEquals(2, VectorShape.F64X2.getNumberOfLanes());

        for (VectorShape value : VectorShape.values()) {
            assertEquals(128, value.getLaneBitWidth() * value.getNumberOfLanes());
        }

        // only 6 VectorShape in WebAssembly Specification Release 2.0
        assertEquals(6, VectorShape.values().length);
    }

}