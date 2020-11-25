package com.example.demo.executors;

import java.util.Date;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description :  定时任务的取消
 * @Author      :  yangzhuo
 * @Date        :  2020/11/14 16:51
 * @Version     :  1.0
 */
public class C_001_ScheduledThreadPoolExecutor {

    public static void main(String[] args) {
        // 创建一个定时线程
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);
        Runnable runnable = ()->{
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(new Date());
        };
        runnable.run();
        // 设置3秒后执行
        // ScheduledFuture<?> schedule = executor.schedule(runnable, 3, TimeUnit.SECONDS);
        // 1秒后开始执行，每两秒执行一次（无需等上一个任务执行完）
        // executor.scheduleAtFixedRate(runnable, 1, 2, TimeUnit.SECONDS);
        // 1秒后开始执行，每两秒执行一次（需要等上一个任务执行完）
        // executor.scheduleWithFixedDelay(runnable, 1, 2, TimeUnit.SECONDS);

        // 1.调用remove(Runnable task)来取消（不行）
        // executor.remove(runnable);
        // 2.调用cancel来取消（可以）
        // schedule.cancel(true);
        // 3.调用remove(Runnable task)来取消（可以）
        // executor.remove((RunnableScheduledFuture) schedule);
        // executor.shutdown();
    }
}
