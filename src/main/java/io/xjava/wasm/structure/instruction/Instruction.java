package io.xjava.wasm.structure.instruction;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import io.xjava.wasm.structure.type.BlockType;
import io.xjava.wasm.structure.type.NumberType;
import io.xjava.wasm.structure.type.ValueType;
import io.xjava.wasm.structure.type.VectorType;

/**
 * <h3>2.4 Instructions</h3>
 * WebAssembly code consists of sequences of instructions. Its computational
 * model is based on a stack machine in that instructions manipulate values
 * on an implicit operand stack, consuming (popping) argument values and
 * producing or returning (pushing) result values.
 * <p>
 * In addition to dynamic operands from the stack, some instructions also
 * have static immediate arguments, typically indices or type annotations,
 * which are part of the instruction itself.
 * <p>
 * Some instructions are structured in that they bracket nested sequences
 * of instructions.
 *
 * @author AlphaLxy
 * @see OpCode
 * @see OpCodeType
 */
public interface Instruction {
    /**
     * Get {@link OpCode}.
     *
     * @return {@link OpCode}
     */
    OpCode getOpCode();

    /**
     * Factory of {@link NoOperandInstruction}.
     *
     * @param opCode opCode
     * @return instruction
     */
    static Instruction of(OpCode opCode) {
        NoOperandInstruction instruction = NoOperandInstruction.INSTRUCTIONS[opCode.ordinal()];
        if (instruction == null) {
            throw new IllegalArgumentException("TODO");
        }
        return instruction;
    }

    /**
     * Factory of {@link ConstOperandInstruction}.
     *
     * @param valueType valueType
     * @param value     const value
     * @return instruction
     */
    static Instruction of(ValueType valueType, Object value) {
        OpCode opCode;
        if (valueType == NumberType.I32) {
            opCode = OpCode.I32_CONST;
        } else if (valueType == NumberType.I64) {
            opCode = OpCode.I64_CONST;
        } else if (valueType == NumberType.F32) {
            opCode = OpCode.F32_CONST;
        } else if (valueType == NumberType.F64) {
            opCode = OpCode.F64_CONST;
        } else if (valueType == VectorType.V128) {
            opCode = OpCode.V128_CONST;
        } else {
            throw new IllegalArgumentException("TODO");
        }
        assert opCode.getType() == OpCodeType.CONST;
        return new ConstOperandInstruction(opCode, value);
    }

    /**
     * Factory of {@link IndexOperandInstruction}.
     *
     * @param opCode opCode
     * @param index  index
     * @return instruction
     */
    static Instruction of(OpCode opCode, int index) {
        if (opCode.getType() != OpCodeType.INDEX) {
            throw new IllegalArgumentException();
        }
        return new IndexOperandInstruction(opCode, index);
    }

    /**
     * Factory of {@link IndexIndexOperandInstruction}.
     *
     * @param opCode opCode
     * @param index0 index0
     * @param index1 index1
     * @return instruction
     */
    static Instruction of(OpCode opCode, int index0, int index1) {
        if (opCode.getType() != OpCodeType.INDEX_INDEX) {
            throw new IllegalArgumentException();
        }
        return new IndexIndexOperandInstruction(opCode, index0, index1);
    }

    /**
     * Factory of {@link IndexesOperandInstruction}.
     *
     * @param opCode  opCode
     * @param indexes indexes
     * @return instruction
     */
    static Instruction of(OpCode opCode, int[] indexes) {
        if (opCode.getType() != OpCodeType.INDEXES) {
            throw new IllegalArgumentException();
        }
        int length = indexes.length;
        List<Integer> list;
        if (length == 0) {
            list = Collections.emptyList();
        } else if (length == 1) {
            list = Collections.singletonList(indexes[0]);
        } else {
            Integer[] integers = new Integer[length];
            for (int i = 0; i < length; i++) {
                integers[i] = indexes[i];
            }
            list = Arrays.asList(integers);
        }
        return new IndexesOperandInstruction(opCode, list);
    }

    /**
     * Factory of {@link ValueTypeOperandInstruction}.
     *
     * @param opCode    opCode
     * @param valueType valueType
     * @return instruction
     */
    static Instruction of(OpCode opCode, ValueType valueType) {
        if (opCode.getType() != OpCodeType.VALUE_TYPE) {
            throw new IllegalArgumentException();
        }
        return new ValueTypeOperandInstruction(opCode, valueType);
    }

    /**
     * Factory of {@link ValueTypesOperandInstruction}.
     *
     * @param opCode     opCode
     * @param valueTypes valueTypes
     * @return instruction
     */
    static Instruction of(OpCode opCode, ValueType[] valueTypes) {
        if (opCode.getType() != OpCodeType.VALUE_TYPES) {
            throw new IllegalArgumentException();
        }
        List<ValueType> list;
        if (valueTypes.length == 0) {
            list = Collections.emptyList();
        } else if (valueTypes.length == 1) {
            list = Collections.singletonList(valueTypes[0]);
        } else {
            list = Arrays.asList(valueTypes);
        }
        return new ValueTypesOperandInstruction(opCode, list);
    }

    /**
     * Factory of {@link StructuredInstruction}.
     *
     * @param opCode      opCode
     * @param label       label
     * @param blockType   blockType
     * @param expressions expressions
     * @return instruction
     */
    static Instruction of(OpCode opCode, String label, BlockType blockType, Expression... expressions) {
        if (opCode.getType() != OpCodeType.SIMPLE_BLOCK) {
            throw new IllegalArgumentException();
        }
        List<Expression> list;
        if (expressions.length == 0) {
            list = Collections.emptyList();
        } else if (expressions.length == 1) {
            list = Collections.singletonList(expressions[0]);
        } else {
            list = Arrays.asList(expressions);
        }
        return new StructuredInstruction(opCode, label, blockType, list);
    }
}
