package io.xjava.wasm.descriptor;

/**
 * @author AlphaLxy
 */
public final class TableDescriptor {
    private final String element;
    private final int initial;
    private final int maximum;

    public TableDescriptor(String element, int initial, int maximum) {
        this.element = element;
        this.initial = initial;
        this.maximum = maximum;
    }

    public TableDescriptor(String element, int initial) {
        this.element = element;
        this.initial = initial;
        this.maximum = initial;
    }

    public String getElement() {
        return element;
    }

    public int getInitial() {
        return initial;
    }

    public int getMaximum() {
        return maximum;
    }
}
