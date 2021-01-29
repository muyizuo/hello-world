package com.example.demo.newtime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class C_001 {

    public static void main(String[] args) {
        // jdk1.8引入新的时间API
        // 获取当前时间
        Instant now = Instant.now();
        // T代表东西经0°经线区时：伦敦时间
        System.out.println(now); // 2020-09-15T01:58:38.261Z
        // 旧日期转换为新日期
        Instant instant = Instant.ofEpochMilli(System.currentTimeMillis());
        System.out.println(instant);
        // 文本转日期
        Instant parse = Instant.parse("2020-09-15T01:58:38.261Z");
        System.out.println(parse);
        // 不带时区的日期
        System.out.println(LocalDate.now()); // 2021-01-25
        System.out.println(LocalTime.now()); // 10:32:27.717
        System.out.println(LocalDateTime.now()); // 2021-01-25T10:32:27.717
        System.out.println(Year.now()); // 2021
        System.out.println(YearMonth.now()); // 2021-01
        // 日期时间格式化
        // 时间转字符串
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String format = dateTimeFormatter.format(LocalDateTime.now());
        System.out.println(format); // 2021/01/29 10:51:15
        // 字符串转时间
        LocalDateTime parse1 = LocalDateTime.parse("2021/01/29 10:51:15", dateTimeFormatter);
        LocalDateTime parse2 = LocalDateTime.parse("2021-01-29T10:51:15.111");
        System.out.println(parse1);
        System.out.println(parse2);
    }
}
