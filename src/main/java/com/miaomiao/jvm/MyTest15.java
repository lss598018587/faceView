package com.miaomiao.jvm;

public class MyTest15 {
    public static void main(String[] args) {
        String [] strings = new String[2];
        //代表String的启动类加载器
        System.out.println(strings.getClass().getClassLoader());

        MyTest15[] myTest15s = new MyTest15[2];
        //代表 加载MyTest15类的加载器
        System.out.println(myTest15s.getClass().getClassLoader());


        int [] m = new int[2];
        //如果类型为原生类型的数组，是没有类加载器
        System.out.println(m.getClass().getClassLoader());

    }
}
