package io.xjava.wasm.structure.type;

/**
 * <h3>2.3.4 Value Types</h3>
 * Value types classify the individual values that WebAssembly code can
 * compute with and the values that a variable accepts. They are either
 * number types, vector types, or reference types.
 *
 * @author AlphaLxy
 * @see NumberType
 * @see VectorType
 * @see ReferenceType
 */
public interface ValueType {
    /**
     * Is {@link NumberType}.
     *
     * @return is {@link NumberType}
     */
    boolean isNumberType();

    /**
     * Is {@link ReferenceType}.
     *
     * @return is {@link ReferenceType}
     */
    boolean isReferenceType();

    /**
     * Is {@link VectorType}.
     *
     * @return is {@link VectorType}
     */
    boolean isVectorType();

    /**
     * Get byte code of current {@link ValueType}.
     *
     * @return byte
     */
    byte toByte();
}
