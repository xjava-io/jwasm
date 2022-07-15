package io.xjava.wasm.structure.type;

/**
 * <h3>2.3.8 Memory Types</h3>
 * Memory types classify linear memories and their size range.
 * <p>
 * The limits constrain the minimum and optionally the maximum
 * size of a memory. The limits are given in units of page size.
 *
 * @author AlphaLxy
 */
public final class MemoryType {
    /**
     * Minimum size
     */
    private final int min;
    /**
     * Optionally maximum size
     */
    private final Integer max;

    public MemoryType(int min, Integer max) {
        // do not check unsigned integer in constructor
        this.min = min;
        this.max = max;
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
}
