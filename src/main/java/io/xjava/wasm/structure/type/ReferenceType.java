package io.xjava.wasm.structure.type;

/**
 * <h3>2.3.3 Reference Types</h3>
 * Reference types classify first-class references to objects in the runtime store.
 * <p>
 * The type <strong>funcref</strong> denotes the infinite union of all references
 * to functions, regardless of their function types.
 * <p>
 * The type <strong>externref</strong> denotes the infinite union of all references
 * to objects owned by the embedder and that can be passed into WebAssembly under
 * this type.
 * <p>
 * Reference types are opaque, meaning that neither their size nor their bit pattern
 * can be observed. Values of reference type can be stored in tables.
 *
 * @author AlphaLxy
 */
public enum ReferenceType implements ValueType {
    /**
     * funcref
     */
    FUNC_REF((byte)0x70),
    /**
     * externref
     */
    EXTERN_REF((byte)0x6F);

    private final byte code;

    ReferenceType(byte code) {
        this.code = code;
    }

    @Override
    public boolean isNumberType() {
        return false;
    }

    @Override
    public boolean isReferenceType() {
        return true;
    }

    @Override
    public boolean isVectorType() {
        return false;
    }

    @Override
    public byte toByte() {
        return code;
    }
}
