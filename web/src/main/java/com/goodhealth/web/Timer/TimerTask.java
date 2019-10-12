package com.goodhealth.web.Timer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.goodhealth.comm.util.DateUtils;

import java.util.Date;


@Component
public class TimerTask {

    @Autowired
    private TimeWork timeWork;

//    cron 定时任务表达式 @Scheduled(cron=*/2 * * * * *) 表示每秒执行一次
    /**
    * crontab 工具 https://tool.lu/crontab/
    * fixedRate:定时多久执行一次 上一次开始执行时间点后xx秒再次执行
    * fixedDelay: 上一次执行结束时间点后xx秒再次执行
    * fixedDelayString:字符串形式，可以通过配置文件指定
    */
    @Scheduled(cron="0 * * * * ? *")
    public void getTime(){
        timeWork.task();
    }
}
