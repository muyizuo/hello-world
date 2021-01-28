package com.example.demo.collection;

import java.util.*;
import java.util.stream.Collectors;

public class C_002_HashMap_Sort {

    public static void main(String[] args) {
        Map<String, Person> hashMap = new HashMap<>();
        hashMap.put("c", new Person("张三", 21));
        hashMap.put("b", new Person("李四", 20));
        hashMap.put("a", new Person("王五", 23));
        hashMap.put("d", new Person("赵六", 22));
        System.out.println(hashMap.keySet());
        System.out.println(hashMap.values());
        Map<String, Person> collect = hashMap.entrySet().stream().sorted(Comparator.comparing(o -> o.getValue().getAge())).
                collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        List<Map.Entry<String, Person>> list = hashMap.entrySet().stream()
                .sorted(Comparator.comparing(o -> o.getValue().getAge()))
                .collect(Collectors.toList());
        System.out.println(collect);
        System.out.println(list);
    }
}
