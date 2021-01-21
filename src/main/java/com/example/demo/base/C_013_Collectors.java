package com.example.demo.base;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class C_013_Collectors {

    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("zhangsan", 20));
        list.add(new Person("lisi", 21));
        list.add(new Person("wangwu", 20));
        list.add(new Person("zhaoliu", 21));
        // 按年龄进行分组
        Map<Integer, List<Person>> collect = list.stream().collect(Collectors.groupingBy(Person::getAge));
        System.out.println(collect);
    }

    @Getter
    @Setter
    private static class Person {
        private String name;
        private Integer age;

        public Person() {
        }

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
