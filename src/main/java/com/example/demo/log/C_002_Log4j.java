package com.example.demo.log;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class C_002_Log4j {

    public static void main(String[] args) {
        log.info("普通日志打印（单参数）");
        log.info("普通日志打印（String + Object），{}", new Object());
        log.info("普通日志打印（String + Object + Object），{}，{}", new Object(), new Object());
        log.info("普通日志打印（String + Object...），{}，{}，{}", new Object(), new Object(), new Object());
        log.info("普通日志打印（String + Throwable）", new Exception("自定义异常"));
        log.info(new Exception("自定义异常").toString());
    }
}
