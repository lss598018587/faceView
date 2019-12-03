package com.miaomiao.jvm;

/**
 * 当一个接口在初始化时，并不要求其父接口都完成了初始化
 * 只有在真正使用到父接口的时候（入引用接口中所定义的常量时），才会初始化
 */
public class MyTest5 {
    public static void main(String[] args) {

        System.out.println(MyParent5.a);

    }
}

interface MyParent5 {
   public static int a=5;
}

