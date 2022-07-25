package io.xjava.wasm.structure.instruction;

/**
 * @author AlphaLxy
 */
public final class ConstOperandInstruction implements Instruction {
    private final OpCode opCode;
    private final Object value;

    ConstOperandInstruction(OpCode opCode, Object value) {
        this.opCode = opCode;
        this.value = value;
    }

    @Override
    public OpCode getOpCode() {
        return opCode;
    }

    public Object getValue() {
        return value;
    }
}
