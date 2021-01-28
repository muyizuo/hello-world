package com.example.demo.designpattern.proxy.jdkproxy;

public class JdkProxyTest {

    public static void main(String[] args) {
        MyService myService = (MyService) JdkProxyFactory.getProxy(new MyServiceImpl());
        myService.run();
    }
}
