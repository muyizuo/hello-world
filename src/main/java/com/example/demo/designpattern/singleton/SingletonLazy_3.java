package com.example.demo.designpattern.singleton;

/**
 * @Description :  单例模式 懒汉式（Lazy 懒加载）：第一次获取时创建实例
 * @Author :  yangzhuo
 * @Date :  2020/9/7 13:53
 * @Version :  1.0
 */
public class SingletonLazy_3 {

    /**
     * 私有静态变量
     */
    private static SingletonLazy_3 instance;

    /**
     * 私有构造方法
     */
    private SingletonLazy_3() {
    }

    /**
     * 公有静态get方法
     * 线程安全的写法之一
     * 引发问题：每一次调用get方法都会加锁，依然还可以优化
     */
    public static SingletonLazy_3 getInstance() {
        // 业务逻辑代码...
        synchronized (SingletonLazy_3.class) {
            if (instance == null) {
                instance = new SingletonLazy_3();
            }
            return instance;
        }
    }
}
