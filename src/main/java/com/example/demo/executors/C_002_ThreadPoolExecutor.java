package com.example.demo.executors;

import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

public class C_002_ThreadPoolExecutor {

    private static final Map<String, Object> CACHE = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        // 核心线程数
        int corePoolSize = 5;
        // 最大线程数
        int maximumPoolSize = 10;
        // 空闲线程保持时间
        long keepAliveTime = 10;
        // 时间单位
        TimeUnit unit = TimeUnit.SECONDS;
        // 线程等待队列
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>();
        // 线程创建工厂
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("test-pool-%d").build();
        // 拒绝策略
        RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit,
                workQueue, threadFactory, handler);

        try {
            Future<?> future = executor.submit(() -> {
                Object o = null;
                while (o == null) {
                    o = CACHE.get("test");
                    System.out.println("获取CACHE中key为test的value：" + o);
                }
                return o;
            });
            future.get(10, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }

        executor.execute(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            CACHE.put("test", "123");
        });

        executor.shutdown();
    }
}
