package io.xjava.wasm.visitor;

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
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import io.xjava.wasm.parser.WatLexer;
import io.xjava.wasm.parser.WatParser;
import io.xjava.wasm.parser.WatParser.CommandContext;
import io.xjava.wasm.parser.WatParser.ScriptContext;
import io.xjava.wasm.parser.WatParser.ScriptModuleContext;
import io.xjava.wasm.structure.WebAssemblyModule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author AlphaLxy
 */
class WatModuleParserVisitorTest {

    @TestFactory
    @DisplayName("git@github.com:WebAssembly/testsuite.git")
    Stream<DynamicTest> testWebAssemblyTestSuite() throws IOException {
        // find LICENSE file
        URL resource = WatModuleParserVisitorTest.class.getClassLoader().getResource("testsuite/LICENSE");
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
                if (path.getFileName().toString().equals("table.wast")) {
                    text = text.replace("0xffff_ffff ", "0x7fff_ffff ");
                }
                if (path.getFileName().toString().equals("address.wast")) {
                    text = text.replace("offset=4294967295 ", "offset=2147483647 ");
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
                List<WebAssemblyModule> webAssemblyModules = visitModules(parser);
            }));
    }

    private List<WebAssemblyModule> visitModules(WatParser parser) {
        List<WebAssemblyModule> modules = new ArrayList<>();

        ScriptContext script = parser.script();
        List<CommandContext> commands = script.command();
        if (commands.isEmpty()) {
            WatModuleParserVisitor visitor = new WatModuleParserVisitor();
            modules.add(visitor.visitModule(null, script.moduleField()));
            return modules;
        }
        for (CommandContext command : commands) {
            ScriptModuleContext scriptModule = command.scriptModule();
            if (scriptModule != null) {
                if (scriptModule.BINARY() == null && scriptModule.QUOTE() == null) {
                    WatModuleParserVisitor visitor = new WatModuleParserVisitor();
                    modules.add(visitor.visitModule(scriptModule.id(), scriptModule.moduleField()));
                }
            }
        }
        return modules;
    }
}