/*
 * Copyright 2022 xjava.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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

    /**
     * Reference types are encoded by a single byte.
     */
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
