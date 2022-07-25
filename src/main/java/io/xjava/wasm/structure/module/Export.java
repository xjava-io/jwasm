package io.xjava.wasm.structure.module;

/**
 * @author AlphaLxy
 */
public abstract class Export {
    private final String name;
    private final int index;

    protected Export(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }

    public static final class Function extends Export {
        public Function(String module, int index) {
            super(module, index);
        }
    }

    public static final class Table extends Export {
        public Table(String module, int index) {
            super(module, index);
        }
    }

    public static final class Memory extends Export {
        public Memory(String module, int index) {
            super(module, index);
        }
    }

    public static final class Global extends Export {
        public Global(String module, int index) {
            super(module, index);
        }
    }
}
