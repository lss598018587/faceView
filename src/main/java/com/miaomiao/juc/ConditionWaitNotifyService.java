package com.miaomiao.juc;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionWaitNotifyService {
    private Lock lock = new ReentrantLock();
    public Condition condition = lock.newCondition();


    public void await(){
        try{
            lock.lock();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println(Thread.currentThread().getName()+"await的时间为 " + format.format(new Date()));
            condition.await();
            System.out.println(Thread.currentThread().getName()+"await结束的时间" + format.format(new Date()));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }


    public void signal(){
        try{
            lock.lock();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println("sign的时间为" + format.format(new Date()));
            condition.signal();
        }finally {
            lock.unlock();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        final ConditionWaitNotifyService service = new ConditionWaitNotifyService();
        new Thread(new Runnable() {
            @Override
            public void run() {
                service.await();
            }
        },"t1").start();
//        Thread.sleep(1000);
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                service.await();
//            }
//        },"t2").start();
//        Thread.sleep(1000);
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                service.await();
//            }
//        },"t3").start();
        Thread.sleep(1000 * 3);
//        service.signal();
//        Thread.sleep(1000 * 3);
//        service.signal();
//        Thread.sleep(1000 * 3);
        service.signal();
        Thread.sleep(1000);
    }
}
