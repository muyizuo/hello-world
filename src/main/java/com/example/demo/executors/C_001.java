package com.example.demo.executors;

import java.util.Date;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class C_001 {

    public static void main(String[] args) {
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);
        Runnable runnable = ()->{
            System.out.println(new Date());
        };
        runnable.run();
        RunnableScheduledFuture<?> schedule = (RunnableScheduledFuture<?>) executor.schedule(runnable, 3, TimeUnit.SECONDS);
        // executor.remove(schedule);
        // schedule.cancel(true);
    }
}
