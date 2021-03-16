package com.example.demo.base;

/**
 * 罗马数字转整数
 */
public class C_023_RomanToInt {

    public static void main(String[] args) {
        // I II III IV V VI VII VIII IX X
        // X XX XXX XL L LX LXX LXXX XC C
        // C CC CCC CD D DC DCC DCCC CM M
        StringBuilder roman = new StringBuilder("LVIII");
        int sum = 0;
        if (roman.indexOf("IV") > -1) {
            roman.delete(roman.indexOf("IV"), roman.indexOf("IV") + 2);
            sum += 4;
        } else if (roman.indexOf("IX") > -1) {
            roman.delete(roman.indexOf("IX"), roman.indexOf("IX") + 2);
            sum += 9;
        }
        if (roman.indexOf("XL") > -1) {
            roman.delete(roman.indexOf("XL"), roman.indexOf("XL") + 2);
            sum += 40;
        } else if (roman.indexOf("XC") > -1) {
            roman.delete(roman.indexOf("XC"), roman.indexOf("XC") + 2);
            sum += 90;
        }
        if (roman.indexOf("CD") > -1) {
            roman.delete(roman.indexOf("CD"), roman.indexOf("CD") + 2);
            sum += 400;
        } else if (roman.indexOf("CM") > -1) {
            roman.delete(roman.indexOf("CM"), roman.indexOf("CM") + 2);
            sum += 900;
        }
        for (int i = roman.length() - 1; i >= 0; i--) {
            String s = String.valueOf(roman.charAt(i));
            if ("I".equals(s)) {
                sum += 1;
            } if ("V".equals(s)) {
                sum += 5;
            } if ("X".equals(s)) {
                sum += 10;
            } if ("L".equals(s)) {
                sum += 50;
            } if ("C".equals(s)) {
                sum += 100;
            } if ("D".equals(s)) {
                sum += 500;
            } if ("M".equals(s)) {
                sum += 1000;
            }
        }
        System.out.println(sum);
    }
}
