package com.example.demo.juc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 实现一个容器，拥有两个方法add,size
 * 线程t1向容器中添加10个元素，线程t2检测容器中元素的个数，当个数到5时结束
 *
 */
public class C_013_JUC_Test {

    List list = Collections.synchronizedList(new ArrayList<>());

    public void add(Object o) {
        list.add(o);
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        C_012_JUC_Test c = new C_012_JUC_Test();

        Object lock = new Object();

        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + " start！");
                for (int i = 0; i < 10; i++) {
                    sleep(1);
                    System.out.println("add " + i);
                    c.add(i);

                    if (i == 5) {
                        // 唤醒t2
                        lock.notify();
                        try {
                            // 释放锁
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                System.out.println(Thread.currentThread().getName() + " end！");
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + " start！");
                try {
                    // 释放锁
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " end！");

                // 唤醒t1
                lock.notify();
            }
        }, "t2");

        t2.start();
        t1.start();
    }

    private static void sleep(long timeout) {
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
