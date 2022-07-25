//package io.xjava.wasm.visitor;
//
//import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
//import org.antlr.v4.runtime.tree.TerminalNode;
//
//import java.nio.charset.StandardCharsets;
//import java.util.*;
//
//import io.xjava.wasm.parser.WatParser.*;
//import io.xjava.wasm.parser.WatParserVisitor;
//import io.xjava.wasm.spec.WebAssemblyModule;
//import io.xjava.wasm.spec.module.*;
//import io.xjava.wasm.spec.type.FunctionType;
//import io.xjava.wasm.spec.type.MemoryType;
//import io.xjava.wasm.spec.type.TableType;
//import io.xjava.wasm.spec.type.ValueType;
//
///**
// * @author AlphaLxy
// // */
//public class WatModuleParserVisitor2 extends AbstractParseTreeVisitor<Object> implements WatParserVisitor<Object> {
//
//    private final List<TypeComponent> types = new ArrayList<>();
//    private final List<FunctionComponent> functions = new ArrayList<>();
//    private final List<TableComponent> tables = new ArrayList<>();
//    private final List<MemoryComponent> memories = new ArrayList<>();
//    private final List<GlobalComponent> globals = new ArrayList<>();
//
//    private final List<ElementSegment> elementSegments = new ArrayList<>();
//    private final List<DataSegment> dataSegments = new ArrayList<>();
//
//    private Integer start;
//
//    private final List<Import> imports = new ArrayList<>();
//    private final List<Export> exports = new ArrayList<>();
//
//    private final Map<String, Integer> typeIndexes = new HashMap<>();
//    private final Map<String, Integer> functionIndexes = new HashMap<>();
//    private final Map<String, Integer> tableIndexes = new HashMap<>();
//    private final Map<String, Integer> memoryIndexes = new HashMap<>();
//    private final Map<String, Integer> globalIndexes = new HashMap<>();
//
//    public WatModuleParserVisitor2() {
//    }
//
//    public WebAssemblyModule buildModule() {
//        return new WebAssemblyModule(
//            immutable(types),
//            immutable(functions),
//            immutable(tables),
//            immutable(memories),
//            immutable(globals),
//            immutable(elementSegments),
//            immutable(dataSegments),
//            start,
//            immutable(imports),
//            immutable(exports));
//    }
//
//    @Override
//    public Object visitValue(ValueContext ctx) {
//        throw new UnsupportedOperationException();
//    }
//
//    @Override
//    public String visitName(NameContext ctx) {
//        String text = ctx.getText();
//        return text.substring(0, text.length() - 1);
//    }
//
//    @Override
//    public ValueType visitValueType(ValueTypeContext ctx) {
//        // done
//        return ValueType.valueOf(ctx.getText().toUpperCase());
//    }
//
//    @Override
//    public Object visitElemType(ElemTypeContext ctx) {
//        throw new UnsupportedOperationException();
//    }
//
//    @Override
//    public Object visitGlobalType(GlobalTypeContext ctx) {
//        throw new UnsupportedOperationException();
//    }
//
//    @Override
//    public List<ValueType> visitParamTypes(ParamTypesContext ctx) {
//        return visitValueType(ctx.valueType());
//    }
//
//    @Override
//    public List<ValueType> visitNamedParamType(NamedParamTypeContext ctx) {
//        // done
//        if (ctx.bindVar() != null) {
//            throw new RuntimeException();
//        }
//        return Collections.singletonList(visitValueType(ctx.valueType()));
//    }
//
//    @Override
//    public List<ValueType> visitFuncParamTypes(FuncParamTypesContext ctx) {
//        NamedParamTypeContext namedParamType = ctx.namedParamType();
//        if (namedParamType != null) {
//            return visitNamedParamType(namedParamType);
//        }
//        ParamTypesContext paramTypes = ctx.paramTypes();
//        if (paramTypes != null) {
//            return visitParamTypes(paramTypes);
//        }
//        throw new RuntimeException();
//    }
//
//    @Override
//    public List<ValueType> visitFuncResultTypes(FuncResultTypesContext ctx) {
//        return visitValueType(ctx.valueType());
//    }
//
//    private List<ValueType> visitValueType(List<ValueTypeContext> types) {
//        ValueType[] valueTypes = new ValueType[types.size()];
//        for (int i = 0; i < types.size(); i++) {
//            valueTypes[i] = visitValueType(types.get(i));
//        }
//        return Arrays.asList(valueTypes);
//    }
//
//    @Override
//    public TypeComponent visitFuncType(FuncTypeContext ctx) {
//        List<ValueType> parameterTypes = new ArrayList<>();
//        List<ValueType> resultTypes = new ArrayList<>();
//        for (FuncParamTypesContext types : ctx.funcParamTypes()) {
//            parameterTypes.addAll(visitFuncParamTypes(types));
//        }
//        for (FuncResultTypesContext types : ctx.funcResultTypes()) {
//            resultTypes.addAll(visitFuncResultTypes(types));
//        }
//        return new TypeComponent(new FunctionType(immutable(parameterTypes), immutable(resultTypes)));
//    }
//
//    @Override
//    public Object visitTableType(TableTypeContext ctx) {
//        // done
//        TerminalNode initial = ctx.NAT(0);
//        TerminalNode maximum = ctx.NAT(1);
//        // ignore ctx.elemType()
//        tables.add(new TableComponent(new TableType(visitUnsignedInteger(initial), visitUnsignedInteger(maximum))));
//        return null;
//    }
//
//    @Override
//    public Object visitMemoryType(MemoryTypeContext ctx) {
//        // done
//        TerminalNode initial = ctx.NAT(0);
//        TerminalNode maximum = ctx.NAT(1);
//        memories.add(new MemoryComponent(new MemoryType(visitUnsignedInteger(initial), visitUnsignedInteger
//        (maximum))));
//        return null;
//    }
//
//    @Override
//    public Object visitTypeUse(TypeUseContext ctx) {
//        throw new UnsupportedOperationException();
//    }
//
//    @Override
//    public Object visitLiteral(LiteralContext ctx) {
//        throw new UnsupportedOperationException();
//    }
//
//    @Override
//    public Object visitVar(VarContext ctx) {
//        throw new UnsupportedOperationException();
//    }
//
//    @Override
//    public String visitBindVar(BindVarContext ctx) {
//        // done
//        return ctx.VAR().getText();
//    }
//
//    @Override
//    public Object visitInstr(InstrContext ctx) {
//        throw new UnsupportedOperationException();
//    }
//
//    @Override
//    public Object visitPlainInstr(PlainInstrContext ctx) {
//        throw new UnsupportedOperationException();
//    }
//
//    @Override
//    public Object visitCallInstr(CallInstrContext ctx) {
//        throw new UnsupportedOperationException();
//    }
//
//    @Override
//    public Object visitCallInstrInstr(CallInstrInstrContext ctx) {
//        throw new UnsupportedOperationException();
//    }
//
//    @Override
//    public Object visitCallInstrParamsInstr(CallInstrParamsInstrContext ctx) {
//        throw new UnsupportedOperationException();
//    }
//
//    @Override
//    public Object visitCallInstrResultsInstr(CallInstrResultsInstrContext ctx) {
//        throw new UnsupportedOperationException();
//    }
//
//    @Override
//    public Object visitBlockInstr(BlockInstrContext ctx) {
//        throw new UnsupportedOperationException();
//    }
//
//    @Override
//    public Object visitBlockType(BlockTypeContext ctx) {
//        throw new UnsupportedOperationException();
//    }
//
//    @Override
//    public Object visitBlock(BlockContext ctx) {
//        throw new UnsupportedOperationException();
//    }
//
//    @Override
//    public Object visitExpr(ExprContext ctx) {
//        throw new UnsupportedOperationException();
//    }
//
//    @Override
//    public Object visitExpression(ExpressionContext ctx) {
//        throw new UnsupportedOperationException();
//    }
//
//    @Override
//    public Object visitCallExprType(CallExprTypeContext ctx) {
//        throw new UnsupportedOperationException();
//    }
//
//    @Override
//    public Object visitCallExprParams(CallExprParamsContext ctx) {
//        throw new UnsupportedOperationException();
//    }
//
//    @Override
//    public Object visitCallExprResults(CallExprResultsContext ctx) {
//        throw new UnsupportedOperationException();
//    }
//
//    @Override
//    public Object visitIfBlock(IfBlockContext ctx) {
//        throw new UnsupportedOperationException();
//    }
//
//    @Override
//    public Object visitInstrList(InstrListContext ctx) {
//        throw new UnsupportedOperationException();
//    }
//
//    @Override
//    public Object visitConstExpr(ConstExprContext ctx) {
//        throw new UnsupportedOperationException();
//    }
//
//    @Override
//    public Object visitFunc(FuncContext ctx) {
//        // done
//        BindVarContext var = ctx.bindVar();
//        visitFuncFields(ctx.funcFields());
//        if (var != null) {
//            functionIndexes.put(visitBindVar(var), functions.size() - 1);
//        }
//        return null;
//    }
//
//    @Override
//    public Object visitFuncFields(FuncFieldsContext ctx) {
//        FuncFieldsBodyContext body = ctx.funcFieldsBody();
//        if (body != null) {
//            return visitFuncFieldsBody(body);
//        } else {
//            throw new UnsupportedOperationException();
//        }
//    }
//
//    @Override
//    public Object visitFuncFieldsImport(FuncFieldsImportContext ctx) {
//        throw new UnsupportedOperationException();
//    }
//
//    @Override
//    public Object visitFuncFieldsImportResult(FuncFieldsImportResultContext ctx) {
//        throw new UnsupportedOperationException();
//    }
//
//    @Override
//    public List<ValueType> visitLocalTypes(LocalTypesContext ctx) {
//        return visitValueType(ctx.valueType());
//    }
//
//    @Override
//    public List<ValueType> visitNamedLocalType(NamedLocalTypeContext ctx) {
//        // done
//        if (ctx.bindVar() != null) {
//            throw new RuntimeException();
//        }
//        return Collections.singletonList(visitValueType(ctx.valueType()));
//    }
//
//    @Override
//    public List<ValueType> visitFuncLocalTypes(FuncLocalTypesContext ctx) {
//        NamedLocalTypeContext namedLocalType = ctx.namedLocalType();
//        if (namedLocalType != null) {
//            return visitNamedLocalType(namedLocalType);
//        }
//        LocalTypesContext localTypes = ctx.localTypes();
//        if (localTypes != null) {
//            return visitLocalTypes(localTypes);
//        }
//        throw new RuntimeException();
//    }
//
//    @Override
//    public Object visitFuncFieldsBody(FuncFieldsBodyContext ctx) {
//        TypeComponent funcType = visitFuncType(ctx.funcType());
//        List<ValueType> localTypes = new ArrayList<>();
//        for (FuncLocalTypesContext types : ctx.funcLocalTypes()) {
//            localTypes.addAll(visitFuncLocalTypes(types));
//        }
//        //return visitFuncBody(ctx.funcBody());
//        functions.add(new FunctionComponent(0, immutable(localTypes), null));
//        return null;
//    }
//
//    @Override
//    public Object visitOffset(OffsetContext ctx) {
//        throw new UnsupportedOperationException();
//    }
//
//    @Override
//    public Object visitElem(ElemContext ctx) {
//        throw new UnsupportedOperationException();
//    }
//
//    @Override
//    public Object visitTable(TableContext ctx) {
//        // done
//        visitTableFields(ctx.tableFields());
//        BindVarContext var = ctx.bindVar();
//        if (var != null) {
//            tableIndexes.put(visitBindVar(var), tables.size() - 1);
//        }
//        return null;
//    }
//
//    @Override
//    public Object visitTableFields(TableFieldsContext ctx) {
//        // done
//        TableTypeContext type = ctx.tableType();
//        if (type != null) {
//            return visitTableType(type);
//        } else {
//            throw new UnsupportedOperationException();
//        }
//    }
//
//    @Override
//    public Object visitData(DataContext ctx) {
//        // done
//        int index = visitVariableIndex(ctx.var(), memoryIndexes);
//        if (index != 0) {
//            throw new UnsupportedOperationException();
//        }
//        //visitOffset(ctx.offset());
//        StringBuilder sb = new StringBuilder();
//        for (TerminalNode string : ctx.STRING()) {
//            String text = string.getText();
//            sb.append(text, 1, text.length() - 1);
//        }
//        return new DataSegment(null, sb.toString().getBytes(StandardCharsets.UTF_8));
//    }
//
//    @Override
//    public Object visitMemory(MemoryContext ctx) {
//        // done
//        visitMemoryFields(ctx.memoryFields());
//        BindVarContext var = ctx.bindVar();
//        if (var != null) {
//            memoryIndexes.put(visitBindVar(var), memories.size() - 1);
//        }
//        return null;
//    }
//
//    @Override
//    public Object visitMemoryFields(MemoryFieldsContext ctx) {
//        // done
//        MemoryTypeContext type = ctx.memoryType();
//        if (type != null) {
//            return visitMemoryType(type);
//        } else {
//            throw new UnsupportedOperationException();
//        }
//    }
//
//    @Override
//    public Object visitGlobal(GlobalContext ctx) {
//        throw new UnsupportedOperationException();
//    }
//
//    @Override
//    public Object visitGlobalFields(GlobalFieldsContext ctx) {
//        throw new UnsupportedOperationException();
//    }
//
//    @Override
//    public Object visitImportDesc(ImportDescContext ctx) {
//        throw new UnsupportedOperationException();
//    }
//
//    @Override
//    public Object visitModuleImport(ModuleImportContext ctx) {
//        throw new UnsupportedOperationException();
//    }
//
//    @Override
//    public Object visitInlineImport(InlineImportContext ctx) {
//        throw new UnsupportedOperationException();
//    }
//
//    @Override
//    public Export visitExportDesc(ExportDescContext ctx) {
//        // done
//        String name = visitName(((ModuleExportContext)ctx.parent).name());
//        if (ctx.FUNC() != null) {
//            return new Export.Function(name, visitVariableIndex(ctx.var(), functionIndexes));
//        }
//        if (ctx.TABLE() != null) {
//            return new Export.Table(name, visitVariableIndex(ctx.var(), tableIndexes));
//        }
//        if (ctx.MEMORY() != null) {
//            return new Export.Memory(name, visitVariableIndex(ctx.var(), memoryIndexes));
//        }
//        if (ctx.GLOBAL() != null) {
//            return new Export.Global(name, visitVariableIndex(ctx.var(), globalIndexes));
//        }
//        throw new UnsupportedOperationException();
//    }
//
//    @Override
//    public Object visitModuleExport(ModuleExportContext ctx) {
//        // done
//        exports.add(visitExportDesc(ctx.exportDesc()));
//        return null;
//    }
//
//    @Override
//    public Object visitInlineExport(InlineExportContext ctx) {
//        throw new UnsupportedOperationException();
//    }
//
//    @Override
//    public Object visitTypeDef(TypeDefContext ctx) {
//        // done
//        BindVarContext var = ctx.bindVar();
//        types.add(visitFuncType(ctx.funcType()));
//        if (var != null) {
//            typeIndexes.put(visitBindVar(var), types.size() - 1);
//        }
//        return null;
//    }
//
//    @Override
//    public Object visitStart(StartContext ctx) {
//        // done
//        int index = visitVariableIndex(ctx.var(), functionIndexes);
//        if (start == null) {
//            start = index;
//            return null;
//        } else {
//            throw new RuntimeException();
//        }
//    }
//
//    @Override
//    public Object visitModuleField(ModuleFieldContext ctx) {
//        // done
//        return visitChildren(ctx);
//    }
//
//    @Override
//    public Object visitModuleDef(ModuleDefContext ctx) {
//        // done
//        // ignore ctx.VAR()
//        visitModuleFields(ctx.moduleField());
//        return null;
//    }
//
//    @Override
//    public Object visitModule(ModuleContext ctx) {
//        // done
//        ModuleDefContext moduleDef = ctx.moduleDef();
//        if (moduleDef != null) {
//            visitModuleDef(moduleDef);
//        } else {
//            // 6.6.13.1. Abbreviations
//            // In a source file, the toplevel (module ...) surrounding the module body may be omitted.
//            visitModuleFields(ctx.moduleField());
//        }
//        return null;
//    }
//
//    private void visitModuleFields(List<ModuleFieldContext> contexts) {
//        // done
//        for (ModuleFieldContext ctx : contexts) {
//            if (ctx.moduleExport() == null && ctx.start() == null) {
//                visit(ctx);
//            }
//        }
//        for (ModuleFieldContext ctx : contexts) {
//            if (ctx.moduleExport() != null) {
//                visit(ctx);
//            }
//        }
//        for (ModuleFieldContext ctx : contexts) {
//            if (ctx.start() != null) {
//                visit(ctx);
//            }
//        }
//    }
//
//    private int visitVariableIndex(VarContext ctx, Map<String, Integer> indexes) {
//        if (ctx == null) {
//            return 0;
//        }
//        TerminalNode nat = ctx.NAT();
//        if (nat != null) {
//            return visitUnsignedInteger(nat);
//        }
//        TerminalNode var = ctx.VAR();
//        if (var != null) {
//            Integer index = indexes.get(var.getText());
//            if (index != null) {
//                return index;
//            } else {
//                // assert
//                throw new RuntimeException();
//            }
//        }
//        throw new RuntimeException();
//    }
//
//    private Integer visitUnsignedInteger(TerminalNode node) {
//        if (node == null) {
//            return null;
//        }
//        String text = node.getText().replace("_", "");
//        if (text.startsWith("0x")) {
//            return Integer.parseInt(text.substring(2), 8);
//        }
//        return Integer.parseInt(text);
//    }
//
//    @SuppressWarnings("unchecked")
//    private static <T> List<T> immutable(List<T> list) {
//        int size = list.size();
//        if (size == 0) {
//            return Collections.emptyList();
//        }
//        if (size == 1) {
//            return Collections.singletonList(list.get(0));
//        }
//        return (List<T>)Arrays.asList(list.toArray(new Object[size]));
//    }
//}
