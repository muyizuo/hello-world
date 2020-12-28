package com.example.demo.lambda;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class C_002 {

    public static void main(String[] args) {
        List<Object> logs = new ArrayList<>();
        // logs.add("主要内容：{}，其他内容：{}{}{}");
        logs.add("主要内容：，其他内容：");
        logs.add("123");
        logs.add("456");
        logs.add("789");
        logs.add(true);
        logs.add(false);
        String logText = logs.get(0).toString();
        if (logText.contains("{}")) {
            for (int i = 1; i < logs.size(); i++) {
                logText = logText.replaceFirst("\\{\\}", logs.get(i).toString());
            }
        } else {
            logText = logs.stream().map(Object::toString).reduce("", String::concat);
        }
        System.out.println(logText);
    }
}
