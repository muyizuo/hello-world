package com.example.demo.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * lambda表达式练习
 *
 */
public class C_001 {

    public static void main(String[] args) {
        // for循环
        List<Integer> list = new ArrayList<>();
        // list.add("A");
        // list.add("B");
        list.add(3);
        list.add(1);
        list.add(2);
        // list.add(true);
        // list.add(false);
        /*list.forEach(x->System.out.println(x));
        list.forEach(System.out::println);
        list.stream().forEach(x->System.out.println(x));
        list.stream().forEach(System.out::println);*/
        // 创建匿名内部类（要求实现的接口有且只有一个需要实现的方法）
        /*Test test = (x, y)-> System.out.println(x+y);
        test.m2("1", "2");*/
        // Stream API
        Stream<Integer> stream = list.stream();
        // System.out.println(stream.count());
        // System.out.println(stream.findFirst().get());
        // 过滤器filter
        // stream.filter(x->x instanceof Integer).forEach(x-> System.out.println(x));
        // 去重distinct
        // stream.distinct().forEach(System.out::println);
        // 排序
        /*stream.sorted((x, y)->{
            return x - y;
        }).forEach(System.out::println);*/
    }

    private interface Test {
        // void m1();
        void m2(String s1, String s2);
    }
}
