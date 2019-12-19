package com.miaomiao.classLoad.gc;

/*
        -Xmx20M -Xms20M -Xmn10M -XX:+PrintGCDetails -XX:+UseConcMarkSweepGC -XX:SurvivorRatio=8

        cms 垃圾收集器
 */
public class MyTest5 {

    public static void main(String[] args) {
        //1M
        int size = 1024 * 1024;

        byte[] bytes1 = new byte[4 * size];
        System.out.println("111111");
        byte[] bytes2 = new byte[4 * size];
        System.out.println("22222");
        byte[] bytes3 = new byte[4 * size];
        System.out.println("333333");
        byte[] bytes4 = new byte[2 * size];
        System.out.println("xixi");
    }

}
