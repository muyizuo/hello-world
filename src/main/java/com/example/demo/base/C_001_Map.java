package com.example.demo.base;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * 多线程下使用Map
 *
 * HashMap线程不安全
 * 因为多线程环境下，使用Hashmap进行put操作可能会引起死循环，导致CPU利用率接近100%，所以在并发情况下不能使用HashMap。
 */
public class C_001_Map {

    public static void main(String[] args) {
        // final Map<String, String> map = new HashMap<String, String>(2);
        final Map<String, String> map = new ConcurrentHashMap<String, String>(2);
        for (int i = 0; i < 1000000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    map.put(UUID.randomUUID().toString(), "");
                }
            }).start();
        }
    }

}
