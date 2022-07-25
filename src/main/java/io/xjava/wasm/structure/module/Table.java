package io.xjava.wasm.structure.module;

import io.xjava.wasm.structure.type.TableType;

/**
 * @author AlphaLxy
 */
public final class Table {
    private final TableType type;

    public Table(TableType type) {
        this.type = type;
    }

    public TableType getType() {
        return type;
    }
}
