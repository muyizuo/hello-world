package com.example.demo.designpattern.singleton;

/**
 * @Description :  通过静态内部类实现单例模式懒加载
 * @Author      :  yangzhuo
 * @Date        :  2020/9/8 10:54
 * @Version     :  1.0
 */
public class SingletonLazy_5 {

    /** 私有静态内部类 */
    private static class Inner {
        private static final SingletonLazy_5 INSTANCE = new SingletonLazy_5();
    }

    /** 私有构造方法 */
    private SingletonLazy_5() {}

    /** 公有静态get方法 */
    public static SingletonLazy_5 getInstance() {
        return Inner.INSTANCE;
    }
}
