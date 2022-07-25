package io.xjava.wasm.structure.instruction;

import io.xjava.wasm.structure.type.ValueType;

/**
 * @author AlphaLxy
 */
public final class ValueTypeOperandInstruction implements Instruction {
    private final OpCode opCode;
    private final ValueType valueType;

    ValueTypeOperandInstruction(OpCode opCode, ValueType valueType) {
        this.opCode = opCode;
        this.valueType = valueType;
    }

    @Override
    public OpCode getOpCode() {
        return opCode;
    }

    public ValueType getValueType() {
        return valueType;
    }
}
