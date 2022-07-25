package io.xjava.wasm.visitor;

import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.*;

import io.xjava.wasm.parser.WatParserVisitor;
import io.xjava.wasm.structure.WebAssemblyModule;
import io.xjava.wasm.structure.instruction.Expression;
import io.xjava.wasm.structure.instruction.Instruction;
import io.xjava.wasm.structure.instruction.OpCode;
import io.xjava.wasm.structure.module.*;
import io.xjava.wasm.structure.type.*;

import static io.xjava.wasm.parser.WatParser.*;
import static io.xjava.wasm.visitor.LiteralVisitor.*;

/**
 * <h3>2.5 Modules</h3>
 * WebAssembly programs are organized into modules, which are the unit of
 * deployment, loading, and compilation. A module collects definitions for
 * types, functions, tables, memories, and globals. In addition, it can
 * declare imports and exports and provide initialization in the form of
 * data and element segments, or a start function.
 *
 * @author AlphaLxy
 */
public class WatModuleParserVisitor extends AbstractParseTreeVisitor<Object> implements WatParserVisitor<Object> {

    private final List<Type> types = new ArrayList<>();
    private final List<Function> functions = new ArrayList<>();
    private final List<Table> tables = new ArrayList<>();
    private final List<Memory> memories = new ArrayList<>();
    private final List<Global> globals = new ArrayList<>();
    private final List<Import> imports = new ArrayList<>();
    private final List<Export> exports = new ArrayList<>();
    private final List<DataSegment> dataSegments = new ArrayList<>();
    private final List<ElementSegment> elementSegments = new ArrayList<>();
    private Integer start;

    private final Map<String, Integer> typeIndexes = new HashMap<>();
    private final Map<String, Integer> functionIndexes = new HashMap<>();
    private final Map<String, Integer> tableIndexes = new HashMap<>();
    private final Map<String, Integer> memoryIndexes = new HashMap<>();
    private final Map<String, Integer> globalIndexes = new HashMap<>();
    private final Map<String, Integer> dataIndexes = new HashMap<>();
    private final Map<String, Integer> elementIndexes = new HashMap<>();

    @Override
    public String visitId(IdContext ctx) {
        // id: ID
        return ctx.ID().getText();
    }

    private int visitIndex(IndexContext ctx, Map<String, Integer> indexes, List<?> components) {
        // index: ID | INTEGER
        TerminalNode integer = ctx.INTEGER();
        if (integer != null) {
            int index = visitUnsignedInteger(integer);
            if (index >= components.size()) {
                throw new RuntimeException("TODO");
            }
            return index;
        }
        Integer index = indexes.get(ctx.ID().getText());
        if (index != null) {
            return index;
        } else {
            throw new RuntimeException("TODO");
        }
    }

    @Override
    public Integer visitTypeIndex(TypeIndexContext ctx) {
        // typeIndex: index
        return visitIndex(ctx.index(), typeIndexes, types);
    }

    @Override
    public Integer visitFunctionIndex(FunctionIndexContext ctx) {
        // functionIndex: index
        return visitIndex(ctx.index(), functionIndexes, functions);
    }

    @Override
    public Integer visitTableIndex(TableIndexContext ctx) {
        // table index can be omitted, defaulting to 0
        if (ctx == null) {
            return 0;
        }
        // tableIndex: index
        return visitIndex(ctx.index(), tableIndexes, tables);
    }

    @Override
    public Integer visitMemoryIndex(MemoryIndexContext ctx) {
        // memoryIndex: index
        return visitIndex(ctx.index(), memoryIndexes, memories);
    }

    @Override
    public Integer visitGlobalIndex(GlobalIndexContext ctx) {
        // globalIndex: index
        return visitIndex(ctx.index(), globalIndexes, globals);
    }

    @Override
    public Integer visitElementIndex(ElementIndexContext ctx) {
        // elementIndex: index
        return visitIndex(ctx.index(), elementIndexes, elementSegments);
    }

    @Override
    public Integer visitDataIndex(DataIndexContext ctx) {
        // dataIndex: index
        return visitIndex(ctx.index(), dataIndexes, dataSegments);
    }

    @Override
    public Integer visitLocalIndex(LocalIndexContext ctx) {
        // done
        //throw new UnsupportedOperationException();
        return 0;
    }

    @Override
    public Integer visitLabelIndex(LabelIndexContext ctx) {
        // done
        //throw new UnsupportedOperationException();
        return 0;
    }

    @Override
    public String visitName(NameContext ctx) {
        // name: STRING
        return visitString(ctx.STRING().getText());
    }

    @Override
    public String visitDataString(DataStringContext ctx) {
        // dataString: STRING*
        int length = 0;
        for (TerminalNode string : ctx.STRING()) {
            // enclosed in quotation marks
            length += string.getText().length() - 2;
        }
        // prevent array expand
        StringBuilder sb = new StringBuilder(length);
        for (TerminalNode string : ctx.STRING()) {
            visitString(string.getText(), sb);
        }
        return sb.toString();
    }

    private int visitFloatNumber(NumberContext ctx) {
        TerminalNode integer = ctx.INTEGER();
        if (integer != null) {
            return Float.floatToIntBits(visitInteger(integer).floatValue());
        }
        return visitFloat(ctx.FLOAT().getText());
    }

    private long visitDoubleNumber(NumberContext ctx) {
        TerminalNode integer = ctx.INTEGER();
        if (integer != null) {
            return Double.doubleToLongBits(visitInteger(integer).doubleValue());
        }
        return visitDouble(ctx.FLOAT().getText());
    }

    @Override
    public ReferenceType visitRefType(RefTypeContext ctx) {
        // done
        String text = ctx.REF_TYPE().getText();
        if ("funcref".equals(text)) {
            return ReferenceType.FUNC_REF;
        } else if ("externref".equals(text)) {
            return ReferenceType.EXTERN_REF;
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public ReferenceType visitHeapType(HeapTypeContext ctx) {
        // done
        String text = ctx.getChild(0).getText();
        if ("func".equals(text)) {
            return ReferenceType.FUNC_REF;
        } else if ("extern".equals(text)) {
            return ReferenceType.EXTERN_REF;
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public ValueType visitValueType(ValueTypeContext ctx) {
        // done
        switch (ctx.getText()) {
            case "i32":
                return NumberType.I32;
            case "i64":
                return NumberType.I64;
            case "f32":
                return NumberType.F32;
            case "f64":
                return NumberType.F64;
            case "v128":
                return VectorType.V128;
            case "funcref":
                return ReferenceType.FUNC_REF;
            case "externref":
                return ReferenceType.EXTERN_REF;
            default:
                throw new UnsupportedOperationException();
        }
    }

    private List<ValueType> visitValueType(List<ValueTypeContext> types) {
        // done
        ValueType[] valueTypes = new ValueType[types.size()];
        for (int i = 0; i < types.size(); i++) {
            valueTypes[i] = visitValueType(types.get(i));
        }
        return Arrays.asList(valueTypes);
    }

    @Override
    public VectorType visitVecType(VecTypeContext ctx) {
        // done
        return VectorType.valueOf(ctx.VEC_TYPE().getText().toUpperCase());
    }

    @Override
    public VectorShape visitVecShape(VecShapeContext ctx) {
        // done
        return VectorShape.valueOf(ctx.VEC_SHAPE().getText().toUpperCase());
    }

    @Override
    public Type visitFuncType(FuncTypeContext ctx) {
        // done
        return new Type(visitFuncType(ctx.param(), ctx.result()));
    }

    private FunctionType visitFuncType(List<ParamContext> param, List<ResultContext> result) {
        // done
        List<ValueType> parameterTypes = new ArrayList<>();
        List<ValueType> resultTypes = new ArrayList<>();
        for (ParamContext types : param) {
            parameterTypes.addAll(visitParam(types));
        }
        for (ResultContext types : result) {
            resultTypes.addAll(visitResult(types));
        }
        return new FunctionType(immutable(parameterTypes), immutable(resultTypes));
    }

    @Override
    public List<ValueType> visitResult(ResultContext ctx) {
        // done
        return visitValueType(ctx.valueType());
    }

    @Override
    public List<ValueType> visitParam(ParamContext ctx) {
        // done
        // TODO
        // visitId(ctx.id());
        return visitValueType(ctx.valueType());
    }

    @Override
    public List<ValueType> visitLocal(LocalContext ctx) {
        // done
        // TODO
        // visitId(ctx.id());
        return visitValueType(ctx.valueType());
    }

    @Override
    public MemoryType visitMemType(MemTypeContext ctx) {
        // done
        int min = visitUnsignedInteger(ctx.INTEGER(0));
        TerminalNode max = ctx.INTEGER(1);
        return new MemoryType(min, max == null ? null : visitUnsignedInteger(max));
    }

    @Override
    public TableType visitTableType(TableTypeContext ctx) {
        // done
        int min = visitUnsignedInteger(ctx.INTEGER(0));
        TerminalNode max = ctx.INTEGER(1);
        return new TableType(min, max == null ? null : visitUnsignedInteger(max), visitRefType(ctx.refType()));
    }

    @Override
    public GlobalType visitGlobalType(GlobalTypeContext ctx) {
        // done
        ValueType valueType = visitValueType(ctx.valueType());
        return new GlobalType(ctx.MUT() != null, valueType);
    }

    @Override
    public String visitLabel(LabelContext ctx) {
        // TODO
        //throw new RuntimeException();
        return "null";
    }

    @Override
    public BlockType visitBlockType(BlockTypeContext ctx) {
        TypeUseContext typeUse = ctx.typeUse();
        if (typeUse != null) {
            return BlockType.of(visitTypeUse(typeUse));
        }
        ResultContext result = ctx.result();
        if (result != null) {
            FunctionType functionType = visitFuncType(Collections.emptyList(), Collections.singletonList(result));
            if (functionType.getParameterTypes().isEmpty()) {
                // TODO code
                List<ValueType> resultTypes = functionType.getResultTypes();
                if (resultTypes.isEmpty()) {
                    return BlockType.of(null);
                }
                if (resultTypes.size() == 1) {
                    return BlockType.of(resultTypes.get(0));
                }
            }
            // TODO 是否需要判断重复
            types.add(new Type(functionType));
            return BlockType.of(types.size() - 1);
        }
        return BlockType.of(null);
    }

    @Override
    public Instruction visitBlockInstr(BlockInstrContext ctx) {
        OpCode opCode = getOpCode((TerminalNode)ctx.getChild(0));
        // TODO id
        return visitBlockInstr(opCode, ctx.label(), ctx.blockType(), ctx.expr(0), ctx.expr(1));
    }

    private Instruction visitBlockInstr(OpCode opCode, LabelContext label, BlockTypeContext blockType,
                                        ExprContext expression0, ExprContext expression1) {
        switch (opCode) {
            case BLOCK:
            case LOOP:
                return Instruction.of(opCode, visitLabel(label), visitBlockType(blockType), visitExpr(expression0));
            case IF:
                Expression ifExpression = visitExpr(expression0);
                Expression elseExpression = expression1 == null ? null : visitExpr(expression1);
                return Instruction.of(OpCode.IF, visitLabel(label), visitBlockType(blockType), ifExpression,
                    elseExpression);
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override
    public int[] visitMemArg(MemArgContext ctx) {
        // done
        int[] memArgs = new int[2];
        TerminalNode align = ctx.MEM_ALIGN();
        if (align != null) {
            String text = align.getText();
            memArgs[0] = visitUnsignedInteger(text.substring(text.indexOf('=') + 1));
        }
        TerminalNode offset = ctx.MEM_OFFSET();
        if (offset != null) {
            String text = offset.getText();
            memArgs[0] = visitUnsignedInteger(text.substring(text.indexOf('=') + 1));
        }
        return memArgs;
    }

    @Override
    public Instruction visitPlainInstr(PlainInstrContext ctx) {
        return (Instruction)ctx.getChild(0).accept(this);
    }

    @Override
    public Instruction visitControlInstr(ControlInstrContext ctx) {
        OpCode opCode = getOpCode((TerminalNode)ctx.getChild(0));
        switch (opCode) {
            case UNREACHABLE:
            case NOP:
            case RETURN:
                return Instruction.of(opCode);
            case BR:
            case BR_IF:
                return Instruction.of(opCode, visitLabelIndex(ctx.labelIndex(0)));
            case BR_TABLE:
                List<LabelIndexContext> contexts = ctx.labelIndex();
                int[] indexes = new int[contexts.size()];
                for (int i = 0; i < contexts.size(); i++) {
                    indexes[i] = visitLabelIndex(contexts.get(i));
                }
                return Instruction.of(opCode, indexes);
            case CALL:
                return Instruction.of(opCode, visitFunctionIndex(ctx.functionIndex()));
            case CALL_INDIRECT:
                return Instruction.of(opCode, visitTableIndex(ctx.tableIndex()), visitTypeUse(ctx.typeUse()));
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override
    public Instruction visitReferenceInstr(ReferenceInstrContext ctx) {
        OpCode opCode = getOpCode((TerminalNode)ctx.getChild(0));
        switch (opCode) {
            case REF_NULL:
                return Instruction.of(opCode, visitHeapType(ctx.heapType()));
            case REF_IS_NULL:
                return Instruction.of(opCode);
            case REF_FUNC:
                return Instruction.of(opCode, visitFunctionIndex(ctx.functionIndex()));
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override
    public Instruction visitParametricInstr(ParametricInstrContext ctx) {
        OpCode opCode = getOpCode((TerminalNode)ctx.getChild(0));
        switch (opCode) {
            case DROP:
                return Instruction.of(opCode);
            case SELECT:
                List<ResultContext> result = ctx.result();
                if (result.isEmpty()) {
                    return Instruction.of(opCode);
                }
                List<ValueType> resultTypes = new ArrayList<>();
                for (ResultContext types : result) {
                    resultTypes.addAll(visitResult(types));
                }
                return Instruction.of(OpCode.SELECT_TYPES, resultTypes.toArray(new ValueType[0]));
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override
    public Instruction visitVariableInstr(VariableInstrContext ctx) {
        OpCode opCode = getOpCode((TerminalNode)ctx.getChild(0));
        switch (opCode) {
            case LOCAL_GET:
            case LOCAL_SET:
            case LOCAL_TEE:
                return Instruction.of(opCode, visitLocalIndex(ctx.localIndex()));
            case GLOBAL_GET:
            case GLOBAL_SET:
                return Instruction.of(opCode, visitGlobalIndex(ctx.globalIndex()));
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override
    public Instruction visitTableInstr(TableInstrContext ctx) {
        OpCode opCode = getOpCode((TerminalNode)ctx.getChild(0));
        switch (opCode) {
            case TABLE_GET:
            case TABLE_SET:
            case TABLE_GROW:
            case TABLE_SIZE:
            case TABLE_FILL:
                return Instruction.of(opCode, visitTableIndex(ctx.tableIndex(0)));
            case TABLE_INIT:
                Integer elementIndex = visitElementIndex(ctx.elementIndex());
                return Instruction.of(opCode, visitTableIndex(ctx.tableIndex(0)), elementIndex);
            case ELEM_DROP:
                return Instruction.of(opCode, visitElementIndex(ctx.elementIndex()));
            case TABLE_COPY:
                int index0 = visitTableIndex(ctx.tableIndex(0));
                int index1 = visitTableIndex(ctx.tableIndex(1));
                return Instruction.of(opCode, index0, index1);
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override
    public Instruction visitMemoryInstr(MemoryInstrContext ctx) {
        OpCode opCode = getOpCode((TerminalNode)ctx.getChild(0));
        String name = opCode.name();
        TerminalNode integer = ctx.INTEGER();
        if (name.contains("STORE") || name.contains("LOAD")) {
            int[] memArg = visitMemArg(ctx.memArg());
            if (integer != null) {
                byte laneIndex = visitInteger(integer).byteValueExact();
                return Instruction.of(opCode, new int[] {memArg[0], memArg[1], laneIndex});
            }
            return Instruction.of(opCode, memArg[0], memArg[1]);
        }
        switch (opCode) {
            case MEMORY_SIZE:
            case MEMORY_GROW:
            case MEMORY_FILL:
                return Instruction.of(opCode, 0);
            case DATA_DROP:
                return Instruction.of(opCode, visitDataIndex(ctx.dataIndex()));
            case MEMORY_COPY:
                return Instruction.of(opCode, 0, 0);
            case MEMORY_INIT:
                return Instruction.of(opCode, visitDataIndex(ctx.dataIndex()), 0);
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override
    public Instruction visitNumericInstr(NumericInstrContext ctx) {
        OpCode opCode = getOpCode((TerminalNode)ctx.getChild(0));
        switch (opCode) {
            case I32_CONST:
                BigInteger i32 = visitInteger(ctx.INTEGER());
                if (i32.bitLength() > 32) {
                    throw new ArithmeticException("i32 value out of range");
                }
                return Instruction.of(NumberType.I32, i32.intValue());
            case I64_CONST:
                BigInteger i64 = visitInteger(ctx.INTEGER());
                if (i64.bitLength() > 64) {
                    throw new ArithmeticException("i64 value out of range");
                }
                return Instruction.of(NumberType.I64, i64.longValue());
            case F32_CONST:
                return Instruction.of(NumberType.F32, visitFloatNumber(ctx.number()));
            case F64_CONST:
                return Instruction.of(NumberType.F64, visitDoubleNumber(ctx.number()));
            default:
                return Instruction.of(opCode);
        }
    }

    @Override
    public Instruction visitVectorInstr(VectorInstrContext ctx) {
        // done
        OpCode opCode = getOpCode((TerminalNode)ctx.getChild(0));
        switch (opCode) {
            case V128_CONST:
                List<NumberContext> numbers = ctx.number();
                List<String> lanes = new ArrayList<>(numbers.size());
                for (NumberContext number : numbers) {
                    lanes.add(number.getChild(0).getText());
                }
                BigInteger bigInteger = visitVectorConst(VectorType.V128, visitVecShape(ctx.vecShape()), lanes);
                return Instruction.of(VectorType.V128, 0);
            case I8X16_SHUFFLE:
                List<TerminalNode> nodes = ctx.INTEGER();
                int[] indexes = new int[nodes.size()];
                for (int i = 0; i < nodes.size(); i++) {
                    indexes[i] = visitInteger(nodes.get(i)).byteValueExact();
                }
                return Instruction.of(opCode, indexes);
            default:
                TerminalNode node = ctx.INTEGER(0);
                if (node != null) {
                    byte laneIndex = visitInteger(node).byteValueExact();
                    return Instruction.of(opCode, laneIndex);
                } else {
                    return Instruction.of(opCode);
                }
        }
    }

    @Override
    public Instruction visitInstr(InstrContext ctx) {
        if (ctx.BLOCK() != null) {
            return visitBlockInstr(OpCode.BLOCK, ctx.label(), ctx.blockType(), ctx.expr(0), null);
        }
        if (ctx.LOOP() != null) {
            return visitBlockInstr(OpCode.LOOP, ctx.label(), ctx.blockType(), ctx.expr(0), null);
        }
        if (ctx.IF() != null) {
            Expression condition = visitExpr(ctx.expr(0));
            List<Instruction> instructions = condition.getInstructions();
            List<Instruction> block = new ArrayList<>(instructions.size() + 1);
            block.addAll(instructions);
            block.add(visitBlockInstr(OpCode.IF, ctx.label(), ctx.blockType(), ctx.expr(1), ctx.expr(2)));
            return Instruction.of(OpCode.BLOCK, null, null, new Expression(immutable(block)));
        }
        BlockInstrContext blockInstr = ctx.blockInstr();
        if (blockInstr != null) {
            return visitBlockInstr(blockInstr);
        }
        PlainInstrContext plainInstr = ctx.plainInstr();
        if (plainInstr != null) {
            Instruction instruction = visitPlainInstr(plainInstr);
            if (ctx.expr(0) == null) {
                return instruction;
            }
            Expression expression = visitExpr(ctx.expr(0));
            List<Instruction> instructions = expression.getInstructions();
            List<Instruction> block = new ArrayList<>(instructions.size() + 1);
            block.addAll(instructions);
            block.add(instruction);
            return Instruction.of(OpCode.BLOCK, null, null, new Expression(immutable(block)));
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public Expression visitExpr(ExprContext ctx) {
        List<InstrContext> instructions = ctx.instr();
        List<Instruction> list = new ArrayList<>(instructions.size());
        for (InstrContext instr : instructions) {
            list.add(visitInstr(instr));
        }
        return new Expression(immutable(list));
    }

    @Override
    public WebAssemblyModule visitModule(ModuleContext ctx) {
        // done
        return visitModule(ctx.id(), ctx.moduleField());
    }

    public WebAssemblyModule visitModule(IdContext id, List<ModuleFieldContext> fields) {
        // TODO handle name
        // sort fields
        ArrayList<ModuleFieldContext> contexts = new ArrayList<>(fields);
        // visit fields
        contexts.sort(Comparator.comparing(this::visitModuleField));
        for (ModuleFieldContext field : contexts) {
            field.getChild(0).accept(this);
        }
        // visit expressions
        List<Global> visitedGlobals = new ArrayList<>();
        for (Global global : globals) {
            Expression init = global.getInit();
            if (init == null) {
                visitedGlobals.add(global);
            } else {
                Expression expression = visitExpr(((ExprHolder)init.getInstructions().get(0)).getExpr());
                visitedGlobals.add(new Global(global.getType(), expression));
            }
        }
        List<Function> visitedFunctions = new ArrayList<>();
        for (Function function : functions) {
            Expression body = function.getBody();
            if (body == null) {
                visitedFunctions.add(function);
            } else {
                Expression expression = visitExpr(((ExprHolder)body.getInstructions().get(0)).getExpr());
                visitedFunctions.add(new Function(function.getType(), function.getLocals(), expression));
            }
        }
        // build module
        return new WebAssemblyModule(
            immutable(types),
            immutable(visitedFunctions),
            immutable(tables),
            immutable(memories),
            immutable(visitedGlobals),
            immutable(imports),
            immutable(exports),
            immutable(dataSegments),
            immutable(elementSegments),
            start
        );
    }

    @Override
    public Integer visitModuleField(ModuleFieldContext ctx) {
        // done
        RuleContext child = (RuleContext)ctx.getChild(0);
        switch (child.getRuleIndex()) {
            case RULE_type:
                return 0;
            case RULE_moduleImport:
                return 1;
            case RULE_func:
                return 2;
            case RULE_table:
                return 3;
            case RULE_mem:
                return 4;
            case RULE_global:
                return 5;
            case RULE_moduleExport:
                return 6;
            case RULE_start:
                return 7;
            case RULE_elem:
                return 8;
            case RULE_data:
                return 9;
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override
    public Object visitType(TypeContext ctx) {
        // done
        Type type = visitFuncType(ctx.funcType());
        types.add(type);
        return putIndex(typeIndexes, ctx.id(), types.size() - 1);
    }

    @Override
    public Object visitFunc(FuncContext ctx) {
        // done
        return putIndex(functionIndexes, ctx.id(), visitFuncDesc(ctx.funcDesc()));
    }

    @Override
    public Object visitTable(TableContext ctx) {
        // done
        return putIndex(tableIndexes, ctx.id(), visitTableDesc(ctx.tableDesc()));
    }

    @Override
    public Object visitMem(MemContext ctx) {
        // done
        return putIndex(memoryIndexes, ctx.id(), visitMemDesc(ctx.memDesc()));
    }

    @Override
    public Object visitGlobal(GlobalContext ctx) {
        // done
        return putIndex(globalIndexes, ctx.id(), visitGlobalDesc(ctx.globalDesc()));
    }

    private Object putIndex(Map<String, Integer> indexes, IdContext ctx, Integer index) {
        // done
        if (index == null) {
            throw new RuntimeException();
        }
        if (ctx != null) {
            if (indexes.put(visitId(ctx), index) != null) {
                throw new RuntimeException();
            }
        }
        return null;
    }

    @Override
    public Object visitModuleImport(ModuleImportContext ctx) {
        // done
        imports.add(visitImportDesc(ctx.importDesc()));
        return null;
    }

    @Override
    public Object visitModuleExport(ModuleExportContext ctx) {
        // done
        exports.add(visitExportDesc(ctx.exportDesc()));
        return null;
    }

    @Override
    public Object visitStart(StartContext ctx) {
        // done
        int functionIndex = visitFunctionIndex(ctx.functionIndex());
        if (start == null) {
            start = functionIndex;
            return null;
        } else {
            throw new RuntimeException();
        }
    }

    @Override
    public Object visitElem(ElemContext ctx) {
        // done
        ReferenceType referenceType;
        List<Expression> init;
        ElemListContext elemList = ctx.elemList();
        if (elemList != null && elemList.refType() != null) {
            referenceType = visitRefType(elemList.refType());
            init = visitElemList(elemList);
        } else {
            referenceType = ReferenceType.FUNC_REF;
            init = visitFunctionIndexes(ctx.functionIndex());
        }
        ElementSegment segment;
        OffsetContext offset = ctx.offset();
        if (offset != null) {
            Integer index = visitTableUse(ctx.tableUse());
            segment = new ElementSegment(referenceType, init, ElementMode.ACTIVE, index, visitOffset(offset));
        } else if (ctx.DECLARE() != null) {
            segment = new ElementSegment(referenceType, init, ElementMode.DECLARATIVE, null, null);
        } else {
            segment = new ElementSegment(referenceType, init, ElementMode.PASSIVE, null, null);
        }
        elementSegments.add(segment);
        putIndex(elementIndexes, ctx.id(), elementSegments.size() - 1);
        return null;
    }

    private List<Expression> visitFunctionIndexes(List<FunctionIndexContext> indexes) {
        List<Expression> init = new ArrayList<>(indexes.size());
        for (FunctionIndexContext ctx : indexes) {
            Instruction instruction = Instruction.of(OpCode.REF_FUNC, visitFunctionIndex(ctx));
            init.add(new Expression(Collections.singletonList(instruction)));
        }
        return immutable(init);
    }

    @Override
    public Void visitData(DataContext ctx) {
        // done
        byte[] bytes = visitDataString(ctx.dataString()).getBytes(StandardCharsets.UTF_8);
        DataSegment dataSegment;
        MemUseContext memUse = ctx.memUse();
        if (memUse != null) {
            dataSegment = new DataSegment(bytes, visitMemUse(memUse), visitOffset(ctx.offset()));
        } else {
            dataSegment = new DataSegment(bytes);
        }
        dataSegments.add(dataSegment);
        putIndex(dataIndexes, ctx.id(), dataSegments.size() - 1);
        return null;
    }

    @Override
    public Expression visitOffset(OffsetContext ctx) {
        ExprContext expr = ctx.expr();
        if (expr != null) {
            return visitExpr(expr);
        }
        Instruction instruction = visitInstr(ctx.instr());
        return new Expression(Collections.singletonList(instruction));
    }

    @Override
    public Expression visitItem(ItemContext ctx) {
        ExprContext expr = ctx.expr();
        if (expr != null) {
            return visitExpr(expr);
        }
        Instruction instruction = visitInstr(ctx.instr());
        return new Expression(Collections.singletonList(instruction));
    }

    public List<Expression> visitItems(List<ItemContext> items) {
        List<Expression> expressions = new ArrayList<>();
        for (ItemContext item : items) {
            expressions.add(visitItem(item));
        }
        return immutable(expressions);
    }

    @Override
    public String[] visitInlineImport(InlineImportContext ctx) {
        // done
        String module = visitName(ctx.name(0));
        String name = visitName(ctx.name(1));
        return new String[] {module, name};
    }

    @Override
    public String visitInlineExport(InlineExportContext ctx) {
        // done
        return visitName(ctx.name());
    }

    @Override
    public Integer visitMemUse(MemUseContext ctx) {
        // done
        if (ctx == null) {
            return 0;
        }
        return visitMemoryIndex(ctx.memoryIndex());
    }

    @Override
    public Integer visitTableUse(TableUseContext ctx) {
        // done
        if (ctx == null) {
            return 0;
        }
        return visitTableIndex(ctx.tableIndex());
    }

    @Override
    public Integer visitTypeUse(TypeUseContext ctx) {
        // done
        FunctionType functionType = visitFuncType(ctx.param(), ctx.result());
        TypeIndexContext index = ctx.typeIndex();
        if (index == null) {
            // TODO 是否需要判断重复
            types.add(new Type(functionType));
            return types.size() - 1;
        } else {
            int typeIndex = visitTypeIndex(index);
            // all empty
            if (functionType.getParameterTypes().isEmpty() && functionType.getResultTypes().isEmpty()) {
                return typeIndex;
            }
            FunctionType visitedFunctionType = types.get(typeIndex).getType();
            if (functionType.equals(visitedFunctionType)) {
                return typeIndex;
            }
            throw new RuntimeException();
        }
    }

    @Override
    public Integer visitFuncDesc(FuncDescContext ctx) {
        // done
        InlineExportContext inlineExport = ctx.inlineExport();
        if (inlineExport != null) {
            Integer index = visitFuncDesc(ctx.funcDesc());
            exports.add(new Export.Function(visitInlineExport(inlineExport), index));
            return index;
        }
        int index = visitTypeUse(ctx.typeUse());
        List<ValueType> localTypes = new ArrayList<>();
        for (LocalContext local : ctx.local()) {
            localTypes.addAll(visitLocal(local));
        }
        Function function;
        InlineImportContext inlineImport = ctx.inlineImport();
        if (inlineImport != null) {
            // TODO
            function = new Function(index, immutable(localTypes), null);
            String[] moduleAndName = visitInlineImport(inlineImport);
            imports.add(new Import.Function(moduleAndName[0], moduleAndName[1], index));
        } else {
            Expression body = new Expression(Collections.singletonList(new ExprHolder(ctx.expr())));
            function = new Function(index, immutable(localTypes), body);
        }
        functions.add(function);
        return functions.size() - 1;
    }

    @Override
    public Integer visitTableDesc(TableDescContext ctx) {
        // done
        InlineExportContext inlineExport = ctx.inlineExport();
        if (inlineExport != null) {
            Integer index = visitTableDesc(ctx.tableDesc());
            exports.add(new Export.Table(visitInlineExport(inlineExport), index));
            return index;
        }

        Table table;
        RefTypeContext refType = ctx.refType();
        if (refType != null) {
            int index = tables.size();
            ReferenceType referenceType = visitRefType(refType);
            List<ItemContext> items = ctx.item();
            List<FunctionIndexContext> indexes = ctx.functionIndex();
            List<Expression> init;
            if (!items.isEmpty()) {
                init = visitItems(items);
            } else if (!indexes.isEmpty()) {
                init = visitFunctionIndexes(indexes);
            } else {
                init = Collections.emptyList();
            }
            elementSegments.add(new ElementSegment(referenceType, init, ElementMode.ACTIVE, index, null));
            TableType tableType = new TableType(index, index, referenceType);
            table = new Table(tableType);
        } else {
            table = new Table(visitTableType(ctx.tableType()));
        }
        InlineImportContext inlineImport = ctx.inlineImport();
        if (inlineImport != null) {
            String[] moduleAndName = visitInlineImport(inlineImport);
            imports.add(new Import.Table(moduleAndName[0], moduleAndName[1], table.getType()));
        }
        tables.add(table);
        return tables.size() - 1;
    }

    @Override
    public Integer visitMemDesc(MemDescContext ctx) {
        // done
        InlineExportContext inlineExport = ctx.inlineExport();
        if (inlineExport != null) {
            Integer index = visitMemDesc(ctx.memDesc());
            exports.add(new Export.Memory(visitInlineExport(inlineExport), index));
            return index;
        }
        Memory memory;
        DataStringContext dataString = ctx.dataString();
        if (dataString != null) {
            int index = memories.size();
            MemoryType memoryType = new MemoryType(index, index);
            byte[] init = visitDataString(dataString).getBytes(StandardCharsets.UTF_8);
            dataSegments.add(new DataSegment(init, index, null));
            memory = new Memory(memoryType);
        } else {
            memory = new Memory(visitMemType(ctx.memType()));
        }
        InlineImportContext inlineImport = ctx.inlineImport();
        if (inlineImport != null) {
            String[] moduleAndName = visitInlineImport(inlineImport);
            imports.add(new Import.Memory(moduleAndName[0], moduleAndName[1], memory.getType()));
        }
        memories.add(memory);
        return memories.size() - 1;
    }

    @Override
    public Integer visitGlobalDesc(GlobalDescContext ctx) {
        // done
        InlineExportContext inlineExport = ctx.inlineExport();
        if (inlineExport != null) {
            Integer index = visitGlobalDesc(ctx.globalDesc());
            exports.add(new Export.Global(visitInlineExport(inlineExport), index));
            return index;
        }
        GlobalType globalType = visitGlobalType(ctx.globalType());
        Global global;
        ExprContext expr = ctx.expr();
        if (expr != null) {
            global = new Global(globalType, new Expression(Collections.singletonList(new ExprHolder(expr))));
        } else {
            global = new Global(globalType, null);
        }
        InlineImportContext inlineImport = ctx.inlineImport();
        if (inlineImport != null) {
            String[] moduleAndName = visitInlineImport(inlineImport);
            imports.add(new Import.Global(moduleAndName[0], moduleAndName[1], globalType));
        }
        globals.add(global);
        return globals.size() - 1;
    }

    @Override
    public Import visitImportDesc(ImportDescContext ctx) {
        // done
        ModuleImportContext moduleImport = (ModuleImportContext)ctx.parent;
        String module = visitName(moduleImport.name(0));
        String name = visitName(moduleImport.name(0));
        if (ctx.FUNC() != null) {
            Integer index = visitTypeUse(ctx.typeUse());
            Function function = new Function(index, Collections.emptyList(), null);
            functions.add(function);
            putIndex(functionIndexes, ctx.id(), functions.size() - 1);
            return new Import.Function(module, name, index);
        }
        if (ctx.TABLE() != null) {
            TableType type = visitTableType(ctx.tableType());
            tables.add(new Table(type));
            putIndex(tableIndexes, ctx.id(), tables.size() - 1);
            // TODO need copy?
            return new Import.Table(module, name, type);
        }
        if (ctx.MEMORY() != null) {
            MemoryType type = visitMemType(ctx.memType());
            memories.add(new Memory(type));
            putIndex(memoryIndexes, ctx.id(), memories.size() - 1);
            // TODO need copy?
            return new Import.Memory(module, name, type);
        }
        if (ctx.GLOBAL() != null) {
            GlobalType type = visitGlobalType(ctx.globalType());
            globals.add(new Global(type, null));
            putIndex(globalIndexes, ctx.id(), globals.size() - 1);
            return new Import.Global(module, name, visitGlobalType(ctx.globalType()));
        }
        throw new RuntimeException();
    }

    @Override
    public Export visitExportDesc(ExportDescContext ctx) {
        // done
        ModuleExportContext moduleExport = (ModuleExportContext)ctx.parent;
        String name = visitName(moduleExport.name());
        if (ctx.FUNC() != null) {
            return new Export.Function(name, visitFunctionIndex(ctx.functionIndex()));
        }
        if (ctx.TABLE() != null) {
            return new Export.Table(name, visitTableIndex(ctx.tableIndex()));
        }
        if (ctx.MEMORY() != null) {
            return new Export.Memory(name, visitMemoryIndex(ctx.memoryIndex()));
        }
        if (ctx.GLOBAL() != null) {
            return new Export.Global(name, visitGlobalIndex(ctx.globalIndex()));
        }
        throw new RuntimeException();
    }

    @Override
    public List<Expression> visitElemList(ElemListContext ctx) {
        // done
        RefTypeContext refType = ctx.refType();
        if (refType != null) {
            return visitItems(ctx.item());
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public WebAssemblyModule visitScript(ScriptContext ctx) {
        // done
        List<CommandContext> commands = ctx.command();
        if (commands.isEmpty()) {
            return visitModule(null, ctx.moduleField());
        }
        if (commands.size() > 1) {
            throw new UnsupportedOperationException();
        }
        return visitCommand(commands.get(0));
    }

    @Override
    public WebAssemblyModule visitCommand(CommandContext ctx) {
        // done
        ScriptModuleContext scriptModule = ctx.scriptModule();
        if (scriptModule != null) {
            return visitScriptModule(scriptModule);
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public WebAssemblyModule visitScriptModule(ScriptModuleContext ctx) {
        // done
        if (ctx.BINARY() != null) {
            // TODO
            throw new UnsupportedOperationException();
        }
        if (ctx.QUOTE() != null) {
            // TODO
            throw new UnsupportedOperationException();
        }
        return visitModule(ctx.id(), ctx.moduleField());
    }

    @SuppressWarnings("unchecked")
    static <T> List<T> immutable(List<T> list) {
        int size = list.size();
        if (size == 0) {
            return Collections.emptyList();
        }
        if (size == 1) {
            return Collections.singletonList(list.get(0));
        }
        return (List<T>)Arrays.asList(list.toArray(new Object[size]));
    }

    /**
     * Get op code of terminal node
     */
    private OpCode getOpCode(TerminalNode node) {
        // TODO to OpCode
        String opCode = node.getText().replace('.', '_').toUpperCase();
        return OpCode.valueOf(opCode);
    }

    /**
     * Lazy visiting expr.
     */
    private static final class ExprHolder implements Instruction {
        private final ExprContext expr;

        private ExprHolder(ExprContext expr) {
            this.expr = expr;
        }

        public ExprContext getExpr() {
            return expr;
        }

        @Override
        public OpCode getOpCode() {
            throw new UnsupportedOperationException();
        }
    }
}
