package com.example.demo.designpattern.proxy.javassistproxy;

import javassist.util.proxy.ProxyFactory;

public class JavassistProxyFactory {

    public static Object getProxy(Class clazz) throws Exception{

        // 代理工厂
        ProxyFactory proxyFactory = new ProxyFactory();
        // 设置需要创建的子类
        proxyFactory.setSuperclass(clazz);
        proxyFactory.setHandler((self, thisMethod, proceed, args) -> {

            System.out.println("---- 开始拦截 ----");
            Object result = proceed.invoke(self, args);
            System.out.println("---- 结束拦截 ----");

            return result;
        });
        return proxyFactory.createClass().newInstance();

    }
}
