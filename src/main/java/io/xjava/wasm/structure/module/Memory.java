package io.xjava.wasm.structure.module;

import io.xjava.wasm.structure.type.MemoryType;

/**
 * @author AlphaLxy
 */
public final class Memory {
    private final MemoryType type;

    public Memory(MemoryType type) {
        this.type = type;
    }

    public MemoryType getType() {
        return type;
    }
}
