package com.example.demo.base;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.Date;

public class C_004_Reflect {

    public static void main(String[] args) throws IllegalAccessException {
        Class<Person> c = Person.class;
        /*System.out.println("------------获取public属性------------");
        for (Field field : c.getFields()) {
            System.out.println(field.getName());
        }
        System.out.println("-------------获取所有属性-----------");
        for (Field field : c.getDeclaredFields()) {
            System.out.println(field.getName());
        }
        System.out.println("------------获取公用方法------------");
        for (Method method : c.getMethods()) {
            System.out.println(method.getName());
        }
        System.out.println("------------获取所有方法------------");
        for (Method method : c.getDeclaredMethods()) {
            System.out.println(method.getName());
        }*/
        // 注入值
        Person person = new Person();
        for (Field field : c.getDeclaredFields()) {
            // System.out.println(field.getName());
            if (field.getName().equals("name")) {
                field.setAccessible(true);
                field.set(person, "zhangsan");
            }
            if (field.getName().equals("age")) {
                field.setAccessible(true);
                field.set(person, 20);
            }
            if (field.getName().equals("birth")) {
                field.setAccessible(true);
                field.set(person, new Date());
            }
        }
        System.out.println(person);
    }
}

class Person {
    private String name;
    private Integer age;
    private Date birth;
    public String publicField;
    String defaultField;
    protected String protectedField;

    private void privateMethod() {

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

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birth=" + birth +
                ", publicField='" + publicField + '\'' +
                ", defaultField='" + defaultField + '\'' +
                ", protectedField='" + protectedField + '\'' +
                '}';
    }
}
