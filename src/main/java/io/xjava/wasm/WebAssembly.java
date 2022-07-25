package io.xjava.wasm;

import java.nio.ByteBuffer;

import io.xjava.wasm.descriptor.GlobalDescriptor;
import io.xjava.wasm.descriptor.MemoryDescriptor;

/**
 * @author AlphaLxy
 */
public abstract class WebAssembly {

    public static WebAssembly.Instance instantiate(byte[] bytes, Object importObject) {
        //if (Character.isHighSurrogate(c1) && index <= maxIndex) {
        //    char c2 = chars[index];
        //    if (Character.isLowSurrogate(c2)) {
        //        // out of BMP (Basic Multilingual Plane)
        //        chars[length++] = c1;
        //        chars[length++] = c2;
        //        index++;
        //        continue;
        //    }
        //}
        //// in BPM (Basic Multilingual Plane)
        return new WebAssembly.Instance(new WebAssembly.Module(bytes), importObject);
    }

    public static WebAssembly.Instance instantiate(ByteBuffer buffer, Object importObject) {
        return new WebAssembly.Instance(new WebAssembly.Module(buffer), importObject);
    }

    public static WebAssembly.Instance instantiate(WebAssembly.Module module, Object importObject) {
        return new WebAssembly.Instance(module, importObject);
    }

    public static class Global {
        private final GlobalDescriptor descriptor;
        private final Object value;

        public Global(GlobalDescriptor descriptor, Object value) {
            this.descriptor = descriptor;
            this.value = value;
        }
    }

    public static class Module {
        public Module(byte[] bytes) {
            //this.object = object;
        }

        public Module(ByteBuffer buffer) {
            //this.object = object;
        }

        public static Object exports(Module module) {
            return null;
        }

        public static Object imports(Module module) {
            return null;
        }
    }

    public static class Memory {
        private final MemoryDescriptor descriptor;

        public Memory(MemoryDescriptor descriptor) {
            this.descriptor = descriptor;
        }
    }

    public static class Instance {
        private final Module module;
        private final Object importObject;

        public Instance(Module module, Object importObject) {
            this.module = module;
            this.importObject = importObject;
        }

        public static Object exports(Module module) {
            return null;
        }
    }
}
