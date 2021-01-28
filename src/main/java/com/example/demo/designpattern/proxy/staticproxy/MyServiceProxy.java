package com.example.demo.designpattern.proxy.staticproxy;

public class MyServiceProxy implements MyService {

    /**
     * 注入被代理类的对象
     */
    private final MyService myService;

    public MyServiceProxy(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void doSomething() {
        System.out.println(" before method doSomething ");
        myService.doSomething();
        System.out.println(" after method doSomething ");
    }
}
