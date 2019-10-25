package com.example.controller;

import com.example.model.Task;
import com.example.service.QuartzJobService;
import org.quartz.JobKey;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName JobController
 * @Description JobController
 */
@RestController
public class JobController {

    @Autowired
    QuartzJobService quartzJobService;

    //创建&启动
    @PostMapping("startJob")
    public String startJob(@RequestBody Task task) throws SchedulerException, ClassNotFoundException {
        quartzJobService.scheduleJob(task);
        return "startMyFirstJob Success!";
    }

    //暂停
    @PostMapping("pauseJob")
    public String pauseJob(@RequestBody Task task)throws SchedulerException{
        quartzJobService.pauseJob(task.getJobKey());
        return "pauseMyFirstJob Success!";
    }

    //恢复
    @PostMapping("resumeJob")
    public String resumeJob(@RequestBody Task task)throws SchedulerException{
        quartzJobService.resumeJob(task.getJobKey());
        return "resumeMyFirstJob Success!";
    }

    //删除
    @PostMapping("delJob")
    public String delJob(@RequestBody Task task)throws SchedulerException{
        quartzJobService.deleteJob(task.getJobKey());
        return "resumeMyFirstJob Success!";
    }

    //修改
    @PostMapping("modifyJob")
    public String modifyJob(@RequestBody Task task){
        if(quartzJobService.modifyJobCron(task)){
            return "modifyMyFirstJob Success!";
        }else{
            return "modifyMyFirstJob Fail!";
        }
    }
}
