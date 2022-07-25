package io.xjava.wasm.structure.instruction;

import java.util.List;

/**
 * @author AlphaLxy
 */
public final class Expression {
    private final List<Instruction> instructions;

    public Expression(List<Instruction> instructions) {
        this.instructions = instructions;
    }

    public List<Instruction> getInstructions() {
        return instructions;
    }
}
