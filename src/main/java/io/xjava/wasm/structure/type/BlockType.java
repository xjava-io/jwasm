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
 * A structured instruction can consume input and produce output on
 * the operand stack according to its annotated block type. It is
 * given either as a type index that refers to a suitable function
 * type, or as an optional value type inline, which is a shorthand
 * for the function type [] -&gt; [valueType?].
 *
 * @author AlphaLxy
 */
public final class BlockType {
    /**
     * Type index that refers to a suitable function type.
     */
    private final Integer typeIndex;
    /**
     * An optional value type inline.
     */
    private final ValueType valueType;

    public static BlockType of(ValueType valueType) {
        return new BlockType(null, valueType);
    }

    public static BlockType of(int typeIndex) {
        return new BlockType(typeIndex, null);
    }

    private BlockType(Integer typeIndex, ValueType valueType) {
        this.typeIndex = typeIndex;
        this.valueType = valueType;
    }

    /**
     * Get type index.
     *
     * @return index
     */
    public Integer getTypeIndex() {
        return typeIndex;
    }

    /**
     * Get optional value type.
     *
     * @return value type or null
     */
    public ValueType getValueType() {
        return valueType;
    }
}
