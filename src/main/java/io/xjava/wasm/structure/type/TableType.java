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
 * <h3>2.3.9 Table Types</h3>
 * Table types classify tables over elements of reference type within a size range.
 * <p>
 * Like memories, tables are constrained by limits for their minimum and optionally
 * maximum size. The limits are given in numbers of entries.
 * <p>
 * Note: In future versions of WebAssembly, additional element types may be introduced.
 *
 * @author AlphaLxy
 */
public final class TableType {
    /**
     * Minimum size
     */
    private final int min;
    /**
     * Optionally maximum size
     */
    private final Integer max;
    /**
     * Reference type
     */
    private final ReferenceType referenceType;

    public TableType(int min, Integer max, ReferenceType referenceType) {
        // do not check unsigned integer in constructor
        this.min = min;
        this.max = max;
        this.referenceType = Objects.requireNonNull(referenceType);
    }

    /**
     * Get minimum size.
     *
     * @return minimum size
     */
    public int getMin() {
        return min;
    }

    /**
     * Get optionally maximum size.
     *
     * @return maximum size or null
     */
    public Integer getMax() {
        return max;
    }

    /**
     * Get reference type.
     *
     * @return reference type
     */
    public ReferenceType getRefType() {
        return referenceType;
    }
}
