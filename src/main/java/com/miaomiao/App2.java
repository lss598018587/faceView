package com.miaomiao;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther: miaomiao
 * @Date: 2019-09-29 14:03
 * @Description:
 */
public class App2 {
    private final static Timer timer = new Timer("ScheduleOrderOutTimerThread");
//    private final static ScheduledExecutorService service = Executors.newScheduledThreadPool(1);

    public static void main(String[] args) throws ParseException, InterruptedException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("开始时间："+format.format(new Date()));
        Calendar cal = Calendar.getInstance();
        cal.setTime(getDate("2019-09-28 00:00:00"));
        timer.schedule(new DeliverDelayedMessageTimerTask(), 2000);
        System.out.println("结束时间："+format.format(new Date()));
        Thread.sleep(5000);
        timer.schedule(new DeliverDelayedMessageTimerTask(), cal.getTime());
    }

    public  static Date getDate(String date) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       return format.parse(date);
    }


    static class DeliverDelayedMessageTimerTask extends TimerTask {
        @Override
        public void run() {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println("线程执行的时间："+format.format(new Date()));
//            timer.cancel();
        }
    }
}
