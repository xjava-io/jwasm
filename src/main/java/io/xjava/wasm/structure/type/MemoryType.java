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
 * <h3>2.3.8 Memory Types</h3>
 * Memory types classify linear memories and their size range.
 * <p>
 * The limits constrain the minimum and optionally the maximum
 * size of a memory. The limits are given in units of page size.
 *
 * @author AlphaLxy
 */
public final class MemoryType {
    /**
     * Minimum size
     */
    private final int min;
    /**
     * Optionally maximum size
     */
    private final Integer max;

    public MemoryType(int min, Integer max) {
        // do not check unsigned integer in constructor
        this.min = min;
        this.max = max;
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
}
