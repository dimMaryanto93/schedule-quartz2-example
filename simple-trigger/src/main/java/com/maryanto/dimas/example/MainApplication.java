package com.maryanto.dimas.example;

import org.quartz.*;

public class MainApplication {

    public static void main(String[] args) throws SchedulerException {
        SchedulerFactory stdSchedulerFactory = new org.quartz.impl.StdSchedulerFactory();
        Scheduler scheduler = stdSchedulerFactory.getScheduler();
        scheduler.start();

        JobDetail job = JobBuilder.newJob(CommandExecute.class)
                .withIdentity("job2", "group2").build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("myTrigger", "group2")
                .startNow()
                .withSchedule(
                        SimpleScheduleBuilder.simpleSchedule()
                                .withIntervalInSeconds(30)
                                .repeatForever())
                .build();

        scheduler.scheduleJob(job, trigger);
    }
}
