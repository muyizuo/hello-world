package com.example.demo.base;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class C_005_Date {

    public static void main(String[] args) throws ParseException {
        /*String pattern = "yyyy-MM-dd HH:mm:ss.SSS";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        String result = format.format(new Date());
        System.out.println(result);
        Date parse = format.parse(result);
        System.out.println(parse);
        result = format.format(parse);
        System.out.println(result);*/
        try {
            test();
            /*Object o = null;
            o.toString();*/
            // throw new Exception("自定义异常");
        } catch (Exception e) {
            e.printStackTrace();
            // System.out.println(e);
            // System.out.println(e.getMessage());

        }

        try {
            String[] s = {"1", "2", "3"};
            Arrays.asList(s).stream().forEach(i -> {
                System.out.println(i);
                System.out.println(Integer.parseInt(i) / 0);
            });
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private static void test() {
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            // e.printStackTrace();
            System.out.println(e.getCause().getMessage());
        }
    }
}
