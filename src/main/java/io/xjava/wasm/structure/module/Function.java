package io.xjava.wasm.structure.module;

import java.util.List;

import io.xjava.wasm.structure.instruction.Expression;
import io.xjava.wasm.structure.type.ValueType;

/**
 * @author AlphaLxy
 */
public final class Function {
    private final int type;
    private final List<ValueType> locals;
    private final Expression body;

    public Function(int type, List<ValueType> locals, Expression body) {
        this.type = type;
        this.locals = locals;
        this.body = body;
    }

    public int getType() {
        return type;
    }

    public List<ValueType> getLocals() {
        return locals;
    }

    public Expression getBody() {
        return body;
    }
}
