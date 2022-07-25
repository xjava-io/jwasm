package io.xjava.wasm.structure.module;

import io.xjava.wasm.structure.type.GlobalType;
import io.xjava.wasm.structure.type.MemoryType;
import io.xjava.wasm.structure.type.TableType;

/**
 * The <a href="https://www.w3.org/TR/wasm-core-2/syntax/modules.html#imports">imports</a>
 * component of a module defines a set of imports that are required for instantiation.
 *
 * <p>
 * Note: Unlike export names, import names are not necessarily unique.
 * It is possible to import the same / pair multiple times; such imports
 * may even have different type descriptions, including different kinds of
 * entities. A module with such imports can still be instantiated depending
 * on the specifics of how an embedder allows resolving and supplying imports.
 * However, embedders are not required to support such overloading, and a
 * WebAssembly module itself cannot implement an overloaded name.
 *
 * @author AlphaLxy
 */
public abstract class Import {
    private final String module;
    private final String name;

    protected Import(String module, String name) {
        this.module = module;
        this.name = name;
    }

    public String getModule() {
        return module;
    }

    public String getName() {
        return name;
    }

    public static final class Function extends Import {
        private final int index;

        public Function(String module, String name, int index) {
            super(module, name);
            this.index = index;
        }

        public int getIndex() {
            return index;
        }
    }

    public static final class Table extends Import {
        private final TableType type;

        public Table(String module, String name, TableType type) {
            super(module, name);
            this.type = type;
        }

        public TableType getType() {
            return type;
        }
    }

    public static final class Memory extends Import {
        private final MemoryType type;

        public Memory(String module, String name, MemoryType type) {
            super(module, name);
            this.type = type;
        }

        public MemoryType getType() {
            return type;
        }
    }

    public static final class Global extends Import {
        private final GlobalType type;

        public Global(String module, String name, GlobalType type) {
            super(module, name);
            this.type = type;
        }

        public GlobalType getType() {
            return type;
        }
    }

}
