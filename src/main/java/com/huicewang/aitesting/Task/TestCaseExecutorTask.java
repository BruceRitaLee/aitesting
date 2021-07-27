package com.huicewang.aitesting.Task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TestCaseExecutorTask {
    private Logger  logger = LoggerFactory.getLogger(TestCaseExecutorTask.class);
    //@Scheduled(cron = "0 0/1 * ? * ?")
    private void executeTask(){
        logger.info(" 哈哈哈，我这个点正在运行");
    }
}
