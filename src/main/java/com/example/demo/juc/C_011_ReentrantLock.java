package com.example.demo.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock可重入锁（可用于代替synchronized）
 *
 * 1.lock()加锁，unlock()解锁。注意最好使用try/finally语句块
 * 2.ReentrantLock默认为非公平锁，可以使用new ReentrantLock(true)创建公平锁。另外synchronized是非公平锁。非公平锁往往效率更高！
 * 3.ReentrantLock可以尝试锁定tryLock，可指定超时时间，指定时间内获取不到锁则继续向下执行
 * 4.可中断锁 lockInterruptibly()
 * 5.可以绑定多个条件 Condition
 */
public class C_011_ReentrantLock {

    private static ReentrantLock lock = new ReentrantLock();
    // 公平锁（ReentrantLock默认为非公平锁）
    // private static ReentrantLock lock = new ReentrantLock(true);

    public static void m() {
        for (int i = 0; i < 10; i++) {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "run method m!");
                TimeUnit.SECONDS.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    /**
     * tryLock
     */
    public static void m1() {
        boolean tryLock = false;
        try {
            // tryLock = lock.tryLock();
            tryLock = lock.tryLock(3, TimeUnit.SECONDS);

            System.out.println(Thread.currentThread().getName() + "尝试获取锁是否成功：" + tryLock);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 若获取锁成功，必须释放锁
            if (tryLock) {
                lock.unlock();
            }
        }
    }

    /**
     * lockInterruptibly()可以响应中断，调用interrupt()方法打断指定的线程
     * 普通的lock()无法响应中断
     * 一般情况下，lockInterruptibly()会阻塞直到获取lock锁，此时和普通的lock()作用差不多
     */
    public static void m2() {
        try {
            TimeUnit.SECONDS.sleep(3);
            System.out.println(Thread.currentThread().getName() + "run method m2!");
            lock.lockInterruptibly();
            System.out.println(Thread.currentThread().getName() + "获取到锁！");
        } catch (Exception e) {
            System.out.println(Thread.currentThread().getName() + "中断！");
        } finally {
            try {
                // 如果没有获取到锁，这里会解锁失败，抛出IllegalMonitorStateException异常
                lock.unlock();
            } catch (Exception e) {
                System.out.println(Thread.currentThread().getName() + "无需释放锁！");
            }
        }
    }

    public static void main(String[] args) {
        new Thread(C_011_ReentrantLock::m, "线程1").start();

        // new Thread(C_011_ReentrantLock::m1, "线程2").start();

        Thread t3 = new Thread(C_011_ReentrantLock::m2, "线程3");
        t3.start();

        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t3.interrupt();
    }
}
