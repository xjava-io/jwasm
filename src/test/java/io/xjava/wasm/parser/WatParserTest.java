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