package com.example.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SchedulerTask1 {

    //@Scheduled(cron = "*/6 * * * * ?")
    private void process(){
        System.out.println("SchedulerTask1 : " + LocalDateTime.now().toLocalTime() + "\r\n线程 : " + Thread.currentThread().getName());
    }
}
