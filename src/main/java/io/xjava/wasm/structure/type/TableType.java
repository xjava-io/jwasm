package io.xjava.wasm.structure.type;

import java.util.Objects;

/**
 * <h3>2.3.9 Table Types</h3>
 * Table types classify tables over elements of reference type within a size range.
 * <p>
 * Like memories, tables are constrained by limits for their minimum and optionally
 * maximum size. The limits are given in numbers of entries.
 * <p>
 * Note: In future versions of WebAssembly, additional element types may be introduced.
 *
 * @author AlphaLxy
 */
public final class TableType {
    /**
     * Minimum size
     */
    private final int min;
    /**
     * Optionally maximum size
     */
    private final Integer max;
    /**
     * Reference type
     */
    private final ReferenceType referenceType;

    public TableType(int min, Integer max, ReferenceType referenceType) {
        // do not check unsigned integer in constructor
        this.min = min;
        this.max = max;
        this.referenceType = Objects.requireNonNull(referenceType);
    }

    /**
     * Get minimum size.
     *
     * @return minimum size
     */
    public int getMin() {
        return min;
    }

    /**
     * Get optionally maximum size.
     *
     * @return maximum size or null
     */
    public Integer getMax() {
        return max;
    }

    /**
     * Get reference type.
     *
     * @return reference type
     */
    public ReferenceType getRefType() {
        return referenceType;
    }
}
