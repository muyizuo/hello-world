package com.example.demo.jvm.gc;

import java.lang.ref.WeakReference;

/**
 * 弱引用：弱引用指向的对象实例被GC一旦发现就会回收。
 * 适用场景：ThreadLocal
 *
 */
public class C_003_WeakReference {

    public static void main(String[] args) {
        WeakReference<M> w = new WeakReference<>(new M());
        System.out.println(w.get());

        System.gc();

        System.out.println(w.get());
    }

    private static class M {
        @Override
        protected void finalize() throws Throwable {
            System.out.println("M被回收！" + this);
        }
    }
}
