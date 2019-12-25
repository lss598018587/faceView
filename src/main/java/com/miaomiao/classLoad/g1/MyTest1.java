package com.miaomiao.classLoad.g1;

/**
 * -Xms10m -Xmx10m -XX:+UseG1GC -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:MaxGCPauseMillis=200m
 *
 * [GC Worker Start (ms): Min: 388.2, Avg: 388.3, Max: 388.3, Diff: 0.1]
 *       [Ext Root Scanning (ms): Min: 0.4, Avg: 0.6, Max: 1.2, Diff: 0.8, Sum: 2.4]
 *       [Update RS (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.0]
 *          [Processed Buffers: Min: 0, Avg: 0.0, Max: 0, Diff: 0, Sum: 0]
 *       [Scan RS (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.0]
 *       [Code Root Scanning (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.0]
 *       [Object Copy (ms): Min: 0.0, Avg: 0.5, Max: 0.7, Diff: 0.7, Sum: 2.2]
 *       [Termination (ms): Min: 0.0, Avg: 0.0, Max: 0.1, Diff: 0.1, Sum: 0.1]
 *          [Termination Attempts: Min: 1, Avg: 1.2, Max: 2, Diff: 1, Sum: 5]
 *       [GC Worker Other (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.0]
 *       [GC Worker Total (ms): Min: 1.1, Avg: 1.2, Max: 1.2, Diff: 0.1, Sum: 4.7]
 *       [GC Worker End (ms): Min: 389.4, Avg: 389.5, Max: 389.5, Diff: 0.0]
 *
 *  1、根扫码（Ext Root Scanning）
 *      1-1、静态和本地对象被扫描
 *  2、更新RS（Update RS）
 *      2-1、处理dirty card队列更新RS
 *  3、处理RS （Processed Buffers）
 *      3-1、检测从年轻代指向老年代的对象
 *  4、对象拷贝  （Object Copy）
 *      4-1、拷贝存活的对象到survivor/old区域
 *  5、处理引用队列（Termination）
 *      5-1、软引用，弱引用，虚引用处理
 *
 *
 */

public class MyTest1 {
    public static void main(String[] args) {
        int size = 1024 * 1024;
        byte [] b1 = new byte[ size];
        byte [] b2 = new byte[ size];
        byte [] b3 = new byte[ size];
        byte [] b4 = new byte[size];

        System.out.println("hello miaomiao");
    }
}
