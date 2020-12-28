package com.example.demo.base;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * @Description: EhCache
 * @Author: yz
 * @Date: 2020/12/11 16:59
 */
public class C_006_EhCache {

    public static void main(String[] args) {
        String path = System.getProperty("user.dir");
        // 创建Cache管理器
        CacheManager manager = CacheManager.create(path + "\\src\\main\\resources\\ehcache.xml");
        // 获取指定Cache
        Cache cache = manager.getCache("iporeportstatuscache");
        // 把一个元素添加到Cache中
        cache.put(new Element("name", "yangzhuo1"));
        // 根据Key获取缓存元素
        Element ele = cache.get("name");
        System.out.println("name==" + ele.getObjectValue());

        cache.flush(); // 刷新缓存
        manager.shutdown();  // 关闭缓存管理器
    }
}
