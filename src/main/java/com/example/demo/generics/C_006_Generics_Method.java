package com.example.demo.generics;

/**
 * 泛型方法
 */
public class C_006_Generics_Method {

    static <E> void printArray(E[] arr) {
        for (E e : arr) {
            System.out.print(e);
        }
        System.out.println();
    }
}
