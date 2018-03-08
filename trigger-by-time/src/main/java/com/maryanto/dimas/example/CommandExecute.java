package com.maryanto.dimas.example;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class CommandExecute implements Job {


    private final static Logger console = LoggerFactory.getLogger(CommandExecute.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        console.info("job executed at {}", new Date());
    }
}
