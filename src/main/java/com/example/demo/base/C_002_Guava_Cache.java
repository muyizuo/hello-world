package com.example.demo.base;

import java.util.concurrent.TimeUnit;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

/**
 * Guava Cache API
 *
 * 只有下次操作时，才能触发缓存被移除的通知
 * 说明移除监听器并不会新建一个线程，而是在主线程中附加
 *
 */
public class C_002_Guava_Cache {

    public static final Cache<String, Object> CACHE = CacheBuilder.newBuilder()
            // 初始容量10
            .initialCapacity(10)
            // 最大容量100
            .maximumSize(100)
            // 写入10秒钟后失效
            .expireAfterWrite(5, TimeUnit.SECONDS)
            // 设置缓存的移除通知
            .removalListener(removalNotification -> {
                System.out.println("询价/申购上报缓存[" + removalNotification.getKey() + "]已移除！");
                System.out.println("原因：" + removalNotification.getCause());
            })
            .build();

    public static void main(String[] args) {
        new Thread(()->{
            int i = 0;
            while (true) {
                i++;
                try {
                    CACHE.get(String.valueOf(i), Object::new);
                    TimeUnit.SECONDS.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (i == 3) {
                    CACHE.invalidate("2");
                }
                // System.out.println(CACHE.getIfPresent("1"));
            }
        }).start();
    }
}
