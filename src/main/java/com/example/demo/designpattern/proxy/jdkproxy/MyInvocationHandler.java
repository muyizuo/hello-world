package com.example.demo.designpattern.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 实现InvocationHandler接口，通过重写invoke方法对目标类的行为进行增强扩展。
 */
public class MyInvocationHandler implements InvocationHandler {

    /** 注入目标类的对象 */
    private final Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    /**
     * @param proxy  动态生成的代理类
     * @param method 与代理类对象调用的方法相对应
     * @param args   当前 method 方法的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 方法调用前做一些事
        System.out.println("before method!!!");
        // 实际调用的方法
        Object result = method.invoke(target, args);
        // 方法调用后做一些事
        System.out.println("after method!!!");
        return result;
    }
}
