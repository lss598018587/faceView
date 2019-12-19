package com.miaomiao.classLoad.gc;

/*
    没有配置新生代的 Eden和from 和to的比例，默认是按照8：1：1的比例
    -Xmx200M -Xmn50M -XX:TargetSurvivorRatio=60 -XX:+PrintTenuringDistribution -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+UseConcMarkSweepGC -XX:+UseParNewGC -XX:MaxTenuringThreshold=3

    -Xmx：最大堆空间
    -Xmn 新生代大小
    -XX:PrintGCdeateStamps：打印GC的时间
    -XX:+UseConcMarkSweepGC：在老年代使用cms垃圾回收
    -XX:UseParNewGC：在新生代的辣鸡回收
    -XX:MaxTenuringThreshold=3 新生代最高的垃圾回收次数，达到之后就会进入老年代
 */
public class MyTest4 {

    public static void main(String[] args) throws InterruptedException {
        byte [] bytes1 = new byte[512 *1024];
        byte [] bytes2 = new byte[512 *1024];


        myGc();
        sleep();
        System.out.println("11111");


        myGc();
        sleep();
        System.out.println("2222222");

        myGc();
        sleep();
        System.out.println("33333333");

        myGc();
        sleep();
        System.out.println("44444444");

        byte[] byte_3 = new byte[1024*1024];
        byte[] byte_4 = new byte[1024*1024];
        byte[] byte_5 = new byte[1024*1024];

        myGc();
        sleep();

        System.out.println("555555555");

        myGc();
        sleep();

        System.out.println("6666666666");

        System.out.println("hello world");
    }

    private static void myGc(){
        for (int i = 0; i <40 ; i++) {
            byte[] bytes = new byte[1024 *1024];

        }
    }

    private static void sleep() throws InterruptedException {

        Thread.sleep(1000);
//        Thread.sleep(20000);
    }
}
