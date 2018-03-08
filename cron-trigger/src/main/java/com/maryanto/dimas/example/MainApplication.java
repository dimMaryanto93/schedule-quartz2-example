package com.maryanto.dimas.example;

import org.quartz.*;

public class MainApplication {

    public static void main(String[] args) throws SchedulerException {
        SchedulerFactory stdSchedulerFactory = new org.quartz.impl.StdSchedulerFactory();
        Scheduler scheduler = stdSchedulerFactory.getScheduler();
        scheduler.start();

        JobDetail job = JobBuilder.newJob(CommandExecute.class)
                .withIdentity("job3", "group3").build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("myTrigger", "group3")
                .startNow()
                .withSchedule(
                        CronScheduleBuilder.cronSchedule("0 42 15 1/1 * ? *"))
                .build();

        scheduler.scheduleJob(job, trigger);
    }
}
