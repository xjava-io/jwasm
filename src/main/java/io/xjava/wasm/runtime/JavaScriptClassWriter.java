//package io.xjava.wasm.visitor;
//
//import org.objectweb.asm.ClassWriter;
//import org.objectweb.asm.MethodVisitor;
//
//import java.util.concurrent.atomic.AtomicInteger;
//
//import io.xjava.wasm.runtime.WebAssembly;
//import jdk.internal.org.objectweb.asm.Type;
//
//import static org.objectweb.asm.Opcodes.*;
//
///**
// * @author AlphaLxy
// // */
//public class JavaScriptClassWriter extends ClassWriter {
//    private static final AtomicInteger COUNTER = new AtomicInteger(0);
//    private final String type;
//    private final AtomicInteger lambda;
//
//    public JavaScriptClassWriter() {
//        super(ClassWriter.COMPUTE_MAXS);
//        String parentName = Type.getInternalName(WebAssembly.class);
//        this.type = parentName + "$" + COUNTER.getAndIncrement();
//        this.lambda = new AtomicInteger();
//        // source
//        //visitSource("demo.js", null);
//        // class
//        visit(V1_8, ACC_PUBLIC + ACC_FINAL + ACC_SUPER, type, null, parentName, new String[0]);
//        // constructor
//        MethodVisitor mv = visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
//        mv.visitVarInsn(ALOAD, 0);
//        // super()
//        mv.visitMethodInsn(INVOKESPECIAL, parentName, "<init>", "()V", false);
//        mv.visitInsn(RETURN);
//        mv.visitMaxs(0, 0);
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public String getLambdaName() {
//        return "lambda$$" + lambda.getAndIncrement();
//    }
//}
