package io.xjava.wasm.structure.module;

import io.xjava.wasm.structure.instruction.Expression;

/**
 * @author AlphaLxy
 */
public final class DataSegment {
    private final byte[] init;
    private final DataMode mode;
    private final Integer memory;
    private final Expression offset;

    public DataSegment(byte[] init) {
        this.init = init;
        this.mode = DataMode.PASSIVE;
        this.memory = null;
        this.offset = null;
    }

    public DataSegment(byte[] init, int memory, Expression offset) {
        this.init = init;
        this.mode = DataMode.ACTIVE;
        this.memory = memory;
        this.offset = offset;
    }

    public byte[] getInit() {
        return init;
    }

    public DataMode getMode() {
        return mode;
    }

    public Integer getMemory() {
        return memory;
    }

    public Expression getOffset() {
        return offset;
    }
}
