package com.example.demo.juc;

/**
 * 对象锁
 *
 * 1.wait()与notify()/notifyAll()必须在同步代码块（同步方法也可以，但要注意锁对象）中使用，经常与synchronized配合使用
 * 2.在执行wait()与notify()/notifyAll()之前没有获取到锁，会抛出java.lang.IllegalMonitorStateException异常
 * 3.使用interrupt()可以打断等待的线程
 * 4.notify通知的顺序不能错，即notify()需在wait()执行之后再执行，否则不能正常唤醒线程
 */
public class C_004_WaitAndNotify {

    private int value;
    private Object lock = new Object();

    public void m2() {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + " start!");
            try {
                // 调用wait()后会释放锁
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " end!");
        }
    }

    public void m3() {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + " start!");
            // 调用notify()后并不会立即释放锁，而是等同步代码块执行完才会释放锁
            lock.notify();
            /*try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            System.out.println(Thread.currentThread().getName() + " end!");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        C_004_WaitAndNotify c_004 = new C_004_WaitAndNotify();

        Thread t1 = new Thread(c_004::m2, "线程1");

        Thread t2 = new Thread(c_004::m3, "线程2");

        t2.start();

        t1.start();

        /*try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 打断线程
        t1.interrupt();*/
    }
}
