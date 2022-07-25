package io.xjava.wasm.structure.instruction;

import java.util.List;

import io.xjava.wasm.structure.type.ValueType;

/**
 * @author AlphaLxy
 */
public final class ValueTypesOperandInstruction implements Instruction {
    private final OpCode opCode;
    private final List<ValueType> valueTypes;

    ValueTypesOperandInstruction(OpCode opCode, List<ValueType> valueTypes) {
        this.opCode = opCode;
        this.valueTypes = valueTypes;
    }

    @Override
    public OpCode getOpCode() {
        return opCode;
    }

    public List<ValueType> getValueTypes() {
        return valueTypes;
    }
}
