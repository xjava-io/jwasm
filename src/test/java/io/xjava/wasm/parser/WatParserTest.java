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

package io.xjava.wasm.parser;

import org.antlr.v4.runtime.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Tests for {@link WatParser}
 *
 * @author AlphaLxy
 */
class WatParserTest {

    @TestFactory
    @DisplayName("git@github.com:WebAssembly/testsuite.git")
    Stream<DynamicTest> testWebAssemblyTestSuite() throws IOException {
        // find LICENSE file
        URL resource = WatParserTest.class.getClassLoader().getResource("testsuite/LICENSE");
        assertNotNull(resource, "use `git submodule init` command to init test suite");
        assertEquals("file", resource.getProtocol());
        Path root = Paths.get(resource.getPath()).getParent();
        return Files.list(root)
            .filter(path -> path.getFileName().toString().endsWith(".wast"))
            .sorted()
            .map(path -> DynamicTest.dynamicTest(path.getFileName().toString(), () -> {
                String text = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
                if (path.getFileName().toString().equals("comments.wast")) {
                    // TODO not implemented yet
                    //  blockchar ::= c:char        (if c != ';' && c != '(')
                    //              | ';'           (if the next character is not ')')
                    //              | '('           (if the next character is not ';')
                    //              | blockcomment
                    text = text.replaceAll(Pattern.quote("(;comment;)((;comment;)"), "");
                    text = text.replaceAll(Pattern.quote("(;comment;)module(;comment;)"), "");
                    text = text.replaceAll(Pattern.quote("(;comment;))(;comment;)"), "");
                }
                WatLexer lexer = new WatLexer(CharStreams.fromString(text));
                WatParser parser = new WatParser(new CommonTokenStream(lexer));
                parser.removeErrorListeners();
                parser.addErrorListener(new BaseErrorListener() {
                    @Override
                    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line,
                                            int charPositionInLine, String msg, RecognitionException e) {
                        throw new RuntimeException(msg);
                    }
                });
                parser.script();
            }));
    }
}