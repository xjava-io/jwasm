package io.xjava.wasm.structure.module;

import io.xjava.wasm.structure.instruction.Expression;
import io.xjava.wasm.structure.type.GlobalType;

/**
 * @author AlphaLxy
 */
public final class Global {
    private final GlobalType type;
    private final Expression init;

    public Global(GlobalType type, Expression init) {
        this.type = type;
        this.init = init;
    }

    public GlobalType getType() {
        return type;
    }

    public Expression getInit() {
        return init;
    }
}
