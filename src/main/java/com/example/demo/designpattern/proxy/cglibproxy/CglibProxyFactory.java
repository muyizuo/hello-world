package com.example.demo.designpattern.proxy.cglibproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxyFactory {

    public static Object getProxy(Class<?> clazz) {
        // 创建动态代理增强类
        Enhancer enhancer = new Enhancer();
        // 设置类加载器
        enhancer.setClassLoader(clazz.getClassLoader());
        // 设置被代理类
        enhancer.setSuperclass(clazz);
        // 设置方法拦截器
        // enhancer.setCallback(new MyMethodInterceptor());
        enhancer.setCallback((MethodInterceptor) (o, method, args, methodProxy) -> {

            System.out.println("before method " + method.getName());
            Object result = methodProxy.invokeSuper(o, args);
            System.out.println("after method " + method.getName());

            return result;
        });
        // 创建代理类
        return enhancer.create();
    }
}
