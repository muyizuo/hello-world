package com.example.demo.designpattern.proxy.cglibproxy;

public class CglibProxyTest {

    public static void main(String[] args) {
        MyServiceClass myServiceClass = (MyServiceClass) CglibProxyFactory.getProxy(MyServiceClass.class);
        myServiceClass.myMethod();
    }
}
