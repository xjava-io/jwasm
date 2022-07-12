package io.xjava.wasm.visitor;

import org.junit.jupiter.api.Test;

import static io.xjava.wasm.visitor.LiteralVisitor.visitString;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for {@link LiteralVisitor}.
 *
 * @author AlphaLxy
 */
class LiteralVisitorTest {
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