package com.miaomiao.classLoad.gc;

/*
[GC (Allocation Failure) [PSYoungGen: 6305K->624K(9216K)] 6305K->4728K(19456K), 0.0037107 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
Heap
 PSYoungGen（Parallel Scavenge 新生代垃圾收集器）      total 9216K, used 2993K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
  eden space 8192K, 28% used [0x00000007bf600000,0x00000007bf8506a0,0x00000007bfe00000)
  from space 1024K, 60% used [0x00000007bfe00000,0x00000007bfe9c010,0x00000007bff00000)
  to   space 1024K, 0% used [0x00000007bff00000,0x00000007bff00000,0x00000007c0000000)
 ParOldGen（Paraller Old 老年代垃圾收集器）       total 10240K, used 4104K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
  object space 10240K, 40% used [0x00000007bec00000,0x00000007bf002020,0x00000007bf600000)
 Metaspace       used 3305K, capacity 4496K, committed 4864K, reserved 1056768K
  class space    used 363K, capacity 388K, committed 512K, reserved 1048576K


[GC (Allocation Failure) [PSYoungGen: 6305K->624K(9216K)] 6305K->4728K(19456K), 0.0037107 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]


6305K（垃圾回收前的内存）
624K（回收之后的内存）
9216K（总共的新生代内存） eden+( from or to) 设置是10M，现在是9M，有1M要留给——to

6305K（执行这次gc之前，总的堆的大小）
4728K（执行完此次gc之后，总的存活堆空间的大小）
19456K（总的堆的可用容量） 设置是20M，现在是19M，有1M要留给——to

 0.0037107 secs 垃圾回收所用的时间

这次垃圾回收
 user=0.00 用户空间所用的时间
 sys=0.00 内核空间所用的时间
 real=0.00 实际用的时间

6305K-624K = 5681k 新生代释放的内存（可能直接就回收了，可能进入到老年代）
6305K-4728K = 1577k 整个堆回收的内存

5681k - 1577k =4104k （老年代现在占用的内存）

SurvivorRatio 新生代的比值

新生代无法分配内存，直接在老年代分配内存
 */
public class MyTest1 {
    public static void main(String[] args) {
        //1M
        int size = 1024 * 1024;

        byte[] bytes1 = new byte[2 * size];
        byte[] bytes2 = new byte[2 * size];
        byte[] bytes3 = new byte[2 * size];
//        byte[] bytes4 = new byte[2 * size];
        System.out.println("xixi");
    }
}
