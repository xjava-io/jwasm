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

import java.util.Objects;

/**
 * <h3>2.3.10 Global Types</h3>
 * Global types classify global variables, which hold a value and
 * can either be mutable or immutable.
 *
 * @author AlphaLxy
 */
public final class GlobalType {
    /**
     * Mutable or immutable
     */
    private final boolean mutable;
    /**
     * Value type
     */
    private final ValueType valueType;

    public GlobalType(boolean mutable, ValueType valueType) {
        this.mutable = mutable;
        this.valueType = Objects.requireNonNull(valueType);
    }

    /**
     * Is mutable.
     *
     * @return is mutable
     */
    public boolean isMutable() {
        return mutable;
    }

    /**
     * Is immutable.
     *
     * @return is immutable
     */
    public boolean isImmutable() {
        return !mutable;
    }

    /**
     * Get value type.
     *
     * @return value type
     */
    public ValueType getValueType() {
        return valueType;
    }
}
