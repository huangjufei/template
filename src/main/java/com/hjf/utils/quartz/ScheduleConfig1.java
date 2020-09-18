package com.hjf.utils.quartz;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 该定时器使用于有并发任务的
 * 需要导入spring-boot-starter-quartz 的jar包
 * SpringBoot整合了Quartz，而且使用起来比Quartz简单许多，
 * 下面代码来至下面这个url
 * https://www.jianshu.com/p/61e3abc22fbd
 */
//@Configuration 打开就可以看到效果
public class ScheduleConfig1 {

    /**
     * 创建一个JobDetail
     * @return
     */
    @Bean
    public JobDetail task1JobDetail() {
        return JobBuilder.newJob(Task1.class)
                .withIdentity("task1")
                .storeDurably(true)
                .build();
    }
    /**
     * 创建一个JobDetail
     * @return
     */
    @Bean
    public JobDetail task2JobDetail() {
        return JobBuilder.newJob(Task2.class)
                .withIdentity("task2")
                .storeDurably(true)
                .build();
    }

    /**
     * 关联任务并添加cron执行时间,并设置名字
     * @return
     */
    @Bean
    public Trigger task1Trigger() {
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("*/40 * * * * ?");
        return TriggerBuilder.newTrigger()
                .forJob(task1JobDetail())
                .withIdentity("task1")
                .withSchedule(scheduleBuilder)
                .build();
    }

    /**
     * 关联任务并添加cron执行时间,并设置名字
     * @return
     */
    @Bean
    public Trigger task2Trigger() {
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("*/40 * * * * ?");
        return TriggerBuilder.newTrigger()
                .forJob(task2JobDetail())
                .withIdentity("task2")
                .withSchedule(scheduleBuilder)
                .build();
    }
}