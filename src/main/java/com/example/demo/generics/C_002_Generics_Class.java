package com.example.demo.generics;

/**
 * 泛型类
 */
public class C_002_Generics_Class<T> {

    private T key;

    public C_002_Generics_Class() {

    }

    public C_002_Generics_Class(T key) {
        this.key = key;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }
}
