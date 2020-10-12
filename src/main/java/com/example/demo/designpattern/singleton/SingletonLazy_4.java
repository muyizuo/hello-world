package com.example.demo.designpattern.singleton;

/**
 * @Description :  单例模式 懒汉式（Lazy 懒加载）：第一次获取时创建实例
 * @Author :  yangzhuo
 * @Date :  2020/9/7 13:53
 * @Version :  1.0
 */
public class SingletonLazy_4 {

    /**
     * 私有静态变量
     */
    private static volatile SingletonLazy_4 instance;

    /**
     * 私有构造方法
     */
    private SingletonLazy_4() {
    }

    /**
     * 公有静态get方法
     * 线程安全的写法之一（双重检查锁Double Check Lock，也叫双重检查单例）
     * 注意instance变量要加volatile关键字
     */
    public static SingletonLazy_4 getInstance() {
        // 业务逻辑代码...
        if (instance == null) {
            synchronized (SingletonLazy_4.class) {
                if (instance == null) {
                    instance = new SingletonLazy_4();
                }
                return instance;
            }
        }
        return instance;
    }
}
