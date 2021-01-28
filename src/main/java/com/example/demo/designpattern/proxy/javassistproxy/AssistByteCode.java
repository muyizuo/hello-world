package com.example.demo.designpattern.proxy.javassistproxy;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

/**
 * Javassist是在 Java 中编辑字节码的类库；它使 Java 程序能够在运行时定义一个新类, 并在 JVM 加载时修改类文件。
 *
 * 实时应用不会频繁使用反射来创建，因为反射开销比较大，另外，还有一种具有和反射一样功能强大的特性那就是 Javaassist。
 *
 * ClassPool 就是一个 CtClass 的容器，而一个 CtClass 对象就是一个 class 对象的实例，这个实例和 class 对象一样，包含属性、方法等。
 */
public class AssistByteCode {

    /**
     * 通过 ClassPool 来获取 CtClass 所需要的接口、抽象类的 CtClass 实例，
     * 然后通过 CtClass 实例添加自己的属性和方法，
     * 并通过它的 writeFile 把二进制流输出到当前项目的根目录路径下。
     * writeFile 其内部是使用了 DataOutputStream 进行输出的。
     *
     * @throws Exception
     */
    public static void createByteCode() throws Exception {
        ClassPool classPool = ClassPool.getDefault();
        CtClass cc = classPool.makeClass("com.example.demo.designpattern.proxy.javassistproxy.MyServiceImpl");

        // 设置接口
        CtClass ctClass = classPool.get("com.example.demo.designpattern.proxy.javassistproxy.MyService");
        cc.setInterfaces(new CtClass[] {ctClass});

        // 创建方法
        CtMethod doSomething = CtMethod.make("public void doSomething(){}", cc);
        doSomething.setBody("System.out.println(\"---- doSomething ----\");");
        cc.addMethod(doSomething);

        Class c = cc.toClass();
        cc.writeFile("src\\main\\java\\");
    }

    public static void main(String[] args) {
        try {
            AssistByteCode.createByteCode();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
