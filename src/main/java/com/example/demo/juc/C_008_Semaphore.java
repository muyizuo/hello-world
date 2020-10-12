package com.example.demo.juc;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 信号量Semaphore
 *
 * 可指定同一时刻同时执行的线程数量
 * 允许n个线程同时执行
 *
 * 应用场景：限流
 *
 * @author User
 */
public class C_008_Semaphore {

    static Semaphore semaphore = new Semaphore(2);

    public static void main(String[] args) throws Exception {

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire(); // 获取锁
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName() + "执行完毕！");
                    semaphore.release(); // 释放锁
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "线程" + i).start();
        }

    }
}
