package com.example.demo.newtime;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
        System.out.println(LocalDateTime.now());
    }
}
