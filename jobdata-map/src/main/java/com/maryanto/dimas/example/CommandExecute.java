package com.maryanto.dimas.example;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class CommandExecute implements Job {

    private final static Logger console = LoggerFactory.getLogger(CommandExecute.class);

    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDataMap dataMap = context.getMergedJobDataMap();
        Map<String, Object> objects = dataMap.getWrappedMap();

        console.info("excuted with data injection { nim = {}, nama = {}, saldo = {}, createdDate = {}, isActive = {} }",
                objects.get("nim"),
                objects.get("nama"),
                objects.get("saldo"),
                objects.get("createdDate"),
                objects.get("isActive"));
    }
}
