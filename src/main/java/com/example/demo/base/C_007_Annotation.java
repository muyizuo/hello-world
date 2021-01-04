package com.example.demo.base;

import java.lang.annotation.*;
import java.util.Arrays;

/**
 * 元注解：@Target @Retention @Documented @Inherited
 * 元注解的作用就是负责注解其他注解。
 * 1.@Target：用于描述注解的使用范围（即：被描述的注解可以用在什么地方）
 *   Annotation可被用于 packages、types（类、接口、枚举、Annotation类型）、类型成员（方法、构造方法、成员变量、枚举值）、
 *   方法参数和本地变量（如循环变量、catch参数）。
 * 2.@Retention：表示需要在什么级别保存该注释信息，用于描述注解的生命周期（即：被描述的注解在什么范围内有效）
 * 3.@Documented：用于描述其它类型的annotation应该被作为被标注的程序成员的公共API
 * 4.@Inherited：阐述了某个被标注的类型是被继承的
 *
 * 自定义注解：
 * 定义注解格式：public @interface 注解名 {定义体}
 *
 */
public class C_007_Annotation {

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface MyAnnotation {
        String value() default "";
    }

    @MyAnnotation("test1")
    public class T_User {
        private String userName;
        private String psw;
    }

    public static void main(String[] args) {
        Class<T_User> c = T_User.class;
        Annotation[] declaredAnnotations = c.getDeclaredAnnotations();
        System.out.println(Arrays.toString(declaredAnnotations));
        MyAnnotation myAnnotation = c.getDeclaredAnnotation(MyAnnotation.class);
        System.out.println(myAnnotation.value());

    }
}
