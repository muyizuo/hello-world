package com.example.demo.juc;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 原子类的使用
 */
public class C_018_AtomicBoolean {

    private static AtomicBoolean b1 = new AtomicBoolean(false);

    private static Boolean b2 = false;

    private static void changeValue1() {
        boolean b = b1.compareAndSet(false, true);
        System.out.println(Thread.currentThread().getName() + " " + b);
    }

    private static void changeValue2() {
        boolean success = false;
        synchronized (C_018_AtomicBoolean.class) {
            if (!b2) {
                b2 = true;
                success = true;
            }
        }
        System.out.println(Thread.currentThread().getName() + " " + success);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // changeValue1();
                changeValue2();
            }).start();
        }

    }
}
