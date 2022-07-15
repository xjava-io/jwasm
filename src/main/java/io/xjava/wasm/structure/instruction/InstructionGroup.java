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

package io.xjava.wasm.structure.instruction;

/**
 * Instructions are grouped into a number of different categories.
 *
 * @author AlphaLxy
 * @see Instruction
 */
public enum InstructionGroup {
    /**
     * <h3>2.4.1 Numeric Instructions</h3>
     * Numeric instructions provide basic operations over numeric values
     * of specific type. These operations closely match respective operations
     * available in hardware.
     */
    NUMERIC,
    /**
     * <h3>2.4.2 Vector Instructions</h3>
     * Vector instructions (also known as SIMD instructions, single data
     * multiple value) provide basic operations over values of vector type.
     */
    VECTOR,
    /**
     * <h3>2.4.3 Reference Instructions</h3>
     * Instructions in this group are concerned with accessing references.
     */
    REFERENCE,
    /**
     * <h3>2.4.4 Parametric Instructions</h3>
     * Instructions in this group can operate on operands of any value type.
     */
    PARAMETRIC,
    /**
     * <h3>2.4.5 Variable Instructions</h3>
     * Variable instructions are concerned with access to local or global
     * variables.
     */
    VARIABLE,
    /**
     * <h3>2.4.6 Table Instructions</h3>
     * Instructions in this group are concerned with tables table.
     */
    TABLE,
    /**
     * <h3>2.4.7 Memory Instructions</h3>
     * Instructions in this group are concerned with linear memory.
     */
    MEMORY,
    /**
     * <h3>2.4.8 Control Instructions</h3>
     * Instructions in this group affect the flow of control.
     */
    CONTROL
}
