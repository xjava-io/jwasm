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
 * <h3>2.3.2 Vector Types</h3>
 * Vector types classify vectors of numeric values processed by vector instructions
 * (also known as SIMD instructions, single instruction multiple data).
 * <p>
 * The type <strong>v128</strong> corresponds to a 128 bit vector of packed integer
 * or floating-point data. The packed data can be interpreted as signed or unsigned
 * integers, single or double precision floating-point values, or a single 128 bit
 * type. The interpretation is determined by individual operations.
 * <p>
 * Vector types, like number types are transparent, meaning that their bit patterns
 * can be observed. Values of vector type can be stored in memories.
 *
 * @author AlphaLxy
 */
public enum VectorType implements ValueType {
    /**
     * V128
     */
    V128((byte)0x7B);

    /**
     * Vector types are encoded by a single byte.
     */
    private final byte code;
    private final int bitWidth;

    VectorType(byte code) {
        this.code = code;
        this.bitWidth = Integer.parseInt(name().substring(1));
    }

    @Override
    public boolean isNumberType() {
        return false;
    }

    @Override
    public boolean isReferenceType() {
        return false;
    }

    @Override
    public boolean isVectorType() {
        return true;
    }

    @Override
    public byte toByte() {
        return code;
    }

    public int getBitWidth() {
        return bitWidth;
    }
}
