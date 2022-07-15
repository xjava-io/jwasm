/*
 * Copyright 2022 xjava.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.xjava.wasm.visitor;

import java.math.BigInteger;
import java.util.List;

import io.xjava.wasm.structure.type.VectorShape;
import io.xjava.wasm.structure.type.VectorType;

/**
 * Visitors for string literal and number literal.
 *
 * @author AlphaLxy
 */
final class LiteralVisitor {
    private static final BigInteger INTEGER_MAX_VALUE = BigInteger.valueOf(Integer.MAX_VALUE);

    private LiteralVisitor() {
    }

    /**
     * <h3>2.3.2 Vector Types</h3>
     * Vector types classify vectors of numeric values processed by vector instructions
     * (also known as SIMD instructions, single instruction multiple data).
     * <p>
     * The type <strong>v128</strong> corresponds to a 128 bit vector of packed integer
     * or floating-point data. The packed data can be interpreted as signed or unsigned
     * integers, single or double precision floating-point values, or a single 128 bit
     * type. The interpretation is determined by individual operations.
     * <p>
     * Vector types, like number types are transparent, meaning that their bit patterns
     * can be observed. Values of vector type can be stored in memories.
     *
     * @param vectorType  vector type
     * @param vectorShape vector shape
     * @param lanes       lanes
     * @return vector value represented in {@link BigInteger}
     */
    static BigInteger visitVectorConst(@SuppressWarnings("SameParameterValue") VectorType vectorType,
                                       VectorShape vectorShape, List<String> lanes) {
        if (lanes.size() != vectorShape.getNumberOfLanes()) {
            throw new IllegalArgumentException("wrong number of lane literals");
        }
        if (vectorType.getBitWidth() != vectorShape.getNumberOfLanes() * vectorShape.getLaneBitWidth()) {
            throw new IllegalArgumentException();
        }

        // pad a zero to head
        byte[] bytes = new byte[(vectorType.getBitWidth() >> 3) + 1];
        int index = 1;
        switch (vectorShape) {
            case F32X4:
                for (String lane : lanes) {
                    int value = visitFloat(lane);
                    bytes[index++] = (byte)(value >> 24);
                    bytes[index++] = (byte)(value >> 16);
                    bytes[index++] = (byte)(value >> 8);
                    bytes[index++] = (byte)value;
                }
                break;
            case F64X2:
                for (String lane : lanes) {
                    long value = visitDouble(lane);
                    bytes[index++] = (byte)(value >> 56);
                    bytes[index++] = (byte)(value >> 48);
                    bytes[index++] = (byte)(value >> 40);
                    bytes[index++] = (byte)(value >> 32);
                    bytes[index++] = (byte)(value >> 24);
                    bytes[index++] = (byte)(value >> 16);
                    bytes[index++] = (byte)(value >> 8);
                    bytes[index++] = (byte)value;
                }
                break;
            case I8X16:
            case I16X8:
            case I32X4:
            case I64X2:
                for (String lane : lanes) {
                    BigInteger value = visitInteger(lane);
                    if (value.bitLength() > vectorShape.getLaneBitWidth()) {
                        throw new IllegalArgumentException("constant out of range");
                    }
                    byte[] values = value.toByteArray();
                    int byteWidth = vectorShape.getLaneBitWidth() >> 3;
                    int length = Math.min(values.length, byteWidth);
                    int srcPosition = Math.max(0, values.length - byteWidth);
                    int destPosition = index + byteWidth - length;
                    System.arraycopy(values, srcPosition, bytes, destPosition, length);
                    index += byteWidth;
                }
                break;
            default:
                throw new UnsupportedOperationException();
        }
        return new BigInteger(bytes);
    }

    /**
     * <h3>6.3.1 Integers</h3>
     * All integers can be written in either decimal or hexadecimal notation.
     * In both cases, digits can optionally be separated by underscores.
     * The allowed syntax for integer literals depends on size and signedness.
     * Moreover, their value must lie within the range of the respective type.
     *
     * @param literal integer literal in WebAssembly text format
     * @return target integer
     */
    static BigInteger visitInteger(Object literal) {
        String integer = literal.toString();
        // INTEGER : Sign? Num | Sign? '0x' HexNum
        // will reuse this array
        char[] chars = integer.toCharArray();
        int length = 0;
        int radix = 10;
        for (char c : chars) {
            if (c == 'x') {
                // hex number start with '0x', replace to '00'
                chars[length++] = '0';
                radix = 16;
            } else if (c != '_') {
                // digits can optionally be separated by underscores
                chars[length++] = c;
            }
            // should be valid integer literal, do not check digit
        }
        // parse integer by new BigInteger
        if (radix == 10 && length == chars.length) {
            // do not need to copy
            return new BigInteger(integer);
        }
        return new BigInteger(new String(chars, 0, length), radix);
    }

    /**
     * <h3>6.3.1 Integers</h3>
     * All integers can be written in either decimal or hexadecimal notation.
     * In both cases, digits can optionally be separated by underscores.
     * The allowed syntax for integer literals depends on size and signedness.
     * Moreover, their value must lie within the range of the respective type.
     *
     * @param integer integer literal in WebAssembly text format
     * @return target unsigned integer [0, 2^31)
     */
    static int visitUnsignedInteger(Object integer) {
        BigInteger number = visitInteger(integer);
        if (number.signum() < 0) {
            throw new ArithmeticException("integer " + integer + " is negative");
        } else if (number.compareTo(INTEGER_MAX_VALUE) > 0) {
            throw new ArithmeticException("integer " + integer + " out of u32 range");
        }
        return number.intValue();
    }

    /**
     * <h3>6.3.2 Floating-Point</h3>
     * Floating-point values can be represented in either decimal or hexadecimal notation.
     * The value of a literal must not lie outside the representable range of the corresponding
     * IEEE 754-2019 type (that is, a numeric value must not overflow to ±infinity),
     * but it may be rounded to the nearest representable value.
     * <p>
     * Note: Rounding can be prevented by using hexadecimal notation with no more significant
     * bits than supported by the required type.
     * <p>
     * Floating-point values may also be written as constants for infinity or canonical
     * NaN (not a number). Furthermore, arbitrary NaN values may be expressed by providing
     * an explicit payload value.
     *
     * @param literal floating-point literal in WebAssembly text format
     * @return target float represented in int bits
     */
    static int visitFloat(Object literal) {
        String value = literal.toString();
        char c = value.charAt(0);
        boolean negative = c == '-';
        int index = (c == '-' || c == '+') ? 1 : 0;
        c = value.charAt(index);
        // should be valid floating-point literal
        if (c == 'i') {
            // Float.floatToIntBits(Float.NEGATIVE_INFINITY / Float.POSITIVE_INFINITY)
            return negative ? 0xFF800000 : 0x7F800000;
        }
        if (c == 'n') {
            // +nan -nan nan
            if (value.length() < 5) {
                return negative ? 0xFFC00000 : 0x7FC00000;
            }
            // +/- nan:0x1
            BigInteger num = visitInteger(value.substring(index + 4));
            // 23 bit
            if (num.compareTo(BigInteger.ZERO) > 0 && num.bitLength() <= 23) {
                return (negative ? 0xFF800000 : 0x7F800000) | num.intValue();
            }
            throw new NumberFormatException("For input string: \"" + value + "\"");
        }
        return Float.floatToIntBits(Float.parseFloat(normalizeFloatingPointLiteral(value, index)));
    }

    /**
     * <h3>6.3.2 Floating-Point</h3>
     * Floating-point values can be represented in either decimal or hexadecimal notation.
     * The value of a literal must not lie outside the representable range of the corresponding
     * IEEE 754-2019 type (that is, a numeric value must not overflow to ±infinity),
     * but it may be rounded to the nearest representable value.
     * <p>
     * Note: Rounding can be prevented by using hexadecimal notation with no more significant
     * bits than supported by the required type.
     * <p>
     * Floating-point values may also be written as constants for infinity or canonical
     * NaN (not a number). Furthermore, arbitrary NaN values may be expressed by providing
     * an explicit payload value.
     *
     * @param literal floating-point literal in WebAssembly text format
     * @return target double represented in long bits
     */
    static long visitDouble(Object literal) {
        String value = literal.toString();
        char c = value.charAt(0);
        boolean negative = c == '-';
        int index = (c == '-' || c == '+') ? 1 : 0;
        c = value.charAt(index);
        // should be valid floating-point literal
        if (c == 'i') {
            // Double.doubleToLongBits(Double.NEGATIVE_INFINITY / Double.POSITIVE_INFINITY)
            return negative ? 0xFFF0000000000000L : 0x7FF0000000000000L;
        }
        if (c == 'n') {
            // +nan -nan nan
            if (value.length() < 5) {
                return negative ? 0xFFF8000000000000L : 0x7FF8000000000000L;
            }
            BigInteger num = visitInteger(value.substring(index + 4));
            if (num.compareTo(BigInteger.ZERO) > 0 && num.bitLength() <= 52) {
                return (negative ? 0xFFF0000000000000L : 0x7FF0000000000000L) | num.longValue();
            }
            throw new NumberFormatException("For input string: \"" + value + "\"");
        }
        return Double.doubleToLongBits(Double.parseDouble(normalizeFloatingPointLiteral(value, index)));
    }

    /**
     * <h3>6.3.3 Strings</h3>
     * Strings denote sequences of bytes that can represent both textual and binary data.
     * They are enclosed in quotation marks and may contain any character other than ASCII
     * control characters, quotation marks ('"'), or backslash ('\'), except when expressed
     * with an escape sequence.
     * <p>
     * Each character in a string literal represents the byte sequence corresponding to its
     * UTF-8 Unicode encoding, except for hexadecimal escape sequences 'hh', which represent
     * raw bytes of the respective value.
     *
     * @param string string literal in WebAssembly text format
     * @return target string
     */
    static String visitString(String string) {
        return (String)visitString(string, null);
    }

    /**
     * <h3>6.3.3 Strings</h3>
     * Strings denote sequences of bytes that can represent both textual and binary data.
     * They are enclosed in quotation marks and may contain any character other than ASCII
     * control characters, quotation marks ('"'), or backslash ('\'), except when expressed
     * with an escape sequence.
     * <p>
     * Each character in a string literal represents the byte sequence corresponding to its
     * UTF-8 Unicode encoding, except for hexadecimal escape sequences 'hh', which represent
     * raw bytes of the respective value.
     *
     * @param string  string literal in WebAssembly text format
     * @param builder string builder
     * @return if builder is {@code null}, then target string; otherwise the origin builder (will append target string).
     */
    static CharSequence visitString(String string, StringBuilder builder) {
        int stringLength = string.length();
        if (stringLength < 2 || string.charAt(0) != '"' || string.charAt(stringLength - 1) != '"') {
            throw new IllegalArgumentException("should be enclosed in quotation marks");
        }
        // enclosed in quotation marks
        int maxIndex = stringLength - 2;
        int index = 1;
        // will reuse this array
        char[] chars = string.toCharArray();
        int length = 0;
        while (index <= maxIndex) {
            // first character
            char c1 = chars[index++];
            if (c1 == '\\' && index <= maxIndex) {
                // escape
                char c2 = chars[index++];
                if (c2 == '"' || c2 == '\'' || c2 == '\\') {
                    chars[length++] = c2;
                } else if (c2 == 't') {
                    chars[length++] = '\t';
                } else if (c2 == 'n') {
                    chars[length++] = '\n';
                } else if (c2 == 'r') {
                    chars[length++] = '\r';
                } else if (index > maxIndex) {
                    // no more character
                    throw new IllegalArgumentException("invalid characters " + new String(chars, index - 2, 2));
                } else if (c2 == 'u') {
                    // '\' 'u' '{' n '}' => U+(n) (if n < 0xD800 || 0xE000 <= n < 0x110000)
                    int start = index - 2;
                    if (chars[index++] != '{') {
                        throw new IllegalArgumentException("invalid characters " + string.substring(start, index));
                    }
                    while (chars[index++] != '}') {
                        if (index > maxIndex) {
                            throw new IllegalArgumentException("invalid characters " + string.substring(start, index));
                        }
                    }
                    int codePoint = getUnicodeCodePoint(string, chars, start, index - 1);
                    if (Character.isBmpCodePoint(codePoint)) {
                        if (Character.isSurrogate((char)codePoint)) {
                            throw new IllegalArgumentException("invalid characters " + string.substring(start, index));
                        }
                        chars[length++] = (char)codePoint;
                    } else {
                        chars[length++] = Character.highSurrogate(codePoint);
                        chars[length++] = Character.lowSurrogate(codePoint);
                    }
                } else {
                    // nm => 16 * n + m
                    int first = hexDigit(c2);
                    int second = hexDigit(chars[index++]);
                    if (first < 0 || second < 0) {
                        throw new IllegalArgumentException("invalid characters " + new String(chars, index - 3, 3));
                    }
                    chars[length++] = (char)((first << 4) + second);
                }
            } else if (c1 == '\\' || c1 == '"') {
                throw new IllegalArgumentException("invalid character " + c1);
            } else if (Character.isISOControl(c1)) {
                throw new IllegalArgumentException(String.format("invalid character 0x%02X", (int)c1));
            } else {
                // if c >= U+20 && c != U+7F && c != '"' && c != '\'
                chars[length++] = c1;
            }
        }
        if (builder == null) {
            return new String(chars, 0, length);
        }
        return builder.append(chars, 0, length);
    }

    /**
     * Normalize floating-point literal.
     *
     * @param literal floating-point literal in WebAssembly text format
     * @param index   index after sign character
     */
    private static String normalizeFloatingPointLiteral(String literal, int index) {
        index++;
        if (index < literal.length() && literal.charAt(index) == 'x') {
            if (literal.indexOf('p') < 0 && literal.indexOf('P') < 0) {
                // hex float, has 0x but no [P|p], append p0
                literal += "p0";
            }
        }
        return literal.replace("_", "");
    }

    /**
     * Get code point of &#92;u{hex}.
     *
     * @param string string literal
     * @param chars  characters
     * @param begin  begin index of &#92;
     * @param end    end index of &#125;
     * @return code point
     */
    private static int getUnicodeCodePoint(String string, char[] chars, int begin, int end) {
        int codePoint = 0;
        // start with '\' 'u' '{'
        // end   with '}'
        for (int i = begin + 3; i < end; i++) {
            int digit = hexDigit(chars[i]);
            if (digit < 0) {
                throw new IllegalArgumentException("invalid characters " + string.substring(begin, end + 1));
            }
            codePoint = (codePoint << 4) + digit;
            if (codePoint >= 0x110000) {
                // out of range
                throw new IllegalArgumentException("code point out of range " + string.substring(begin + 3, end));
            }
        }
        return codePoint;
    }

    /**
     * Convert char to hex digit.
     *
     * @see Character#digit(char, int)
     */
    private static int hexDigit(char ch) {
        switch (ch) {
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                return ch - '0';
            case 'A':
            case 'B':
            case 'C':
            case 'D':
            case 'E':
            case 'F':
                return ch - 'A' + 10;
            case 'a':
            case 'b':
            case 'c':
            case 'd':
            case 'e':
            case 'f':
                return ch - 'a' + 10;
            default:
                return -1;
        }
    }
}
