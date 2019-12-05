package com.miaomiao.jvm;

public class MyTest17 {
    public static void main(String[] args) throws Exception{
        MyTest16 loader1 = new MyTest16("loader1");
        loader1.setPath("/Users/miaomiao/Desktop/");
        Class<?> clazz = loader1.loadClass("com.miaomiao.jvm.MyDog");
        System.out.println("class:"+clazz.hashCode());

        Object object = clazz.newInstance();



    }
}
