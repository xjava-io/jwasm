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

import java.util.List;

import io.xjava.wasm.structure.type.BlockType;

/**
 * The block, loop and if instructions are structured instructions.
 * They bracket nested sequences of instructions, called blocks,
 * terminated with, or separated by, end or else pseudo-instructions.
 * <p>
 * A structured instruction can consume input and produce output on
 * the operand stack according to its annotated block type. It is
 * given either as a type index that refers to a suitable function
 * type, or as an optional value type inline, which is a shorthand
 * for the function type [] -&gt; [valueType?].
 *
 * <p>
 * Each structured control instruction introduces an implicit label.
 * Labels are targets for branch instructions that reference them
 * with label indices.
 *
 * @author AlphaLxy
 */
public final class StructuredInstruction implements Instruction {
    private final OpCode opCode;
    /**
     * Each structured control instruction introduces an implicit label.
     */
    private final String label;
    /**
     * A structured instruction can consume input and produce output on
     * the operand stack according to its annotated block type
     */
    private final BlockType blockType;
    /**
     * They bracket nested sequences of instructions, called blocks.
     */
    private final List<Expression> blocks;

    public StructuredInstruction(OpCode opCode, String label, BlockType blockType, List<Expression> blocks) {
        this.opCode = opCode;
        this.blockType = blockType;
        this.label = label;
        this.blocks = blocks;
    }

    @Override
    public OpCode getOpCode() {
        return opCode;
    }

    /**
     * Get label.
     *
     * @return label
     */
    public String getLabel() {
        return label;
    }

    /**
     * Get block type.
     *
     * @return block type
     */
    public BlockType getBlockType() {
        return blockType;
    }

    /**
     * Get blocks.
     *
     * @return block list
     */
    public List<Expression> getBlock() {
        return blocks;
    }

    /**
     * Get block.
     *
     * @param i index of block
     * @return block
     */
    public Expression getBlock(int i) {
        return blocks.get(i);
    }
}
