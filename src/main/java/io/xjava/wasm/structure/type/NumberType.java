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

/**
 * <h3>2.3.1 Number Types</h3>
 * Number types classify numeric values.
 * <p>
 * The types <strong>i32</strong> and <strong>i64</strong> classify 32 and 64
 * bit integers, respectively. Integers are not inherently signed or unsigned,
 * their interpretation is determined by individual operations.
 * <p>
 * The types <strong>f32</strong> and <strong>f64</strong> classify 32 and 64
 * bit floating-point data, respectively. They correspond to the respective
 * binary floating-point representations, also known as single and double
 * precision, as defined by the IEEE 754-2019 standard (Section 3.3).
 * <p>
 * Number types are transparent, meaning that their bit patterns
 * can be observed. Values of number type can be stored in memories.
 *
 * @author AlphaLxy
 */
public enum NumberType implements ValueType {
    /**
     * i32
     */
    I32((byte)0x7F),
    /**
     * i64
     */
    I64((byte)0x7E),
    /**
     * f32
     */
    F32((byte)0x7D),
    /**
     * f64
     */
    F64((byte)0x7C);

    private final byte code;
    private final int bitWidth;

    NumberType(byte code) {
        this.code = code;
        this.bitWidth = Integer.parseInt(name().substring(1));
    }

    @Override
    public boolean isNumberType() {
        return true;
    }

    @Override
    public boolean isReferenceType() {
        return false;
    }

    @Override
    public boolean isVectorType() {
        return false;
    }

    @Override
    public byte toByte() {
        return code;
    }

    public int getBitWidth() {
        return bitWidth;
    }
}
