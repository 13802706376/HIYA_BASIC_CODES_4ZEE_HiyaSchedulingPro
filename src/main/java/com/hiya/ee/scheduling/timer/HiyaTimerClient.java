package com.hiya.ee.scheduling.timer;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public class HiyaTimerClient
{
    public static void main(String[] args)
    {
        //多少秒之后执行
        Timer timer = new Timer();
        timer.schedule(new HiyaTimerTask("多少秒之后执行"), 2000);
        
        //指定时间执行 
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 14);
        calendar.set(Calendar.MINUTE, 48);
        calendar.set(Calendar.SECOND, 00);
        Date time = calendar.getTime();
        timer.schedule(new HiyaTimerTask("指定时间执行"), time);
        
        //在延迟指定时间后以指定的间隔时间循环执行定时任务
        timer.schedule(new HiyaTimerTask("延迟指定时间后以指定的间隔时间循环执行定时任务"), 2000,3000);
        
        /*
         * HiyaTimerTask exec: 延迟指定时间后以指定的间隔时间循环执行定时任务; 时间：2018-08-09T14:57:59.262
            HiyaTimerTask exec: 保持执行频率的稳定; 时间：2018-08-09T14:57:59.263
            HiyaTimerTask exec: 保持执行频率的稳定; 时间：2018-08-09T14:58:00.243
            HiyaTimerTask exec: 保持执行频率的稳定; 时间：2018-08-09T14:58:01.243
            HiyaTimerTask exec: 保持执行频率的稳定; 时间：2018-08-09T14:58:02.243
            HiyaTimerTask exec: 延迟指定时间后以指定的间隔时间循环执行定时任务; 时间：2018-08-09T14:58:02.243
            HiyaTimerTask exec: 保持执行频率的稳定; 时间：2018-08-09T14:58:03.243
            HiyaTimerTask exec: 保持执行频率的稳定; 时间：2018-08-09T14:58:04.243
            HiyaTimerTask exec: 保持执行频率的稳定; 时间：2018-08-09T14:58:05.243
            HiyaTimerTask exec: 延迟指定时间后以指定的间隔时间循环执行定时任务; 时间：2018-08-09T14:58:05.243
         */
        //schedule方法侧重保存间隔时间的稳定，而scheduleAtFixedRate方法更加侧重于保持执行频率的稳定。
        timer.scheduleAtFixedRate(new HiyaTimerTask("保持执行频率的稳定"), 2000, 1000);
        
        
    }

}
