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

import java.util.List;
import java.util.Objects;

/**
 * <h3>2.3.6 Function Types</h3>
 * Function types classify the signature of functions, mapping a vector
 * of parameters to a vector of results. They are also used to classify
 * the inputs and outputs of instructions.
 *
 * @author AlphaLxy
 */
public final class FunctionType {
    private final List<ValueType> parameterTypes;
    private final List<ValueType> resultTypes;

    public FunctionType(List<ValueType> parameterTypes, List<ValueType> resultTypes) {
        this.parameterTypes = Objects.requireNonNull(parameterTypes);
        this.resultTypes = Objects.requireNonNull(resultTypes);
    }

    public List<ValueType> getParameterTypes() {
        return parameterTypes;
    }

    public List<ValueType> getResultTypes() {
        return resultTypes;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        FunctionType that = (FunctionType)object;
        return parameterTypes.equals(that.parameterTypes) && resultTypes.equals(that.resultTypes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parameterTypes, resultTypes);
    }
}
