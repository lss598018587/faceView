package com.miaomiao.jvm;

/**
 * 常量在编译阶段会存入到调用这个常量的方法所在的类的常量池当中，
 * 本质上，调用类并没有直接饮用到定义常量的类，因此并不会触发定义常量的类的初始化
 * 注意：这里指的是将常量存放到了MyTest2的常量池中，之后MyTest2和MyParent2就没有任何关系了
 * 甚至，我们可以将MyParent2的class文件删除
 *
 *
 * 助记符：
 * ldc标识将 int，float，或是String类型的常量值从常量池中推送至栈顶
 * bipush表示将单字节（-128 到 127）的常量值推送至栈顶
 * sipush表示一个短整型常量值(-32768 到 32767) 推送至栈顶
 * iconst_1 表示将int类型1推送至栈顶  （ iconst_m1  - iconst_5 ）
 */
public class MyTest2 {
    public static void main(String[] args) {
        System.out.println(MyParent2.m);
    }
}

class MyParent2 {
    public final static String str1 = "hello world";
    public final static short s = 127;
    public final static int i = 128;
    public final static int m = 1;
    static {
        System.out.println("MyParent2 static block");
    }
}

