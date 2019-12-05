package com.miaomiao.jvm;

import com.sun.crypto.provider.AESKeyGenerator;

import java.lang.reflect.Method;

/**
 *
 * 1、把target里的 MyPerson删了
 * 2、让自定义加载器加载 MyPerson
 * 3、两个自定义加载器加载的MyPerson，互相不能访问
 */
public class MyTest20 {
    public static void main(String[] args) throws  Exception {
        MyTest16 load1 = new MyTest16("l1");
        MyTest16 load2 = new MyTest16("l2");
        load1.setPath("/Users/miaomiao/Desktop/");
        load2.setPath("/Users/miaomiao/Desktop/");

        Class<?> clazz1 = load1.loadClass("com.miaomiao.jvm.MyPerson");
        Class<?> clazz2 = load2.loadClass("com.miaomiao.jvm.MyPerson");

        System.out.println(clazz1==clazz2);

        Object obj1 = clazz1.newInstance();
        Object obj2 = clazz2.newInstance();

        Method method = clazz1.getMethod("setMyPerson",Object.class);
        //第一个参数代表，是在哪个对象上执行这个method方法，第二个参数代表这个method里需要的参数
        method.invoke(obj1,obj2);
    }
}
