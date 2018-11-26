package com.hiya.ee.scheduling.timer;

import java.time.LocalDateTime;
import java.util.TimerTask;

public class HiyaTimerTask extends TimerTask
{
    private String title;
    
    public HiyaTimerTask(String title)
    {
        this.title = title;
    }
    
    public void run()
    {
        for(int p =0;p<100000000;p++)
        {
               
        }
        LocalDateTime ld = LocalDateTime.now();
        System.out.println("HiyaTimerTask exec: "+title+"; 时间："+ld);
    }
}

