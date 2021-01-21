package com.example.demo.jvm.gc;

import java.lang.ref.SoftReference;

/**
 * 软引用：软引用指向的对象实例，内存足够时不会回收，内存不足时会回收。
 * 适用场景：用作缓存
 *
 */
public class C_002_SoftReference {

    public static void main(String[] args) {
        M m = new M();
        SoftReference<M> s = new SoftReference(new M());
        System.out.println(m);
        System.out.println(s.get());

        byte[] bytes = new byte[400 * 1024 * 1024];
        System.out.println(m);
        System.out.println(s.get());
    }

    private static class M {
        @Override
        protected void finalize() throws Throwable {
            System.out.println("M被回收！" + this);
        }
    }
}
