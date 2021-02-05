package com.example.demo.juc;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * CyclicBarrier 循环栅栏
 *
 * 循环等待多个线程执行
 *
 * 以下是一个模拟公交车发车的例子
 */
public class C_006_CyclicBarrier {

    // 乘客数量
    private static final int num = 50;
    // 一辆公交车的最大载客量为10
    private static final CyclicBarrier cyclicBarrier = new CyclicBarrier(10, ()->{
        System.out.println("人满 发车！！！");
    });

    public static void main(String[] args) throws Exception {

        for(int i = 1; i <= num; i++) {
            TimeUnit.MILLISECONDS.sleep(100);
            new Thread(()->{
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName() + "已上车！");

                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, "乘客" + i).start();
        }
    }
}
