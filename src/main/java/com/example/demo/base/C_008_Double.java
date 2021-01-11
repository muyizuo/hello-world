package com.example.demo.base;

import java.math.BigDecimal;

/**
 * @Description: Double数值精度丢失问题
 * @Author: yz
 * @Date: 2021/1/5 17:40
 */
public class C_008_Double {

    public static void main(String[] args) {
        Double d1 = 0.0031;
        Double d2 = 0.003;
        // double d1 = 0.01;
        // double d2 = 0.01;
        System.out.println(d1 >= d2);
        System.out.println(d1 + d2);
        System.out.println(d1.equals(d2));
        System.out.println(BigDecimal.valueOf(d1).compareTo(BigDecimal.valueOf(d2)));
    }
}
