package com.maryanto.dimas.example;

import org.quartz.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MainApplication {

    public static void main(String[] args) throws SchedulerException {
        SchedulerFactory stdSchedulerFactory = new org.quartz.impl.StdSchedulerFactory();
        Scheduler scheduler = stdSchedulerFactory.getScheduler();
        scheduler.start();

        Map<String, Object> params = new HashMap();
        params.put("nim", "10511158");
        params.put("nama", "Dimas Maryanto");
        params.put("saldo", new BigDecimal(1000000));
        params.put("createdDate", new Date());
        params.put("isActive", false);

        JobDetail job = JobBuilder.newJob(CommandExecute.class)
                .withIdentity("job4", "group4")
                .usingJobData(new JobDataMap(params))
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("myTrigger", "group4")
                .startNow()
                .withSchedule(
                        SimpleScheduleBuilder.simpleSchedule()
                                .withIntervalInSeconds(10)
                                .repeatForever())
                .build();

        scheduler.scheduleJob(job, trigger);
    }
}
