package com.example.demo.juc;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

/**
 * Exchanger交换器
 *
 * 1.用于两个线程之间进行数据交换（只能是两两交换）
 * 2.exchange()会阻塞线程，数据交换完成后返回交换后的值，线程才会继续执行
 * 3.exchange()可以指定超时时间timeout，超时会抛出异常
 *
 * @author User
 */
public class C_009_Exchanger {

    private static Exchanger<String> exchanger = new Exchanger<String>();

    public static void main(String[] args) {
        new Thread(()->{
            String name = "T1";
            try {
                // 交换数据
                String exchange = exchanger.exchange(name);

                System.out.println(Thread.currentThread().getName() + " " + exchange);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1").start();

        new Thread(()->{
            String name = "T2";
            try {
                // 交换数据
                String exchange = exchanger.exchange(name);

                System.out.println(Thread.currentThread().getName() + " " + exchange);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t2").start();

        /*new Thread(()->{
            String name = "T3";
            try {
                TimeUnit.SECONDS.sleep(1);
                // 交换数据
                String exchange = exchanger.exchange(name);

                System.out.println(Thread.currentThread().getName() + " " + exchange);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t3").start();*/

        /*new Thread(()->{
            String name = "T4";
            try {
                TimeUnit.SECONDS.sleep(1);
                // 交换数据
                String exchange = exchanger.exchange(name);

                System.out.println(Thread.currentThread().getName() + " " + exchange);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t4").start();*/

        new Thread(()->{
            String name = "T5";
            try {
                TimeUnit.SECONDS.sleep(1);
                // 交换数据
                String exchange = exchanger.exchange(name, 1 , TimeUnit.SECONDS);

                System.out.println(Thread.currentThread().getName() + " " + exchange);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t5").start();
    }
}
