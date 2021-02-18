package com.example.demo.base;

import lombok.Data;

/**
 * finally小练习
 *
 * 以下三种情况不会执行finally：
 * - 在 try 或 finally 块中用了 System.exit(int)退出程序。但是，如果 System.exit(int) 在异常语句之后，finally 还是会被执行
 * - 程序所在的线程死亡。
 * - 关闭 CPU。
 *
 * 使用 try-with-resources 来代替try-catch-finally。
 * 1.适用范围（资源的定义）： 任何实现 java.lang.AutoCloseable 或者 java.io.Closeable 的对象
 * 2.关闭资源和 final 的执行顺序： 在 try-with-resources 语句中，任何 catch 或 finally 块在声明的资源关闭后运行
 *
 */
public class C_020_Finally {

    public static void main(String[] args) {
        System.out.println(test1());
        System.out.println(test2());
        System.out.println(test3());
        test4();
    }

    public static String test1() {
        // finally中的return会覆盖try里面的return
        try {
            return "try return";
        } finally {
            return "finally return";
        }
    }

    public static Object test2() {
        // finally中为try中返回值的引用重新赋值，不会改变try中返回值
        int i;
        try {
            i = 200;
            return i;
        } finally {
            i = 230;
        }
    }

    public static Object test3() {
        // finally中为try中返回值（引用数据类型或数组）的内容，会改变try中返回值
        Person p = new Person();
        p.setName("张三");
        p.setAge(20);
        try {
            return p;
        } finally {
            p.setName("李四");
            p.setAge(22);
        }
    }

    public static void test4() {
        try {
            System.out.print(" try ");
            System.exit(0); // 退出程序，不会再执行finally
        } finally {
            System.out.print(" finally ");
        }
    }

    @Data
    private static class Person {
        private String name;
        private Integer age;
    }
}
