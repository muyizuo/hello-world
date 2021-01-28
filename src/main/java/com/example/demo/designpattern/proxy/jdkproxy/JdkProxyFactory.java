package com.example.demo.designpattern.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 创建代理类的工厂
 */
public class JdkProxyFactory {

    public static Object getProxy(Object target) {
        // 创建代理类对象
        /*return Proxy.newProxyInstance(
                target.getClass().getClassLoader(), // 目标类的类加载
                target.getClass().getInterfaces(),  // 代理需要实现的接口，可指定多个
                new MyInvocationHandler(target)     // 代理对象对应的自定义 InvocationHandler
        );*/

        // 语法方面优化
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(), // 目标类的类加载
                target.getClass().getInterfaces(),  // 代理需要实现的接口，可指定多个
                // 代理对象对应的自定义 InvocationHandler
                (proxy, method, args) -> {
                    // 方法调用前做一些事
                    System.out.println("before method!!!");
                    // 实际调用的方法
                    Object result = method.invoke(target, args);
                    // 方法调用后做一些事
                    System.out.println("after method!!!");
                    return result;
                }
        );
    }
}
