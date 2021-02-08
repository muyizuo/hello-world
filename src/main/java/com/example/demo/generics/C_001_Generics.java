package com.example.demo.generics;

/**
 * 1.Java 泛型（generics）是 JDK 5 中引入的一个新特性, 泛型提供了编译时类型安全检测机制，该机制允许程序员在编译时检测到非法的类型。
 * 泛型的本质是参数化类型，也就是说所操作的数据类型被指定为一个参数。
 *
 * 2.Java 的泛型是伪泛型，这是因为 Java 在编译期间，所有的泛型信息都会被擦掉，这也就是通常所说类型擦除 。
 *
 * 3.泛型一般有三种使用方式:泛型类、泛型接口、泛型方法。
 *
 * 4.常用的通配符为： T，E，K，V，？
 * - ？ 表示不确定的 java 类型
 * - T (type) 表示具体的一个 java 类型
 * - K V (key value) 分别代表 java 键值中的 Key Value
 * - E (element) 代表 Element
 */
public class C_001_Generics {

    public static void main(String[] args) {
        // 泛型类
        C_002_Generics_Class<Integer> c1 = new C_002_Generics_Class<>(123);
        System.out.println(c1.getKey());
        // 泛型接口
        // 泛型方法
        C_006_Generics_Method.printArray(new String[]{"a", "b", "c"});
        C_006_Generics_Method.printArray(new Integer[]{1, 2, 3, 4});
    }
}
