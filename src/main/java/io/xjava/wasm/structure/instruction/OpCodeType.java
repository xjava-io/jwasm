package io.xjava.wasm.structure.instruction;

import io.xjava.wasm.structure.type.ValueType;

/**
 * Instructions operation code type.
 *
 * @author AlphaLxy
 * @see OpCode
 */
public enum OpCodeType {
    /**
     * no operands
     * Void.class
     */
    NO_OPERAND,
    /**
     * index
     * int.class
     */
    INDEX,
    /**
     * index index
     * long.class
     */
    INDEX_INDEX,
    /**
     * indexes
     * int[].class
     */
    INDEXES,
    /**
     * const value operand
     * int.class or long.class
     */
    CONST,
    /**
     * {@link ValueType}
     * byte.class
     */
    VALUE_TYPE,
    /**
     * {@link ValueType}+
     * byte[].class
     */
    VALUE_TYPES,
    /**
     * block / loop
     */
    SIMPLE_BLOCK,
    /**
     * if else
     */
    IF_ELSE_BLOCK
}
