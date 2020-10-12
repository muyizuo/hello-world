package com.example.demo.juc;

/**
 * join()可保证线程的执行顺序
 *
 */
public class C_001 {

    private static int value;

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(() -> {
            C_001.m1();
            System.out.println(Thread.currentThread().getName());
        }, "线程01");

        Thread t2 = new Thread(() -> {
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            C_001.m1();
            System.out.println(Thread.currentThread().getName());
        }, "线程02");

        Thread t3 = new Thread(() -> {
            try {
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(value);
        }, "线程03");

        t1.start();
        t2.start();
        t3.start();
    }

    public synchronized static void m1() {
        value++;
    }
}
