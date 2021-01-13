package com.example.demo.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock的Condition
 * 1.一个ReentrantLock对象可以绑定多个Condition，不同的Condition相当于不同的等待队列
 * 2.调用await()/signal()之前，必须先获得锁。类似于wait/notify因为是在同步方法/同步代码块中调用的，使用前也需要获取锁。
 * 3.await()会释放锁，而signal()不会释放锁。类似于wait/notify（wait会释放锁，notify不会释放锁）
 */
public class C_016_Condition {

    private static ReentrantLock lock = new ReentrantLock();

    private static Condition condition = lock.newCondition();
    private static Condition condition2 = lock.newCondition();
    private static Condition condition3 = lock.newCondition();
    private static Condition condition4 = lock.newCondition();

    public static void main(String[] args) {
        new Thread(() -> {
            // System.out.println(Thread.currentThread().getName() + " start!");
            try {
                TimeUnit.SECONDS.sleep(1);
                lock.lock();
                System.out.println(Thread.currentThread().getName() + " lock()获得锁!");
                System.out.println(Thread.currentThread().getName() + " await()释放锁！");
                condition.await(); // 释放锁
                System.out.println(Thread.currentThread().getName() + " 再次获得锁！");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            System.out.println(Thread.currentThread().getName() + " end!");
        }, "线程1").start();

        new Thread(() -> {
            // System.out.println(Thread.currentThread().getName() + " start!");
            try {
                TimeUnit.SECONDS.sleep(3);
                lock.lock();
                System.out.println(Thread.currentThread().getName() + " lock()获得锁!");
                condition.signal(); // 不会释放锁
                System.out.println(Thread.currentThread().getName() + " signal不会释放锁！");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();// 释放锁
            }
            System.out.println(Thread.currentThread().getName() + " end!");
        }, "线程2").start();
    }
}
