package io.xjava.wasm.descriptor;

/**
 * @author AlphaLxy
 */
public final class GlobalDescriptor {
    private final String value;
    private final boolean mutable;

    public GlobalDescriptor(String value, boolean mutable) {
        this.value = value;
        this.mutable = mutable;
    }

    public String getValue() {
        return value;
    }

    public boolean isMutable() {
        return mutable;
    }
}
