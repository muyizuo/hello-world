package com.example.demo.designpattern.proxy.javassistproxy;

public class JavassistProxyTest {

    public static void main(String[] args) throws Exception {
        MyServiceClass MyServiceClass = (MyServiceClass) JavassistProxyFactory.getProxy(MyServiceClass.class);
        MyServiceClass.doSomething();
    }
}
