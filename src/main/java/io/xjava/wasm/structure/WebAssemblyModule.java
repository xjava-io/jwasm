package io.xjava.wasm.structure;

import java.util.List;

import io.xjava.wasm.structure.module.*;

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
public final class WebAssemblyModule {

    private final List<Type> types;
    private final List<Function> functions;
    private final List<Table> tables;
    private final List<Memory> memories;
    private final List<Global> globals;

    private final List<Import> imports;
    private final List<Export> exports;

    private final List<ElementSegment> elementSegments;
    private final List<DataSegment> dataSegments;

    private final Integer startFunction;

    public WebAssemblyModule(List<Type> types,
                             List<Function> functions,
                             List<Table> tables,
                             List<Memory> memories,
                             List<Global> globals,
                             List<Import> imports,
                             List<Export> exports,
                             List<DataSegment> dataSegments,
                             List<ElementSegment> elementSegments,
                             Integer startFunction) {
        this.types = types;
        this.functions = functions;
        this.tables = tables;
        this.memories = memories;
        this.globals = globals;
        this.imports = imports;
        this.exports = exports;
        this.dataSegments = dataSegments;
        this.elementSegments = elementSegments;
        this.startFunction = startFunction;
    }

    public List<Type> getTypes() {
        return types;
    }

    public List<Function> getFunctions() {
        return functions;
    }

    public List<Table> getTables() {
        return tables;
    }

    public List<Memory> getMemories() {
        return memories;
    }

    public List<Global> getGlobals() {
        return globals;
    }

    public List<Import> getImports() {
        return imports;
    }

    public List<Export> getExports() {
        return exports;
    }

    public List<ElementSegment> getElementSegments() {
        return elementSegments;
    }

    public List<DataSegment> getDataSegments() {
        return dataSegments;
    }

    public Integer getStartFunction() {
        return startFunction;
    }
}
