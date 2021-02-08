package com.example.demo.generics;

/**
 * 实现泛型接口，指定类型
 */
public class C_005_Generics_InterfaceImpl2<T> implements C_003_Generics_Interface<String> {

    @Override
    public String m1() {
        return "null";
    }
}
