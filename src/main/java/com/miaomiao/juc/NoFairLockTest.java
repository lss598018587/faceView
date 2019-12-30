package com.miaomiao.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class NoFairLockTest {
    public static void main(String[] args) {
        //创建非公平锁
       final ReentrantLock lock = new ReentrantLock(true);

        new Thread(new Runnable() {
            @Override
            public void run() {
               try {
                   lock.lock();
                   Thread.sleep(3000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               } finally {
                   lock.unlock();
               }
            }
        },"t1").start();
        try {
            Thread.sleep(1000);

            //加锁
            lock.lock();

            //模拟业务处理用时
            TimeUnit.SECONDS.sleep(1);

        } catch (InterruptedException e) {
            e.printStackTrace();

        } finally {
            //释放锁
            lock.unlock();
        }
    }
}
