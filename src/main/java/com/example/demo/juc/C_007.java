package com.example.demo.juc;

import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * Phaser阶段
 *
 * 多个线程按阶段执行，当一个阶段的所有线程全部执行完毕，再执行下一个阶段
 */
public class C_007 extends Phaser {

    /*public C_007(int i) {
        super(i);
    }*/

    /**
     * 每个阶段执行完后的回调方法
     *
     * @param phase
     * @param registeredParties
     * @return
     */
    @Override
    protected boolean onAdvance(int phase, int registeredParties) {
        switch (phase) {
            case 0:
                System.out.println("所有人都到齐！\n");
                return false;
            case 1:
                System.out.println("所有人都用餐完毕！\n");
                return false;
            case 2:
                System.out.println("婚礼结束！\n");
                return true;
            default:
                return true;
        }
    }

    static C_007 c = new C_007();

    public static void main(String[] args) throws Exception {
        c.bulkRegister(12); // 增加注册线程的数量

        Runnable runnable = ()->{
            String name = Thread.currentThread().getName();

            System.out.println(name + "到了！");
            c.arriveAndAwaitAdvance();

            System.out.println(name + "开始用餐！");
            sleep();
            System.out.println(name + "用餐结束！");
            c.arriveAndAwaitAdvance();

            if ("新郎".equals(name) || "新娘".equals(name)) {
                System.out.println(name + "送入洞房！");
                c.arriveAndAwaitAdvance();
            } else {
                System.out.println(name + "离开！");
                c.arriveAndDeregister();

            }
        };

        for (int i = 0; i < 10; i++) {
            new Thread(runnable, "客人" + i).start();
        }
        new Thread(runnable, "新郎").start();
        new Thread(runnable, "新娘").start();
    }

    private static void sleep() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
