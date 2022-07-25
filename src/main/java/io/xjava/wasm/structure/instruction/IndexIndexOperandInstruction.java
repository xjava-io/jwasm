package io.xjava.wasm.structure.instruction;

/**
 * @author AlphaLxy
 */
public final class IndexIndexOperandInstruction implements Instruction {
    private final OpCode opCode;
    private final int index0;
    private final int index1;

    IndexIndexOperandInstruction(OpCode opCode, int index0, int index1) {
        this.opCode = opCode;
        this.index0 = index0;
        this.index1 = index1;
    }

    @Override
    public OpCode getOpCode() {
        return opCode;
    }

    public int getIndex0() {
        return index0;
    }

    public int getIndex1() {
        return index1;
    }
}
