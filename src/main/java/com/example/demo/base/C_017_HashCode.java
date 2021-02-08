package com.example.demo.base;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * 重写equals(),则必须重写hashCode()
 *
 */
public class C_017_HashCode {

    private String name;

    public C_017_HashCode() {
    }

    public C_017_HashCode(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        C_017_HashCode that = (C_017_HashCode) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        int hashCode;
        // 不重写hashCode
        // hashCode = super.hashCode();
        // 重写hashCode
        hashCode = Objects.hash(name);
        return hashCode;
    }

    @Override
    public String toString() {
        return "C_017_HashCode{" +
                "name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Set set = new HashSet<>();
        set.add(new C_017_HashCode("张三"));
        set.add(new C_017_HashCode("张三"));
        System.out.println(set);
    }
}
