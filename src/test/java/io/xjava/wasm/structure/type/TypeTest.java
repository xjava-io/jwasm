package io.xjava.wasm.structure.type;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author AlphaLxy
 * @date 2022/07/14
 */
class TypeTest {

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