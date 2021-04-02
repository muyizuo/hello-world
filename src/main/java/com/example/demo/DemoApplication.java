package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot主程序
 *
 * 其中 @SpringBootApplication 来标注一个主程序类，说明这是一个Spring Boot应用。
 */
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        // Spring Boot应用启动
        SpringApplication.run(DemoApplication.class, args);
    }

}
