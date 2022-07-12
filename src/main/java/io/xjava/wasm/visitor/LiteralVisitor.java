package io.xjava.wasm.visitor;

/**
 * Visitors for string literal and number literal.
 *
 * @author AlphaLxy
 */
final class LiteralVisitor {
    private LiteralVisitor() {
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
                    int codePoint = getUnicodeCodePoint(chars, start, index - 1);
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
        builder.append(chars, 0, length);
        return builder;
    }

    /**
     * Get code point of &#92;u{hex}.
     *
     * @param chars      characters
     * @param beginIndex index of &#92;
     * @param endIndex   index of &#125;
     * @return code point
     */
    private static int getUnicodeCodePoint(char[] chars, int beginIndex, int endIndex) {
        int codePoint = 0;
        // start with '\' 'u' '{'
        // end   with '}'
        for (int i = beginIndex + 3; i < endIndex; i++) {
            int digit = hexDigit(chars[i]);
            if (digit < 0) {
                String characters = new String(chars, beginIndex, endIndex - beginIndex + 1);
                throw new IllegalArgumentException("invalid characters " + characters);
            }
            codePoint = (codePoint << 4) + digit;
            if (codePoint >= 0x110000) {
                // out of range
                String characters = new String(chars, beginIndex + 3, endIndex - beginIndex - 3);
                throw new IllegalArgumentException("code point out of range " + characters);
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
