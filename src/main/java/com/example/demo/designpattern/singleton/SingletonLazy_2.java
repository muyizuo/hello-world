package com.example.demo.designpattern.singleton;

/**
 * @Description :  单例模式 懒汉式（Lazy 懒加载）：第一次获取时创建实例
 * @Author :  yangzhuo
 * @Date :  2020/9/7 13:53
 * @Version :  1.0
 */
public class SingletonLazy_2 {

    /**
     * 私有静态变量
     */
    private static SingletonLazy_2 instance;

    /**
     * 私有构造方法
     */
    private SingletonLazy_2() {
    }

    /**
     * 公有静态get方法
     * 线程安全的写法之一
     * 引发问题：整个方法都加了锁，里面可能包含业务逻辑代码，导致执行效率低下
     */
    public synchronized static SingletonLazy_2 getInstance() {
        // 业务逻辑代码...
        if (instance == null) {
            instance = new SingletonLazy_2();
        }
        return instance;
    }
}
