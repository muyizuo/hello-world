package com.example.demo.base;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class C_003 {

    private static final Map CACHE = new ConcurrentHashMap();

    public static void main(String[] args) {
        // ExecutorService service = Executors.newFixedThreadPool(2);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 2,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
        executor.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
                CACHE.put("123", "456");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Future<Object> future = executor.submit(() -> {
            Object o = null;
            while (o == null) {
                o = CACHE.get("123");
            }
            return o;
        });
        try {
            Object o = future.get(5, TimeUnit.SECONDS);
            System.out.println(Objects.toString(o));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("获取失败！");
        }
        executor.shutdown();
        System.out.println("主线程执行完毕！");
    }
}
