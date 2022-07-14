package io.xjava.wasm.structure.type;

/**
 * <h3>2.3.1 Number Types</h3>
 * Number types classify numeric values.
 * <p>
 * The types <strong>i32</strong> and <strong>i64</strong> classify 32 and 64
 * bit integers, respectively. Integers are not inherently signed or unsigned,
 * their interpretation is determined by individual operations.
 * <p>
 * The types <strong>f32</strong> and <strong>f64</strong> classify 32 and 64
 * bit floating-point data, respectively. They correspond to the respective
 * binary floating-point representations, also known as single and double
 * precision, as defined by the IEEE 754-2019 standard (Section 3.3).
 * <p>
 * Number types are transparent, meaning that their bit patterns
 * can be observed. Values of number type can be stored in memories.
 *
 * @author AlphaLxy
 */
public enum NumberType implements ValueType {
    /**
     * i32
     */
    I32((byte)0x7F),
    /**
     * i64
     */
    I64((byte)0x7E),
    /**
     * f32
     */
    F32((byte)0x7D),
    /**
     * f64
     */
    F64((byte)0x7C);

    private final byte code;
    private final int bitWidth;

    NumberType(byte code) {
        this.code = code;
        this.bitWidth = Integer.parseInt(name().substring(1));
    }

    @Override
    public boolean isNumberType() {
        return true;
    }

    @Override
    public boolean isReferenceType() {
        return false;
    }

    @Override
    public boolean isVectorType() {
        return false;
    }

    @Override
    public byte toByte() {
        return code;
    }

    public int getBitWidth() {
        return bitWidth;
    }
}
