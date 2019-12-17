package com.miaomiao.classLoad.memory;

/*

    jcmd 55433 VM.flags  ----->   jcmd pid VM.flags
    查看JVM的启动参数，将会获得以下的线程信息
    -XX:CICompilerCount=3 -XX:InitialHeapSize=134217728 -XX:MaxHeapSize=2147483648 -XX:MaxMetaspaceSize=524288000 -XX:MaxNewSize=715653120 -XX:MinHeapDeltaBytes=524288 -XX:NewSize=44564480 -XX:OldSize=89653248 -XX:+UseCompressedClassPointers -XX:+UseCompressedOops -XX:+UseFastUnorderedTimeStamps -XX:+UseParallelGC

    jcmd pid help：列出当前运行的java进程可以执行的操作
    jcmd pid PerfCounter.print：查看JVM性能相关的参数
    jcmd pid VM.uptime 启动时间有多久了
    jcmd pid GC.class_histogram 查看系统中类的统计信息
    jcmd pid Thread.print：查看线程堆栈信息

    jcmd pid GC.heap_dump filename    -----> 导出dump到指定的目录地方,导出的文件可以通过jvisualvm查看
    例子：jcmd 61830 GC.heap_dump /Users/miaomiao/Downloads/hello.hprof

    jcmd pid VM.system_properties：查看JVM的属性信息
    jcmd pid VM.version：查看目标JVM进程的版本信息
    jcmd pid VM.command_line:查看JVM启动的命令参数信息

    jstack：可以查看或是导出Java应用程序中线程的堆栈信息

    jmc

 */
public class MyTest5 {
    public static void main(String[] args) {
        for (;;){
            System.out.println("帅淼");
        }
    }
}
