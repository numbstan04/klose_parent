package com.klose.staservice.schedule;

import com.klose.staservice.service.StatisticsDailyService;

import com.klose.staservice.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author Klose
 * @create 2021-07-18-17:47
 */
@Component
public class ScheduledTask {

    @Autowired
    private StatisticsDailyService staService;


    @Scheduled(cron = "0/5 * * * * ?")
    public void task() {

    }

    //在每天凌晨1点，把前一天数据进行数据查询添加
    @Scheduled(cron = "0 0 1 * * ?")
    public void task2() {
        staService.registerCount(DateUtil.formatDate(DateUtil.addDays(new Date(), -1)));
    }
}
