package com.miaomiao;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Hello world!
 *
 */
public class App 
{
   static ExecutorService s = Executors.newCachedThreadPool();

    public static void main( String[] args )
    {
//        int hour = 24;
//        long mi = hour * 60 * 60 * 1000;
//        System.out.println(mi);
//        //int类型越界了
//        long mic = hour * 60 * 60 * 1000 * 1000;
//        System.out.println(mic);
//        System.out.println(mic/mi);
//        System.out.println( "Hello World!" );

        String m [] = new String[1];
        m[0] = "123";
        System.out.println(m);

        System.out.println(Thread.currentThread().getName());
        s.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
    }
}