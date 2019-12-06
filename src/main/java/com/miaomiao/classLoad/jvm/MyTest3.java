package com.miaomiao.classLoad.jvm;

import java.util.UUID;

/**
 * 当一个常量的值并非编译期间可以确定的，那么其值就不会被放到调用类的常量池中
 * 这时在程序运行时，会导致主动使用这个常量池所在类，显然会导致这个类被初始化
 */
public class MyTest3 {
    public static void main(String[] args) {
        System.out.println(MyParent3.str1);
    }
}

class MyParent3 {
    public final static String str1 = UUID.randomUUID().toString();
    static {
        System.out.println("MyParent3 static block");
    }
}

