package com.hiya.ee.scheduling.executor;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class HiyaScheduledExecutorService
{
    private ScheduledExecutorService scheduExec;
    public long start;

    HiyaScheduledExecutorService()
    {
        this.scheduExec = Executors.newScheduledThreadPool(2);
        this.start = System.currentTimeMillis();
    }

    public void timerOne()
    {
            scheduExec.schedule(() -> 
            {
                System.out.println("timerOne,the time:" + (System.currentTimeMillis() - start));
                try
                {
                    Thread.sleep(4000);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        , 1000, TimeUnit.MILLISECONDS);
    }

    public void timerTwo()
    {
            scheduExec.schedule(() ->
            {
                System.out.println("timerTwo,the time:" + (System.currentTimeMillis() - start));
            }, 2000, TimeUnit.MILLISECONDS);
    }
    
    /** 
     * 以固定延迟时间进行执行 
     * 本次任务执行完成后，需要延迟设定的延迟时间，才会执行新的任务 
     */  
    public static void executeFixedDelay() {  
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);  
        executor.scheduleWithFixedDelay(  
                () -> {},  
                0,  
                100,  
                TimeUnit.MILLISECONDS);  
    } 
    
    
    /** 
     * 每天晚上8点执行一次 
     * 每天定时安排任务进行执行 
     */  
    public static void executeEightAtNightPerDay() {  
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);  
        long oneDay = 24 * 60 * 60 * 1000;  
        long initDelay  = getTimeMillis("20:00:00") - System.currentTimeMillis();  
        initDelay = initDelay > 0 ? initDelay : oneDay + initDelay;  
        executor.scheduleAtFixedRate(  
                () -> {},  
                initDelay,  
                oneDay,  
                TimeUnit.MILLISECONDS);  
    }  
    
    /** 
     * 获取指定时间对应的毫秒数 
     * @param time "HH:mm:ss" 
     * @return 
     */  
    private static long getTimeMillis(String time) {  
        try {  
            DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");  
            DateFormat dayFormat = new SimpleDateFormat("yy-MM-dd");  
            Date curDate = dateFormat.parse(dayFormat.format(new Date()) + " " + time);  
            return curDate.getTime();  
        } catch (ParseException e) {  
            e.printStackTrace();  
        }  
        return 0;  
    }  

    public static void main(String[] args)
    {
        HiyaScheduledExecutorService test = new HiyaScheduledExecutorService();
        test.timerOne();
        test.timerTwo();
    }
}
