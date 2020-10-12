package com.example.demo.designpattern.singleton;

/**
 * @Description :  单例模式 懒汉式（Lazy 懒加载）：第一次获取时创建实例
 * @Author :  yangzhuo
 * @Date :  2020/9/7 13:53
 * @Version :  1.0
 */
public class SingletonLazy_1 {

    /**
     * 私有静态变量
     */
    private static SingletonLazy_1 instance;

    /**
     * 私有构造方法
     */
    private SingletonLazy_1() {
    }

    /**
     * 公有静态get方法
     * 以下写法不是线程安全的
     */
    public static SingletonLazy_1 getInstance() {
        if (instance == null) {
            instance = new SingletonLazy_1();
        }
        return instance;
    }
}
