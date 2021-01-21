package com.example.demo.base;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class C_012 {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.addAll(Collections.emptySet());
        System.out.println(set);
    }
}
