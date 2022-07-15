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
 * <h3>2.3.4 Value Types</h3>
 * Value types classify the individual values that WebAssembly code can
 * compute with and the values that a variable accepts. They are either
 * number types, vector types, or reference types.
 *
 * @author AlphaLxy
 * @see NumberType
 * @see VectorType
 * @see ReferenceType
 */
public interface ValueType {
    /**
     * Is {@link NumberType}.
     *
     * @return is {@link NumberType}
     */
    boolean isNumberType();

    /**
     * Is {@link ReferenceType}.
     *
     * @return is {@link ReferenceType}
     */
    boolean isReferenceType();

    /**
     * Is {@link VectorType}.
     *
     * @return is {@link VectorType}
     */
    boolean isVectorType();

    /**
     * Get byte code of current {@link ValueType}.
     *
     * @return byte
     */
    byte toByte();
}
