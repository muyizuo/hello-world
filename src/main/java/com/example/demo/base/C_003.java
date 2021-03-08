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
        new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            CACHE.put("123", "ABCD");
        }).start();

        long start = System.currentTimeMillis();
        System.out.println(start);
        Object o = null;
        while (System.currentTimeMillis() - start < 10000) {
            o = CACHE.get("123");
        }
        System.out.println(System.currentTimeMillis());
        System.out.println(o);
    }
}
