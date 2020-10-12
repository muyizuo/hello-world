package com.example.demo.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * CountDownLatch 门闩
 *
 * 等待多个线程执行完毕
 *
 * 类似join()
 */
public class C_005 {

    // 倒计数器
    private static final CountDownLatch countDownLatch = new CountDownLatch(50);

    public static void main(String[] args) {
        for(int i = 0; i < 50; i++) {
            new Thread(()->{
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "  执行完毕");
                countDownLatch.countDown();
            }, "线程" + i).start();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("所有的线程执行完毕！");
    }
}
