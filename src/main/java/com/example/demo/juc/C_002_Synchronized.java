package com.example.demo.juc;

/**
 * 模拟抢票（秒杀）
 * synchronized关键字
 */
public class C_002_Synchronized {

    // 票数
    private int ticket = 15;
    // 抢票人数
    private static int num = 100;

    /**
     * 抢票
     */
    public /*synchronized*/ void getTicket() {
        synchronized (this) {
            if (ticket > 0) {
                ticket--;
                System.out.print(Thread.currentThread().getName() + " 抢票成功！");
            } else {
                System.out.print(Thread.currentThread().getName() + " 抢票失败！");
            }
            System.out.println("余票为" + ticket + "张！");
        }
    }

    public static void main(String[] args) {
        // 模拟20人抢10张票
        C_002_Synchronized c_002 = new C_002_Synchronized();
        for (int i = 0; i < num; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    /*try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/
                    c_002.getTicket();
                }
            }, "用户" + i).start();
        }
    }
}