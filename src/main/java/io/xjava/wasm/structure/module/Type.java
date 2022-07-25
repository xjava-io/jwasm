package io.xjava.wasm.structure.module;

import io.xjava.wasm.structure.type.FunctionType;

/**
 * @author AlphaLxy
 */
public final class Type {
    private final FunctionType type;

    public Type(FunctionType type) {
        this.type = type;
    }

    public FunctionType getType() {
        return type;
    }
}
