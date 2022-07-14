package io.xjava.wasm.structure.type;

/**
 * Vector instructions have a naming convention involving a prefix that determines
 * how their operands will be interpreted. This prefix describes the shape of the
 * operand, written <i>t</i> &times; <i>N</i>, and consisting of a packed numeric
 * type <i>t</i> and the number of lanes <i>N</i> of that type. Operations are
 * performed point-wise on the values of each lane.
 *
 * @author AlphaLxy
 * @see VectorType
 */
public enum VectorShape {
    /**
     * i8x16
     */
    I8X16,
    /**
     * i16x8
     */
    I16X8,
    /**
     * i32x4
     */
    I32X4,
    /**
     * i64x2
     */
    I64X2,
    /**
     * f32x4
     */
    F32X4,
    /**
     * f64x2
     */
    F64X2;

    private final NumberType packedNumberType;
    private final int laneBitWidth;
    private final int numberOfLanes;

    VectorShape() {
        String name = name();
        if (name.startsWith(NumberType.F32.name())) {
            packedNumberType = NumberType.F32;
        } else if (name.startsWith(NumberType.F64.name())) {
            packedNumberType = NumberType.F64;
        } else {
            // all integer use type I64
            packedNumberType = NumberType.I64;
        }
        int index = name.indexOf('X');
        laneBitWidth = Integer.parseInt(name.substring(1, index));
        numberOfLanes = Integer.parseInt(name.substring(index + 1));
    }

    public NumberType getPackedNumberType() {
        return packedNumberType;
    }

    public int getLaneBitWidth() {
        return laneBitWidth;
    }

    public int getNumberOfLanes() {
        return numberOfLanes;
    }
}
