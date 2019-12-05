package com.miaomiao.jvm;

/**
 * 1、a的准备阶段为0
 * 2、a的初始化为1
 * 3、然后执行 static a=2
 * 4、然后执行 static a=4
 *
 * static{} 算初始化语句
 * 类中存在初始化语句，那就依次执行这些初始化语句。
 */
public class MySample {
    public static void main(String[] args) {
        System.out.println("a="+Sample.a);
    }
}

class Sample{
    static int a =1;
    static {
        a=2;
    }
    static {
        a=4;
    }
}
