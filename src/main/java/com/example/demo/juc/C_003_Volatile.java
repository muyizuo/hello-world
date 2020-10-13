package com.example.demo.juc;

/**
 * volatile可以保证线程的可见性
 * 可见性：对于共享变量，一个线程修改该共享变量后，其他线程要能立即读到最新的修改值，即修改对其他线程可见。
 */
public class C_003_Volatile implements Runnable {

    private volatile boolean flag = true;

    @Override
    public void run() {
        System.out.println("run start");
        while (flag) {

        }
        System.out.println("run end");
    }

    public static void main(String[] args) {
        C_003_Volatile c_003 = new C_003_Volatile();
        new Thread(c_003).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                c_003.flag = false;
            }
        }).start();
    }


}
