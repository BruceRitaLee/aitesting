package com.huicewang.aitesting.config;

import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import java.util.Date;

public class TaskExecuctor  {


    public void executeTask(){
        System.out.println("我开始执行了哇");
    }
   // @Override
//    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
//        scheduledTaskRegistrar.addCronTask(
//                this::executeTask,
//                triggerContext -> {
//                    String cron = "0/30 * * * * ?";
//                    return  ;
//                }
//        );
//
//    }
}


