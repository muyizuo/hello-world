package com.example.demo.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * JobDetail绑定指定的Job，每次Scheduler调度执行一个Job的时候，首先会拿到对应的Job，然后创建该Job实例，
 * 再去执行Job中的execute()的内容，任务执行结束后，关联的Job对象实例会被释放，且会被JVM GC清除。
 *
 * 为什么设计成JobDetail + Job，不直接使用Job
 * JobDetail定义的是任务数据，而真正的执行逻辑是在Job中。
 * 这是因为任务是有可能并发执行，如果Scheduler直接使用Job，就会存在对同一个Job实例并发访问的问题。
 * 而JobDetail & Job 方式，Sheduler每次执行，都会根据JobDetail创建一个新的Job实例，这样就可以规避并发访问的问题。
 *
 * Trigger、SimpleTrigger、CronTrigger
 * Trigger是Quartz的触发器，会去通知Scheduler何时去执行对应Job。
 * SimpleTrigger可以实现在一个指定时间段内执行一次作业任务或一个时间段内多次执行作业任务。
 * CronTrigger功能非常强大，是基于日历的作业调度，而SimpleTrigger是精准指定间隔，所以相比SimpleTrigger，CroTrigger更加常用。
 */
public class MyScheduler {

    public static void main(String[] args) throws SchedulerException, InterruptedException {
        // 1、创建调度器Scheduler
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();

        // 2.创建JobDetail实例，并与Job实现类绑定
        JobDetail jobDetail = JobBuilder.newJob(MyJob.class).withIdentity("job1", "group1").storeDurably().build();

        // 3.构建Trigger实例
        // 每隔1s执行一次
        Trigger trigger1 = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "triggerGroup1")
                // 立即生效
                .startNow()
                .withSchedule(
                        SimpleScheduleBuilder.simpleSchedule()
                                // 每隔1s执行一次
                                .withIntervalInSeconds(10)
                                // 一直执行
                                .repeatForever()
                )
                .forJob(jobDetail)
                .build();
        String cronExpression = "0,30 * * * * ? *";
        Trigger trigger2 = TriggerBuilder.newTrigger()
                .withIdentity("trigger2", "triggerGroup2")
                // 立即生效
                .startNow()
                //
                .withSchedule(CronScheduleBuilder.cronSchedule(cronExpression))
                .forJob(jobDetail)
                .build();

        // 4.执行
        scheduler.addJob(jobDetail, true);
        scheduler.scheduleJob(trigger1);
        scheduler.scheduleJob(trigger2);
        System.out.println("--------scheduler start ! ------------");
        scheduler.start();

        // 10s后停止
        // TimeUnit.SECONDS.sleep(10);
        // scheduler.shutdown();
        // System.out.println("--------scheduler shutdown ! ------------");
    }
}
