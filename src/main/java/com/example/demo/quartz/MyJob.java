package com.example.demo.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.time.LocalDateTime;

/**
 * @Description: 实现Job
 * @Author: yz
 * @Date: 2021-3-17 14:08
 */
public class MyJob implements Job {

    /**
     * Job是Quartz中的一个接口，接口下只有execute方法，在这个方法中编写业务逻辑。
     *
     * JobExecutionContext中包含了Quartz运行时的环境以及Job本身的详细数据信息。
     *
     * @param jobExecutionContext
     * @throws JobExecutionException
     */
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("MyJob execute!!!" + LocalDateTime.now());
    }
}
