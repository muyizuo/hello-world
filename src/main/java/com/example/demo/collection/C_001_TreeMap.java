package com.example.demo.collection;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * TreeMap只能根据Key来排序
 */
public class C_001_TreeMap {

    public static void main(String[] args) {
        Map<String, Person> hashMap = new HashMap<>();
        hashMap.put("c", new Person("张三", 21));
        hashMap.put("b", new Person("李四", 20));
        hashMap.put("a", new Person("王五", 23));
        hashMap.put("d", new Person("赵六", 22));
        System.out.println(hashMap.keySet());
        System.out.println(hashMap.values());
        TreeMap<String, Person> treeMap = new TreeMap<>((o1, o2) -> -o1.compareTo(o2));
        treeMap.putAll(hashMap);
        System.out.println(treeMap);
    }
}
