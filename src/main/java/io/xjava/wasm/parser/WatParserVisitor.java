// Generated from WatParser.g4 by ANTLR 4.9.3

package io.xjava.wasm.parser;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link WatParser}.
 *
 * @param <T> The return type of the visit operation.
 *            Use {@link Void} for operations with no return type.
 * @author AlphaLxy
 */
public interface WatParserVisitor<T> extends ParseTreeVisitor<T> {
    /**
     * Visit a parse tree produced by {@link WatParser#id}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitId(WatParser.IdContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#index}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitIndex(WatParser.IndexContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#typeIndex}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitTypeIndex(WatParser.TypeIndexContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#functionIndex}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitFunctionIndex(WatParser.FunctionIndexContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#tableIndex}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitTableIndex(WatParser.TableIndexContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#memoryIndex}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitMemoryIndex(WatParser.MemoryIndexContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#globalIndex}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitGlobalIndex(WatParser.GlobalIndexContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#elementIndex}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitElementIndex(WatParser.ElementIndexContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#dataIndex}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitDataIndex(WatParser.DataIndexContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#localIndex}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitLocalIndex(WatParser.LocalIndexContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#labelIndex}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitLabelIndex(WatParser.LabelIndexContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#name}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitName(WatParser.NameContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#dataString}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitDataString(WatParser.DataStringContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#number}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitNumber(WatParser.NumberContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#refType}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitRefType(WatParser.RefTypeContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#heapType}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitHeapType(WatParser.HeapTypeContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#valueType}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitValueType(WatParser.ValueTypeContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#vecType}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitVecType(WatParser.VecTypeContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#vecShape}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitVecShape(WatParser.VecShapeContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#funcType}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitFuncType(WatParser.FuncTypeContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#result}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitResult(WatParser.ResultContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#param}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitParam(WatParser.ParamContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#local}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitLocal(WatParser.LocalContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#memType}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitMemType(WatParser.MemTypeContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#tableType}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitTableType(WatParser.TableTypeContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#globalType}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitGlobalType(WatParser.GlobalTypeContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#label}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitLabel(WatParser.LabelContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#blockType}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitBlockType(WatParser.BlockTypeContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#memArg}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitMemArg(WatParser.MemArgContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#blockInstr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitBlockInstr(WatParser.BlockInstrContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#plainInstr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitPlainInstr(WatParser.PlainInstrContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#controlInstr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitControlInstr(WatParser.ControlInstrContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#referenceInstr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitReferenceInstr(WatParser.ReferenceInstrContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#parametricInstr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitParametricInstr(WatParser.ParametricInstrContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#variableInstr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitVariableInstr(WatParser.VariableInstrContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#tableInstr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitTableInstr(WatParser.TableInstrContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#memoryInstr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitMemoryInstr(WatParser.MemoryInstrContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#numericInstr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitNumericInstr(WatParser.NumericInstrContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#vectorInstr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitVectorInstr(WatParser.VectorInstrContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#instr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitInstr(WatParser.InstrContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#expr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitExpr(WatParser.ExprContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#module}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitModule(WatParser.ModuleContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#moduleField}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitModuleField(WatParser.ModuleFieldContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#type}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitType(WatParser.TypeContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#func}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitFunc(WatParser.FuncContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#table}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitTable(WatParser.TableContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#mem}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitMem(WatParser.MemContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#global}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitGlobal(WatParser.GlobalContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#moduleImport}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitModuleImport(WatParser.ModuleImportContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#moduleExport}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitModuleExport(WatParser.ModuleExportContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#start}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitStart(WatParser.StartContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#elem}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitElem(WatParser.ElemContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#data}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitData(WatParser.DataContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#offset}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitOffset(WatParser.OffsetContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#item}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitItem(WatParser.ItemContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#inlineImport}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitInlineImport(WatParser.InlineImportContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#inlineExport}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitInlineExport(WatParser.InlineExportContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#memUse}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitMemUse(WatParser.MemUseContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#tableUse}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitTableUse(WatParser.TableUseContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#typeUse}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitTypeUse(WatParser.TypeUseContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#funcDesc}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitFuncDesc(WatParser.FuncDescContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#tableDesc}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitTableDesc(WatParser.TableDescContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#memDesc}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitMemDesc(WatParser.MemDescContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#globalDesc}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitGlobalDesc(WatParser.GlobalDescContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#importDesc}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitImportDesc(WatParser.ImportDescContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#exportDesc}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitExportDesc(WatParser.ExportDescContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#elemList}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitElemList(WatParser.ElemListContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#script}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitScript(WatParser.ScriptContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#command}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitCommand(WatParser.CommandContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#scriptModule}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitScriptModule(WatParser.ScriptModuleContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#action}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitAction(WatParser.ActionContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#register}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitRegister(WatParser.RegisterContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#scriptConst}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitScriptConst(WatParser.ScriptConstContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#assertion}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitAssertion(WatParser.AssertionContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#scriptResult}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitScriptResult(WatParser.ScriptResultContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#numPat}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitNumPat(WatParser.NumPatContext ctx) {
        throw new UnsupportedOperationException();
    }

    /**
     * Visit a parse tree produced by {@link WatParser#meta}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    default T visitMeta(WatParser.MetaContext ctx) {
        throw new UnsupportedOperationException();
    }
}