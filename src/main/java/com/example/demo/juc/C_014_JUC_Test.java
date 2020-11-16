package com.example.demo.juc;

/**
 * 使用线程顺序打印A1B2C3...Z26
 * 线程1打印：A ~ Z
 * 线程2打印：1 ~ 26
 * 线程之间交叉打印
 *
 */
public class C_014_JUC_Test {

    public static void main(String[] args) {
        Object lock = new Object();

        new Thread(()->{
            for (int i = 0; i < 26; i++) {
                synchronized (lock) {
                    System.out.println((char) ('A' + i));
                    try {
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "线程1").start();

        new Thread(()->{
            for (int i = 0; i < 26; i++) {
                synchronized (lock) {
                    System.out.println(i + 1);
                    try {
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "线程2").start();
    }
}