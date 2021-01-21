package com.example.demo.jvm.gc;

/**
 * gc: Garbage Collector 垃圾收集器
 * 1.什么是垃圾？（Garbage）没有引用指向的对象就是垃圾。
 * 2.如何发现垃圾？
 * Reference Count（引用计数） 缺点：无法解决循环引用问题，即多个对象实例之间相互引用。
 * Root Search（根可达算法）（main方法里面直接能访问的对象）：线程栈变量，静态变量，常量池，JNI指针
 * 实际上是找有用的对象，找不到的就是垃圾。
 */
public class C_001_gc {

    public static void main(String[] args) {
        // M属于强引用
        // 强引用：不会被GC回收的引用，即使OOM（Out of Memory）。
        // 比如 Object o = new Object(); 就是强引用。
        M o = new M();
        System.out.println(o);
        o = null;

        System.gc();
        // for(;;);
    }

    private static class M {
        @Override
        protected void finalize() throws Throwable {
            System.out.println("M被回收！" + this);
        }
    }
}
