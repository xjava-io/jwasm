package io.xjava.wasm.structure.instruction;

/**
 * @author AlphaLxy
 */
public final class IndexOperandInstruction implements Instruction {
    private final OpCode opCode;
    private final int index;

    IndexOperandInstruction(OpCode opCode, int index) {
        this.opCode = opCode;
        this.index = index;
    }

    @Override
    public OpCode getOpCode() {
        return opCode;
    }

    public int getIndex() {
        return index;
    }
}
