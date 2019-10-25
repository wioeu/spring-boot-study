package com.example.jobs;

import lombok.extern.slf4j.Slf4j;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @ClassName JobOne
 * @Description 定时任务的具体执行逻辑类
 */
@Slf4j
@DisallowConcurrentExecution
public class JobOne implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        String time = LocalDateTime.ofInstant(new Date().toInstant(),
                ZoneId.systemDefault()).
                format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        log.info(time.concat("JobOne.execute"));
    }
}
