package com.hiya.ee.scheduling.quarzt;

import java.util.Date;
import org.quartz.JobExecutionException;
public class HiyaSpringJob1
{
    public void execute() throws JobExecutionException
    {
        System.out.println("say hello to at " + new Date());
    }
}