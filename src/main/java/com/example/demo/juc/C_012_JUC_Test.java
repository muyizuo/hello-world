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
public class C_012_JUC_Test {

    // 不加volatile不行，因为线程之间不可见
    volatile List list = Collections.synchronizedList(new ArrayList<>());

    public void add(Object o) {
        list.add(o);
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        C_012_JUC_Test c = new C_012_JUC_Test();

        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " start！");
            for (int i = 0; i < 10; i++) {
                // 不睡的话，不能实现效果
                // sleep(1);
                System.out.println("add " + i);
                c.add(i);
            }
            System.out.println(Thread.currentThread().getName() + " end！");
        }, "t1");

        Thread t2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " start！");
            while (true) {
                if (c.size() == 5) {
                    break;
                }
            }
            System.out.println(Thread.currentThread().getName() + " end！");
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
