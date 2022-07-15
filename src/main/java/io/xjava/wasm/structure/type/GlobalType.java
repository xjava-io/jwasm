package io.xjava.wasm.structure.type;

import java.util.Objects;

/**
 * <h3>2.3.10 Global Types</h3>
 * Global types classify global variables, which hold a value and
 * can either be mutable or immutable.
 *
 * @author AlphaLxy
 */
public final class GlobalType {
    /**
     * Mutable or immutable
     */
    private final boolean mutable;
    /**
     * Value type
     */
    private final ValueType valueType;

    public GlobalType(boolean mutable, ValueType valueType) {
        this.mutable = mutable;
        this.valueType = Objects.requireNonNull(valueType);
    }

    /**
     * Is mutable.
     *
     * @return is mutable
     */
    public boolean isMutable() {
        return mutable;
    }

    /**
     * Is immutable.
     *
     * @return is immutable
     */
    public boolean isImmutable() {
        return !mutable;
    }

    /**
     * Get value type.
     *
     * @return value type
     */
    public ValueType getValueType() {
        return valueType;
    }
}
