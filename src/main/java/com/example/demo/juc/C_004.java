package com.example.demo.juc;

/**
 * 对象锁
 */
public class C_004 {

    private int value;
    private Object lock = new Object();

    public void m1() {
        synchronized (lock) {
            if (value < 5) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                value++;
            }
            System.out.println(Thread.currentThread().getName() + " - " + value);
        }
    }

    public static void main(String[] args) {
        C_004 c_004 = new C_004();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                c_004.m1();
            }
        };
        new Thread(runnable, "线程1").start();
        new Thread(runnable, "线程2").start();
    }
}
