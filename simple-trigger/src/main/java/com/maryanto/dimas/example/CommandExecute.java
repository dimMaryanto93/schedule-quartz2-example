package com.maryanto.dimas.example;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommandExecute implements Job {

    private Integer counter = 0;

    private final Logger console = LoggerFactory.getLogger(CommandExecute.class);

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        counter = counter + 1;
        console.info("executed {} times", counter);
    }
}
