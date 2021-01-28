#### JDK 动态代理
##### 1. 介绍
在 JDK 动态代理机制中 `InvocationHandler` 接口和 `Proxy` 类是核心。  
`Proxy` 类中使用频率最高的方法是：`newProxyInstance()` ，这个方法主要用来生成一个代理对象。  
```
public static Object newProxyInstance(ClassLoader loader,
                                          Class<?>[] interfaces,
                                          InvocationHandler h)
        throws IllegalArgumentException
    {
        ......
    }
```
该方法一共有三个参数：
1. loader：类加载器，用于加载代理对象。
2. interfaces：被代理类实现的一些接口。
3. h：实现了 `InvocationHandler` 接口的对象。

要实现动态代理的话，还必须需要实现 `InvocationHandler` 来自定义处理逻辑。 
当我们的动态代理对象调用一个方法时候，这个方法的调用就会被转发到实现 `InvocationHandler` 接口类的 `invoke` 方法来调用。
```
public interface InvocationHandler {

    /**
     * 当你使用代理对象调用方法的时候实际会调用到这个方法
     */
    public Object invoke(Object proxy, Method method, Object[] args)
        throws Throwable;
}
```
invoke() 方法有下面三个参数：
1. proxy :动态生成的代理类
2. method : 与代理类对象调用的方法相对应
3. args : 当前 method 方法的参数

也就是说：你通过 `Proxy` 类的 `newProxyInstance()` 创建的代理对象在调用方法的时候，实际会调用到实现 `InvocationHandler` 接口的类的 `invoke()` 方法。 
你可以在 `invoke()` 方法中自定义处理逻辑，比如在方法执行前后做什么事情。

##### 2. JDK 动态代理类使用步骤
1. 定义一个接口及其实现类；
2. 自定义 `InvocationHandler` 并重写 `invoke` 方法，在 `invoke` 方法中我们会调用原生方法（被代理类的方法）并自定义一些处理逻辑；
3. 通过 `Proxy.newProxyInstance(ClassLoader loader,Class<?>[] interfaces,InvocationHandler h)` 方法创建代理对象；

##### 3. JDK 动态代理的优缺点
1. 优点：动态代理更加灵活。
2. 缺点：只能代理实现了接口的类。