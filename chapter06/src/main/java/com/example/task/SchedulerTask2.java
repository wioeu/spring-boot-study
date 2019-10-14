package com.example.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SchedulerTask2 {

    //@Scheduled(fixedRate  = 3000)
    private void process(){
        System.out.println("SchedulerTask2 : " + LocalDateTime.now().toLocalTime() + "\r\n线程 : " + Thread.currentThread().getName());
    }
}
