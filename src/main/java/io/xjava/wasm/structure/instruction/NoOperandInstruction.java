package io.xjava.wasm.structure.instruction;

/**
 * @author AlphaLxy
 */
final class NoOperandInstruction implements Instruction {
    static final NoOperandInstruction[] INSTRUCTIONS;
    private final OpCode opCode;

    static {
        OpCode[] values = OpCode.values();
        NoOperandInstruction[] instructions = new NoOperandInstruction[values.length];
        for (int i = 0; i < values.length; i++) {
            OpCode value = values[i];
            if (value.getType() == OpCodeType.NO_OPERAND) {
                instructions[i] = new NoOperandInstruction(value);
            }
        }
        INSTRUCTIONS = instructions;
    }

    NoOperandInstruction(OpCode opCode) {
        this.opCode = opCode;
    }

    @Override
    public OpCode getOpCode() {
        return opCode;
    }
}
