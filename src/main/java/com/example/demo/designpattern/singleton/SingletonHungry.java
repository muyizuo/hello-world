package com.example.demo.designpattern.singleton;

/**
 * @Description :  单例模式 饿汉式：初始化时创建实例
 * @Author :  yangzhuo
 * @Date :  2020/9/7 13:49
 * @Version :  1.0
 */
public class SingletonHungry {

    /**
     * 私有静态变量
     */
    private static final SingletonHungry INSTANCE = new SingletonHungry();

    /**
     * 私有构造方法
     */
    private SingletonHungry() {
    }

    /**
     * 公有静态get方法
     */
    public static SingletonHungry getInstance() {
        return INSTANCE;
    }
}
