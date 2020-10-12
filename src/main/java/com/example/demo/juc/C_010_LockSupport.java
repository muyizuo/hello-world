package com.example.demo.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * LockSupport
 *
 * 1.可以阻塞/唤醒指定的线程，比wait/notify更加灵活。
 * 2.LockSupport.park() // 阻塞线程
 *   LockSupport.unpark(t); // 唤醒指定线程t
 * 3.unpark方法可以在park方法调用之前调用。
 *
 * @author User
 */
public class C_010_LockSupport {

    public static void main(String[] args) {

        Thread t = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    TimeUnit.SECONDS.sleep(1);

                    if (i == 5) {
                        LockSupport.park();
                    }

                    System.out.println(i);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });
        t.start();

        // 唤醒指定线程t
        LockSupport.unpark(t); // 执行该行代码时，线程t还未阻塞

        /*try {
            TimeUnit.SECONDS.sleep(8);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 唤醒指定线程t
        LockSupport.unpark(t); // 执行该行代码时，线程t已阻塞

        System.out.println("after 8 seconds!");*/
    }
}
