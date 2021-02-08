package com.example.demo.base;

/**
 * 字符串常量池
 */
public class C_019_String_Constant_Pool {

    public static void main(String[] args) {
        String a = "123";
        String b = "123";
        String c = String.valueOf("123");
        System.out.println(a == b);
        System.out.println(a == c);
    }
}
