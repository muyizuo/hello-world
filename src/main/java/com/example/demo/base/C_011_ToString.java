package com.example.demo.base;

import java.util.*;

public class C_011_ToString {

    public static void main(String[] args) {
        // HashSet的toString实际是AbstractCollection中的toString
        Set<String> set = new HashSet<>();
        set.add("123");
        System.out.println(set.toString());
        // ArrayList的toString实际也是AbstractCollection中的toString
        List<String> list = new ArrayList<>();
        list.add("456");
        System.out.println(list.toString());
        // HashMap的toString实际是AbstractMap中的toString
        Map<String, Object> map = new HashMap<>();
        map.put("a", "b");
        System.out.println(map.toString());
    }
}
