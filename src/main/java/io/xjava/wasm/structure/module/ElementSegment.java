package io.xjava.wasm.structure.module;

import java.util.List;

import io.xjava.wasm.structure.instruction.Expression;
import io.xjava.wasm.structure.type.ReferenceType;

/**
 * @author AlphaLxy
 */
public final class ElementSegment {
    private final ReferenceType type;
    private final List<Expression> init;
    private final ElementMode mode;
    private final Integer table;
    private final Expression offset;

    public ElementSegment(ReferenceType type, List<Expression> init,
                          ElementMode mode, Integer table, Expression offset) {
        this.type = type;
        this.init = init;
        this.mode = mode;
        this.table = table;
        this.offset = offset;
    }

    public ReferenceType getType() {
        return type;
    }

    public List<Expression> getInit() {
        return init;
    }

    public ElementMode getMode() {
        return mode;
    }

    public Integer getTable() {
        return table;
    }

    public Expression getOffset() {
        return offset;
    }
}
