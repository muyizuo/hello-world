package com.example.demo.log;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class C_001_Slf4j {

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("batNo", "12345");
        map.put("msg", "消息内容");
        log.info("普通日志打印（单参数）");
        log.info("普通日志打印（String + Object），{}", map);
        log.info("普通日志打印（String + Object + Object），{}，{}", new Object(), new Object());
        log.info("普通日志打印（String + Object...），{}，{}，{}", new Object(), new Object(), new Object());
        log.info("普通日志打印（String + Throwable）", new Exception("自定义异常"));
        log.info(new Exception("自定义异常").toString());
        System.out.println(log.getName());
    }
}
