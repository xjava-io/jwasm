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

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;

import io.xjava.wasm.structure.type.VectorShape;
import io.xjava.wasm.structure.type.VectorType;

import static io.xjava.wasm.structure.type.VectorShape.*;
import static io.xjava.wasm.visitor.LiteralVisitor.*;
import static java.lang.Double.longBitsToDouble;
import static java.lang.Float.intBitsToFloat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for {@link LiteralVisitor}.
 *
 * @author AlphaLxy
 */
class LiteralVisitorTest {

    @Test
    void testVisitVectorConst() {
        assertVectorEquals(I8X16, "FFFFFFFFFFFFFFFF8080808080808080",
            "0xFF 0xFF 0xFF 0xFF 0xFF 0xFF 0xFF 0xFF -0x80 -0x80 -0x80 -0x80 -0x80 -0x80 -0x80 -0x80");
        assertVectorEquals(I8X16, "FFFFFFFFFFFFFFFF8080808080808080",
            "255 255 255 255 255 255 255 255 -128 -128 -128 -128 -128 -128 -128 -128");

        assertVectorEquals(I16X8, "FFFFFFFFFFFFFFFF8000800080008000",
            "0xFFFF 0xFFFF 0xFFFF 0xFFFF -0x8000 -0x8000 -0x8000 -0x8000");
        assertVectorEquals(I16X8, "FFFFFFFFFFFFFFFF8000800080008000",
            "65_535 65_535 65_535 65_535 -32_768 -32_768 -32_768 -32_768");
        assertVectorEquals(I16X8, "30393039303930391234123412341234",
            "0_123_45 0_123_45 0_123_45 0_123_45 0x0_1234 0x0_1234 0x0_1234 0x0_1234");

        assertVectorEquals(I32X4, "FFFFFFFFFFFFFFFF8000000080000000",
            "0xffff_ffff 0xffff_ffff -0x8000_0000 -0x8000_0000");
        assertVectorEquals(I32X4, "FFFFFFFFFFFFFFFF8000000080000000",
            "4_294_967_295 4_294_967_295 -2_147_483_648 -2_147_483_648");
        assertVectorEquals(I32X4, "075BCD15075BCD159ACFFBDF9ACFFBDF",
            "0_123_456_789 0_123_456_789 0x0_9acf_fbdf 0x0_9acf_fbdf");

        assertVectorEquals(I64X2, "FFFFFFFFFFFFFFFF8000000000000000",
            "0xffff_ffff_ffff_ffff -0x8000_0000_0000_0000");
        assertVectorEquals(I64X2, "FFFFFFFFFFFFFFFF8000000000000000",
            "18_446_744_073_709_551_615 -9_223_372_036_854_775_808");
        assertVectorEquals(I64X2, "00000000075BCD1501256789ADEFBCEF",
            "0_123_456_789 0x0125_6789_ADEF_bcef");

        assertVectorEquals(F32X4, "7F000000FF0000007E967699FE967699",
            "0x1p127 -0x1p127 1e38 -1e38");
        assertVectorEquals(F32X4, "7F800001FF8000017FFFFFFFFFFFFFFF",
            "nan:0x1 -nan:0x1 nan:0x7f_ffff -nan:0x7f_ffff");
        assertVectorEquals(F32X4, "4CEB79A34CEB79A36C7F4D7B2D592FFF",
            "0123456789. 0123456789.0123456789 0123456789.0123456789e019 0123456789.0123456789e-019");
        assertVectorEquals(F32X4, "5B91A2B45B91A2B46511A2B45211A2B4",
            "0x0123456789ABCDEF. 0x0123456789ABCDEF.019aF 0x0123456789ABCDEF.019aFp019 0x0123456789ABCDEF.019aFp-019");
        assertVectorEquals(F32X4, "7FC00000FFC000007F800000FF800000",
            "nan -nan inf -inf");

        assertVectorEquals(F64X2, "7FE0000000000000FFE1CCF385EBC8A0",
            "0x1p1023 -1e308");
        assertVectorEquals(F64X2, "7FF0000000000001FFFFFFFFFFFFFFFF",
            "nan:0x1 -nan:0xf_ffff_ffff_ffff");
        assertVectorEquals(F64X2, "419D6F34540CA4583DAB25FFD636EC12",
            "0123456789.0123456789 0123456789.0123456789e-019");
        assertVectorEquals(F64X2, "44F23456789ABCDF43C23456789ABCDF",
            "0x0123456789ABCDEFabcdef.0123456789ABCDEFabcdef 0x0123456789ABCDEFabcdef.0123456789ABCDEFabcdefp-019");
        assertVectorEquals(F64X2, "7FF8000000000000FFF0000000000000",
            "nan -inf");

        Exception e;
        e = assertThrows(IllegalArgumentException.class,
            () -> visitVectorConst(VectorType.V128, I16X8, Collections.emptyList()));
        assertEquals("wrong number of lane literals", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,
            () -> visitVectorConst(VectorType.V128, I64X2, Arrays.asList("", "", "")));
        assertEquals("wrong number of lane literals", e.getMessage());

        e = assertThrows(IllegalArgumentException.class,
            () -> visitVectorConst(VectorType.V128, I64X2, Arrays.asList("0xFFFFFFFFFFFFFFFFF", "")));
        assertEquals("constant out of range", e.getMessage());
    }

    private void assertVectorEquals(VectorShape shape, String expected, String literal) {
        BigInteger vectorConst = visitVectorConst(VectorType.V128, shape, Arrays.asList(literal.split(" +")));
        assertTrue(vectorConst.bitLength() <= VectorType.V128.getBitWidth());
        assertEquals(new BigInteger(expected, 16), vectorConst);
    }

    @Test
    void testVisitInteger() {
        assertEquals(new BigInteger("123"), visitInteger("123"));
        assertEquals(new BigInteger("123"), visitInteger("+123"));
        assertEquals(new BigInteger("-123"), visitInteger("-123"));
        assertEquals(new BigInteger("123"), visitInteger("000123"));
        assertEquals(new BigInteger("-123"), visitInteger("__-__0__0__0__1__2__3__"));

        assertEquals(new BigInteger("123", 16), visitInteger("0x123"));
        assertEquals(new BigInteger("ABC", 16), visitInteger("+0xABC"));
        assertEquals(new BigInteger("-ABC", 16), visitInteger("-0xABC"));
        assertEquals(new BigInteger("ABC", 16), visitInteger("0x00ABC"));
        assertEquals(new BigInteger("-ABC", 16), visitInteger("__-__0__x__0__A__B__C__"));

        // big integer
        assertEquals(new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFF", 16), visitInteger("0xFFFFFFFFFFFFFFFFFFFFFFFF"));

        // any Object
        assertEquals(new BigInteger("123"), visitInteger(new BigInteger("123")));
        assertEquals(new BigInteger("123"), visitInteger(123));
    }

    @Test
    void testVisitUnsignedInteger() {
        assertEquals(123, visitUnsignedInteger("123"));
        assertEquals(123, visitUnsignedInteger("+123"));
        assertEquals(123, visitUnsignedInteger("000123"));
        assertEquals(123, visitUnsignedInteger("__0__0__0__1__2__3__"));

        assertEquals(0x123, visitUnsignedInteger("0x123"));
        assertEquals(0xABC, visitUnsignedInteger("+0xABC"));
        assertEquals(0xABC, visitUnsignedInteger("0x00ABC"));
        assertEquals(0xABC, visitUnsignedInteger("__0__x__0__A__B__C__"));

        // min value
        assertEquals(0, visitUnsignedInteger("0x0"));
        // max value
        assertEquals(Integer.MAX_VALUE, visitUnsignedInteger("0x7FFFFFFF"));

        Exception e;

        e = assertThrows(ArithmeticException.class, () -> visitUnsignedInteger("-1"));
        assertEquals("integer -1 is negative", e.getMessage());

        e = assertThrows(ArithmeticException.class, () -> visitUnsignedInteger("-0xFFFFFFFF"));
        assertEquals("integer -0xFFFFFFFF is negative", e.getMessage());

        e = assertThrows(ArithmeticException.class, () -> visitUnsignedInteger("0xFFFFFFFF"));
        assertEquals("integer 0xFFFFFFFF out of u32 range", e.getMessage());

        e = assertThrows(ArithmeticException.class, () -> visitUnsignedInteger("0xFFFFFFFFFFF"));
        assertEquals("integer 0xFFFFFFFFFFF out of u32 range", e.getMessage());

        assertThrows(NumberFormatException.class, () -> visitUnsignedInteger("1E10"));

        // any Object
        assertEquals(123, visitUnsignedInteger(new BigInteger("123")));
        assertEquals(123, visitUnsignedInteger(123));
    }

    @Test
    void testVisitFloat() {
        assertEquals(0.0F, intBitsToFloat(visitFloat("0")));

        assertEquals(Float.NaN, intBitsToFloat(visitFloat("nan")));
        assertEquals(Float.NaN, intBitsToFloat(visitFloat("+nan")));
        assertEquals(Float.NaN, intBitsToFloat(visitFloat("-nan")));
        assertEquals(Float.POSITIVE_INFINITY, intBitsToFloat(visitFloat("inf")));
        assertEquals(Float.POSITIVE_INFINITY, intBitsToFloat(visitFloat("+inf")));
        assertEquals(Float.NEGATIVE_INFINITY, intBitsToFloat(visitFloat("-inf")));
        assertEquals(Float.POSITIVE_INFINITY, intBitsToFloat(visitFloat("1234567890E123456")));

        assertEquals(0.1F, intBitsToFloat(visitFloat("0__.__1__")));
        assertEquals(0.2F, intBitsToFloat(visitFloat("0__.__2__")));
        assertEquals(1.2345679E19F, intBitsToFloat(visitFloat("12345678901234567890")));
        assertEquals(1.2345678E19F, intBitsToFloat(visitFloat("12345678000000000000")));
        assertEquals(1E10F, intBitsToFloat(visitFloat("1E10")));
        assertEquals(1E10F, intBitsToFloat(visitFloat("1.E10")));
        assertEquals(1E10F, intBitsToFloat(visitFloat("1.00E+10")));
        assertEquals(1E-10F, intBitsToFloat(visitFloat("1.00E-10")));
        assertEquals(1E-10F, intBitsToFloat(visitFloat("0.1e-9")));

        assertEquals(0x0.1p0F, intBitsToFloat(visitFloat("0x__0__.__1__")));
        assertEquals(0x0.2p0F, intBitsToFloat(visitFloat("0x__0__.__2__")));
        assertEquals(2.0988296E19F, intBitsToFloat(visitFloat("0x123456789ABCDEFAB")));
        assertEquals(2.0988295E19F, intBitsToFloat(visitFloat("0x123456789AB000000")));
        assertEquals(4.0F, intBitsToFloat(visitFloat("0x1P2")));
        assertEquals(4.0F, intBitsToFloat(visitFloat("0x1.P2")));
        assertEquals(4.0F, intBitsToFloat(visitFloat("0x1.00P+2")));
        assertEquals(0.25F, intBitsToFloat(visitFloat("0x1.00P-2")));
        assertEquals(0.25F, intBitsToFloat(visitFloat("0x0.1P2")));
        assertEquals(1.0F / 32, intBitsToFloat(visitFloat("0x0.1p-1")));

        assertThrows(NumberFormatException.class, () -> visitFloat("_0x1"));
        assertThrows(NumberFormatException.class, () -> visitFloat("0_x1"));

        assertEquals(0x7F800001, visitFloat("+nan:0x1"));
        assertEquals(0xFF800001, visitFloat("-nan:0x1"));
        assertEquals(Float.NaN, intBitsToFloat(visitFloat("-nan:0x1")));
        assertEquals(Float.NaN, intBitsToFloat(visitFloat("nan:0x700000")));
        assertEquals(Float.NaN, intBitsToFloat(visitFloat("nan:0x7FFFFF")));
        assertEquals(Float.NaN, intBitsToFloat(visitFloat("nan:0x__400_000__")));

        assertThrows(NumberFormatException.class, () -> visitFloat("+nan:0x0"));
        assertThrows(NumberFormatException.class, () -> visitFloat("+nan:0x-1"));
        assertThrows(NumberFormatException.class, () -> visitFloat("+nan:0x800000"));

        // any Object
        assertEquals(0.1F, intBitsToFloat(visitFloat(new BigDecimal("0.1"))));
        assertEquals(0.1F, intBitsToFloat(visitFloat(0.1F)));
    }

    @Test
    void testVisitDouble() {
        assertEquals(0.0, longBitsToDouble(visitDouble("0")));

        assertEquals(Double.NaN, longBitsToDouble(visitDouble("nan")));
        assertEquals(Double.NaN, longBitsToDouble(visitDouble("+nan")));
        assertEquals(Double.NaN, longBitsToDouble(visitDouble("-nan")));
        assertEquals(Double.POSITIVE_INFINITY, longBitsToDouble(visitDouble("inf")));
        assertEquals(Double.POSITIVE_INFINITY, longBitsToDouble(visitDouble("+inf")));
        assertEquals(Double.NEGATIVE_INFINITY, longBitsToDouble(visitDouble("-inf")));
        assertEquals(Double.POSITIVE_INFINITY, longBitsToDouble(visitDouble("1234567890E123456")));

        assertEquals(0.1, longBitsToDouble(visitDouble("0__.__1__")));
        assertEquals(0.2, longBitsToDouble(visitDouble("0__.__2__")));
        assertEquals(1.2345678901234567E19, longBitsToDouble(visitDouble("12345678901234567890")));
        assertEquals(1.2345678901234567E19, longBitsToDouble(visitDouble("12345678901234567000")));
        assertEquals(1E10, longBitsToDouble(visitDouble("1E10")));
        assertEquals(1E10, longBitsToDouble(visitDouble("1.E10")));
        assertEquals(1E10, longBitsToDouble(visitDouble("1.00E+10")));
        assertEquals(1E-10, longBitsToDouble(visitDouble("1.00E-10")));
        assertEquals(1E-10, longBitsToDouble(visitDouble("0.1e-9")));

        assertEquals(0x0.1p0, longBitsToDouble(visitDouble("0x__0__.__1__")));
        assertEquals(0x0.2p0, longBitsToDouble(visitDouble("0x__0__.__2__")));
        assertEquals(2.0988295479420645E19, longBitsToDouble(visitDouble("0x123456789ABCDEFAB")));
        assertEquals(2.0988295479420645E19, longBitsToDouble(visitDouble("0x123456789ABCDEF00")));
        assertEquals(4.0, longBitsToDouble(visitDouble("0x1P2")));
        assertEquals(4.0, longBitsToDouble(visitDouble("0x1.P2")));
        assertEquals(4.0, longBitsToDouble(visitDouble("0x1.00P+2")));
        assertEquals(0.25, longBitsToDouble(visitDouble("0x1.00P-2")));
        assertEquals(0.25, longBitsToDouble(visitDouble("0x0.1P2")));
        assertEquals(1.0 / 32, longBitsToDouble(visitDouble("0x0.1p-1")));

        assertThrows(NumberFormatException.class, () -> visitDouble("_0x1"));
        assertThrows(NumberFormatException.class, () -> visitDouble("0_x1"));

        assertEquals(0x7FF0000000000001L, visitDouble("+nan:0x1"));
        assertEquals(0xFFF0000000000001L, visitDouble("-nan:0x1"));
        assertEquals(Double.NaN, longBitsToDouble(visitDouble("-nan:0x1")));
        assertEquals(Double.NaN, longBitsToDouble(visitDouble("nan:0x4000000000000")));
        assertEquals(Double.NaN, longBitsToDouble(visitDouble("nan:0xFFFFFFFFFFFFF")));
        assertEquals(Double.NaN, longBitsToDouble(visitDouble("nan:0x__4000_000_000_000__")));

        assertThrows(NumberFormatException.class, () -> visitDouble("+nan:0x0"));
        assertThrows(NumberFormatException.class, () -> visitDouble("+nan:0x-1"));
        assertThrows(NumberFormatException.class, () -> visitDouble("+nan:0x10000000000000"));

        // any Object
        assertEquals(0.1D, longBitsToDouble(visitDouble(new BigDecimal("0.1"))));
        assertEquals(0.1D, longBitsToDouble(visitDouble(0.1D)));
    }

    @Test
    void testVisitString() {
        Exception e;
        // enclosed in quotation marks
        e = assertThrows(IllegalArgumentException.class, () -> visitString("123\""));
        assertTrue(e.getMessage().contains("quotation marks"));
        e = assertThrows(IllegalArgumentException.class, () -> visitString("\"123"));
        assertTrue(e.getMessage().contains("quotation marks"));
        e = assertThrows(IllegalArgumentException.class, () -> visitString("123"));
        assertTrue(e.getMessage().contains("quotation marks"));
        e = assertThrows(IllegalArgumentException.class, () -> visitString("1\"23"));
        assertTrue(e.getMessage().contains("quotation marks"));

        assertEquals("123", visitString("\"123\""));
        assertEquals("abc", visitString("\"abc\""));
        assertEquals("中文", visitString("\"中文\""));
        // emoji
        assertEquals("😄", visitString("\"😄\""));

        // escape
        assertEquals("\t", visitString("\"\\t\""));
        assertEquals("\n", visitString("\"\\n\""));
        assertEquals("\r", visitString("\"\\r\""));
        assertEquals("\"", visitString("\"\\\"\""));
        assertEquals("'", visitString("\"'\""));
        assertEquals("'", visitString("\"\\'\""));
        assertEquals("\\", visitString("\"\\\\\""));

        e = assertThrows(IllegalArgumentException.class, () -> visitString("\"\t\""));
        assertTrue(e.getMessage().contains("0x09"));
        e = assertThrows(IllegalArgumentException.class, () -> visitString("\"\n\""));
        assertTrue(e.getMessage().contains("0x0A"));
        e = assertThrows(IllegalArgumentException.class, () -> visitString("\"\r\""));
        assertTrue(e.getMessage().contains("0x0D"));
        e = assertThrows(IllegalArgumentException.class, () -> visitString("\"\"\""));
        assertTrue(e.getMessage().contains("\""));
        e = assertThrows(IllegalArgumentException.class, () -> visitString("\"\\\""));
        assertTrue(e.getMessage().contains("\\"));

        // for all characters
        for (int i = 0; i <= Character.MAX_VALUE; i++) {
            String text = "\"" + ((char)i) + "\"";
            if (i < 0x20) {
                // C0 Controls
                e = assertThrows(IllegalArgumentException.class, () -> visitString(text));
                assertTrue(e.getMessage().contains(String.format("0x%02X", i)));
            } else if (0x7F <= i && i <= 0x9F) {
                // C1 Controls
                e = assertThrows(IllegalArgumentException.class, () -> visitString(text));
                assertTrue(e.getMessage().contains(String.format("0x%02X", i)));
            } else if (i == '\"') {
                e = assertThrows(IllegalArgumentException.class, () -> visitString(text));
                assertTrue(e.getMessage().contains("\""));
            } else if (i != '\\') {
                assertEquals(String.valueOf(((char)i)), visitString(text));
                // add emoji
                String emojiText = "\"😄" + ((char)i) + "\"";
                assertEquals("😄" + ((char)i), visitString(emojiText));
            }
        }
        // nm => 16 * n + m
        StringBuilder textStringBuilder = new StringBuilder("\"");
        StringBuilder expectedStringBuilder = new StringBuilder();
        for (int i = 0; i < 0xFF; i++) {
            textStringBuilder.append("\\");
            textStringBuilder.append(String.format(i % 2 == 0 ? "%02X" : "%02x", i));
            expectedStringBuilder.append((char)i);
        }
        textStringBuilder.append("\"");
        // "\00\01\02\03\04\05\06\07\08\09\0A\0b\0C\0d\0E\0f..."
        assertEquals(expectedStringBuilder.toString(), visitString(textStringBuilder.toString()));

        e = assertThrows(IllegalArgumentException.class, () -> visitString("\"\\G\""));
        assertEquals("invalid characters \\G", e.getMessage());
        e = assertThrows(IllegalArgumentException.class, () -> visitString("\"\\0\""));
        assertEquals("invalid characters \\0", e.getMessage());
        e = assertThrows(IllegalArgumentException.class, () -> visitString("\"\\0G\""));
        assertEquals("invalid characters \\0G", e.getMessage());
        e = assertThrows(IllegalArgumentException.class, () -> visitString("\"\\0😄\""));
        assertEquals("invalid characters \\0\uD83D", e.getMessage());
        e = assertThrows(IllegalArgumentException.class, () -> visitString("\"😄\\0😄\""));
        assertEquals("invalid characters \\0\uD83D", e.getMessage());

        // u{' n '}' => U+(n) (if n < 0xD800 || 0xE000 <= n < 0x110000)
        for (int i = 0; i < 0x110000; i++) {
            String text = "\"\\u{" + Integer.toHexString(i) + "}\"";
            if (0xD800 <= i && i < 0xE000) {
                e = assertThrows(IllegalArgumentException.class, () -> visitString(text));
                assertEquals("invalid characters " + text.substring(1, text.length() - 1), e.getMessage());
            } else {
                String expected;
                if (i <= Character.MAX_VALUE) {
                    expected = String.valueOf(((char)i));
                } else {
                    expected = new String(new char[] {Character.highSurrogate(i), Character.lowSurrogate(i)});
                }
                assertEquals(expected, visitString(text));
            }
        }
        assertEquals("😄", visitString("\"\\u{1F604}\""));
        String string = visitString("\"\\u{10FFFF}\"");
        assertEquals(0x10FFFF, string.codePointAt(0));
        // surrogate
        e = assertThrows(IllegalArgumentException.class, () -> visitString("\"😄\\u{D800}😄\""));
        assertEquals("invalid characters \\u{D800}", e.getMessage());
        // invalid digit
        e = assertThrows(IllegalArgumentException.class, () -> visitString("\"😄\\u{F{}😄\""));
        assertEquals("invalid characters \\u{F{}", e.getMessage());
        // no }
        e = assertThrows(IllegalArgumentException.class, () -> visitString("\"😄\\u{FF😄\""));
        assertEquals("invalid characters \\u{FF😄", e.getMessage());
        // no {
        e = assertThrows(IllegalArgumentException.class, () -> visitString("\"😄\\uFF}\""));
        assertEquals("invalid characters \\uF", e.getMessage());
        e = assertThrows(IllegalArgumentException.class, () -> visitString("\"😄\\u\""));
        assertEquals("invalid characters \\u", e.getMessage());
        // out of range
        e = assertThrows(IllegalArgumentException.class, () -> visitString("\"😄\\u{110000}😄\""));
        assertEquals("code point out of range 110000", e.getMessage());
        e = assertThrows(IllegalArgumentException.class, () -> visitString("\"😄\\u{FF000000}😄\""));
        assertEquals("code point out of range FF000000", e.getMessage());

        assertEquals("123abc中文\t\n\r\"\\A😄😄", visitString("\"123abc中文\\t\\n\\r\\\"\\\\\\41😄\\u{1F604}\""));
        // with StringBuilder
        StringBuilder sb = new StringBuilder();
        visitString("\"123\"", sb);
        visitString("\"abc\"", sb);
        visitString("\"中文\"", sb);
        visitString("\"\\t\\n\\r\\\"\\\\\"", sb);
        visitString("\"\\41\"", sb);
        visitString("\"😄\"", sb);
        // return same object
        assertSame(sb, visitString("\"\\u{1F604}\"", sb));
        assertEquals("123abc中文\t\n\r\"\\A😄😄", sb.toString());
    }
}