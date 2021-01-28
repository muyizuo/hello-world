#### CGLIB 动态代理
##### 1. 介绍
JDK 动态代理有一个最致命的问题是其只能代理实现了接口的类。

为了解决这个问题，我们可以用 CGLIB 动态代理机制来避免。

CGLIB(Code Generation Library)是一个基于ASM的字节码生成库。它允许我们在运行时对字节码进行修改和动态生成。
CGLIB通过继承方式实现代理。很多知名的开源框架都使用到了CGLIB，例如Spring中的AOP模块中：如果目标对象实现了接口，则默认采用JDK动态代理，
否则采用CGLIB动态代理。

**在CGLIB动态代理机制中 `MethodInterceptor` 接口和 `Enhancer` 类是核心。**

你需要自定义 `MethodInterceptor` 并重写 `intercept` 方法，`intercept` 用于拦截增强被代理类的方法。
```
public interface MethodInterceptor
extends Callback{
    // 拦截被代理类中的方法
    public Object intercept(Object obj, java.lang.reflect.Method method, Object[] args,
                               MethodProxy proxy) throws Throwable;
}
```
1. obj：被代理的对象（需要增强的对象）
2. method：被拦截的方法（需要增强的方法）
3. args：方法入参
4. methodProxy：用于调用原始方法

你可以通过 `Enhancer` 来动态获取被代理类，当代理类调用方法的时候，实际调用的是 `MethodInterceptor` 中的 `Intercept` 方法。

##### 2. CGLIB 动态代理类使用步骤
1. 定义一个类；
2. 自定义 `MethodInterceptor` 并重写 `intercept` 方法，`intercept` 用于拦截增强被代理类的方法，和 JDK 动态代理中的 `invoke` 方法类似；
3. 通过 `Enhancer` 类的 `create()` 创建代理类；

不同于 JDK 动态代理不需要额外的依赖。CGLIB(Code Generation Library) 实际是属于一个开源项目，如果你要使用它的话，需要手动添加相关依赖。
```
<dependency>
  <groupId>cglib</groupId>
  <artifactId>cglib</artifactId>
  <version>3.3.0</version>
</dependency>
```

##### 3. JDK 动态代理的优缺点
1. 优点：可以代理未实现任何接口的类。
2. 缺点：CGLIB 动态代理是通过生成一个被代理类的子类来拦截被代理类的方法调用，因此不能代理声明为 final 类型的类和方法。