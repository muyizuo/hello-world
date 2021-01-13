package com.example.demo.base;

import java.lang.reflect.Field;

public class C_009_CompareEntity {

    public static void main(String[] args) throws IllegalAccessException {
        Test zhangsan = new Test("zhangsan", 12);
        Test lisi = new Test("lisi", 23);
        Field[] fields = Test.class.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Object o1 = field.get(zhangsan);
            Object o2 = field.get(lisi);
            if (!o1.equals(o2)) {
                System.out.println(field.getName() + "值变化" + o1 + " -> " + o2);
            }
        }
    }
}

class Test {
    private String name;
    private Integer age;

    public Test() {
    }

    public Test(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
