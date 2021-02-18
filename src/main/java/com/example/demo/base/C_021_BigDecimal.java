package com.example.demo.base;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * BigDecimal
 *
 * 浮点数之间的等值判断，基本数据类型不能用==来比较，包装数据类型不能用 equals 来判断。
 *
 * 在使用BigDecimal时，为了防止精度丢失，推荐使用它的 BigDecimal(String) 构造方法来创建对象。
 *
 * 总结：
 * - BigDecimal 主要用来操作（大）浮点数，BigInteger 主要用来操作大整数（超过 long 类型）。
 * - BigDecimal 的实现利用到了 BigInteger, 所不同的是 BigDecimal 加入了小数位的概念。
 */
public class C_021_BigDecimal {

    public static void main(String[] args) {
        // 浮点数之间的等值判断，基本数据类型不能用==来比较，包装数据类型不能用 equals 来判断。
        float f1 = 0.3f - 0.2f;
        float f2 = 0.2f - 0.1f;
        System.out.println(f1); // 0.10000001
        System.out.println(f2); // 0.1
        System.out.println(f1 == f2); // false

        // 出现问题：精度丢失！！！
        // 解决方案：使用 BigDecimal 来定义浮点数的值，再进行浮点数的运算操作。
        BigDecimal b1 = new BigDecimal("0.3");
        BigDecimal b2 = new BigDecimal("0.2");
        BigDecimal b3 = new BigDecimal("0.1");
        System.out.println(b1.subtract(b2)); // 0.1
        System.out.println(b2.subtract(b3)); // 0.1
        System.out.println(Objects.equals(b1.subtract(b2), b2.subtract(b3))); // true

        // 推荐使用BigDecimal(String)
        BigDecimal b4 = new BigDecimal("0.1");
        // 使用BigDecimal(double)仍会有精度问题
        BigDecimal b5 = new BigDecimal(0.1);
        // BigDecimal.valueOf(double)也可以
        BigDecimal b6 = BigDecimal.valueOf(0.1);
        System.out.println(b4);
        System.out.println(b5);
        System.out.println(b6);
    }
}
