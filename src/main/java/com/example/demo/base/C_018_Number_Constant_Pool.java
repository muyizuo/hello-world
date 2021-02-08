package com.example.demo.base;

/**
 * 8 种基本类型的包装类和常量池
 *
 * Java 基本类型的包装类的大部分都实现了常量池技术，即 Byte,Short,Integer,Long,Character,Boolean；
 * 前面 4 种包装类默认创建了数值[-128，127] 的相应类型的缓存数据，
 * Character 创建了数值在[0,127]范围的缓存数据，
 * Boolean 直接返回 True Or False。
 * 如果超出对应范围仍然会去创建新的对象。
 *
 */
public class C_018_Number_Constant_Pool {

    public static void main(String[] args) {
        testInteger();
    }

    private static void test() {
        Byte b = Byte.valueOf((byte) 30); // 实现了常量池技术，缓存数值范围 [-128，127]
        Short s = Short.valueOf((short) 30); // 实现了常量池技术，缓存数值范围 [-128，127]
        Integer i = Integer.valueOf(30); // 实现了常量池技术，缓存数值范围 [-128，127]
        Long l = Long.valueOf(30); // 实现了常量池技术，缓存数值范围 [-128，127]
        Character c = Character.valueOf('a'); // 实现了常量池技术，缓存数值范围 [0,127]
        Boolean bool = Boolean.valueOf(true); // 直接返回 True Or False

        Float f = Float.valueOf(2.1f); // 没有实现常量池技术
        Double d = Double.valueOf(2.1); // 没有实现常量池技术
    }

    private static void testInteger() {
        // Java 在编译的时候会直接将代码封装成 Integer i=Integer.valueOf(127);，从而使用常量池中的对象。
        // 超过缓存数值范围 [-128，127]时，仍然会去创建新的对象。
        Integer i1 = 127;
        Integer i2 = 127;
        Integer i3 = 128;
        Integer i4 = 128;
        System.out.println((i1 == i2) + " " + (i3 == i4)); // true false
        Integer i5 = - 128;
        Integer i6 = - 128;
        Integer i7 = - 129;
        Integer i8 = - 129;
        System.out.println((i5 == i6) + " " + (i7 == i8));// true false
        // 其他例子
        Integer i = 40;
        Integer j = 40;
        Integer k = 0;
        System.out.println(i == j + k); // true
        Integer a = new Integer(40);
        Integer b = new Integer(40);
        Integer c = new Integer(0);;
        // 因为+这个操作符不适用于 Integer 对象，首先 b 和 c 进行自动拆箱操作，进行数值相加，即a == 40;
        // 然后 Integer 对象无法与数值进行直接比较，所以 a 自动拆箱转为 int 值 40，最终这条语句转为 40 == 40 进行数值比较。
        System.out.println(a == b + c); // true
        System.out.println(40 == b + c); // true
    }
}
