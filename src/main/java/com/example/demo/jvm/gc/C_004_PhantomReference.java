package com.example.demo.jvm.gc;

import java.lang.ref.PhantomReference;

/**
 * 虚引用：虚引用指向的对象实例相当于没有引用。
 *
 */
public class C_004_PhantomReference {

    public static void main(String[] args) {
        PhantomReference<M> p = new PhantomReference<>(new M(), null);
        System.out.println(p.get());
    }

    private static class M {
        @Override
        protected void finalize() throws Throwable {
            System.out.println("M被回收！" + this);
        }
    }
}
