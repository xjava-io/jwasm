package io.xjava.wasm.structure.instruction;

import java.util.List;

/**
 * @author AlphaLxy
 */
public final class IndexesOperandInstruction implements Instruction {
    private final OpCode opCode;
    private final List<Integer> indexes;

    IndexesOperandInstruction(OpCode opCode, List<Integer> indexes) {
        this.opCode = opCode;
        this.indexes = indexes;
    }

    @Override
    public OpCode getOpCode() {
        return opCode;
    }

    public List<Integer> getIndexes() {
        return indexes;
    }
}
