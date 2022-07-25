package io.xjava.wasm.descriptor;

/**
 * @author AlphaLxy
 */
public final class MemoryDescriptor {
    private final int initial;
    private final int maximum;
    private final boolean shared;

    public MemoryDescriptor(int initial) {
        this.initial = initial;
        this.maximum = initial;
        this.shared = false;
    }

    public MemoryDescriptor(int initial, int maximum) {
        this.initial = initial;
        this.maximum = maximum;
        this.shared = false;
    }

    public MemoryDescriptor(int initial, int maximum, boolean shared) {
        this.initial = initial;
        this.maximum = maximum;
        this.shared = shared;
    }

    public int getInitial() {
        return initial;
    }

    public int getMaximum() {
        return maximum;
    }

    public boolean getShared() {
        return shared;
    }
}
