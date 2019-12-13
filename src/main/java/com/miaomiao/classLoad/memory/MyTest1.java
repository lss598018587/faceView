package com.miaomiao.classLoad.memory;


/**
 *
 * 虚拟机栈: Stack Frame栈帧
 * 程序计数器( Program Counter):
 * 本地方法栈:主要用于处理本地方法
 * 堆(Heap):JVM管理的最大一块内存空间,与堆相关的一个重要概念是垃圾收集器。现在几乎所有的垃圾收集器都是采用的分代收集算法,
 * 方法区( Method Area):存储元信息。永久代( Permanent Generation),从JDK 1.8开始,已经彻底废弃了永久代,使用元空间
 * (meta space)
 * 运行时常量池:方法区的一部分内容。
 * 直接内存: Direct Memory，与 java NIO密切相关，JVM通过堆上的DirectBuffer来操作直接内存。
 *
 */

public class MyTest1 {
}
