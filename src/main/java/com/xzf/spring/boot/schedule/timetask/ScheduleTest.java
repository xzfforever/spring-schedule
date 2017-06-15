package com.xzf.spring.boot.schedule.timetask;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/6/15.
 */
@Component
public class ScheduleTest {

    public final static long ONE_Minute =  60 * 1000;

    /**
     * fixedDelay:每次业务完成以后，延迟指定的时间执行
     */
    @Scheduled(fixedDelay=ONE_Minute/30)
    public void fixedDelayJob(){
        for(int i=0;i<1000000;i++){

        }
        System.out.println("--------FixedDelayJob---------,current time:"+getDateString());
    }

    /**
     * fixedRate:以固定的频率执行，不管业务花了多少时间
     */
    @Scheduled(fixedRate=ONE_Minute/30)
    public void fixedRateJob(){
        for(int i=0;i<1000000;i++){

        }
        System.out.println("--------fixedRateJob---------,current time:"+getDateString());
    }


    @Scheduled(cron = "0/5 * * * * ?")
    public void schTest1() {
        String dateStr = getDateString();
        System.out.println("这是spring定时器1，每五秒执行一次,当前时间：" + dateStr);
    }

    private String getDateString() {
        Date date = new Date();
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sim.format(date);
    }

}
