package com.miaomiao.classLoad.gc;

/*
    1.使用Parallel的问题

    Heap
 PSYoungGen      total 9216K, used 7493K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
  eden space 8192K, 91% used [0x00000007bf600000,0x00000007bfd516b8,0x00000007bfe00000)
  from space 1024K, 0% used [0x00000007bff00000,0x00000007bff00000,0x00000007c0000000)
  to   space 1024K, 0% used [0x00000007bfe00000,0x00000007bfe00000,0x00000007bff00000)
 ParOldGen       total 10240K, used 0K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
  object space 10240K, 0% used [0x00000007bec00000,0x00000007bec00000,0x00000007bf600000)
 Metaspace       used 3316K, capacity 4496K, committed 4864K, reserved 1056768K
  class space    used 365K, capacity 388K, committed 512K, reserved 1048576K

  2.使用  PretenureSizeThreshold 当分配内存达到设定值，直接生成在老年代，前提是要用 -XX:+UseSerialGC 这个垃圾回收器
  3.新生代内存不够，直接分配到老年代


 */
public class MyTest2 {
    public static void main(String[] args) throws InterruptedException {
        int size = 1024 * 1024;
        byte[] bytes = new byte[size * 5];


        Thread.sleep(1000000);

    }
}
