package com.maryanto.dimas.example;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class CommandExecute implements Job {

    private final Logger console = LoggerFactory.getLogger(CommandExecute.class);

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        console.info("executed at {}", new Date());
    }
}
