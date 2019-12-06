package com.miaomiao.classLoad.jvm;

/**
 * 调用ClassLoader类的loadClass方法加载一个类，并不是对类的主动使用，不会导致类的初始化
 * class.forName 会导致一个类进行初始化
 */
public class MyTest12 {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        Class<?> clazz = loader.loadClass("com.miaomiao.classLoad.jvm.CL");

        System.out.println(clazz);

        System.out.println("---------------");

        clazz = Class.forName("com.miaomiao.classLoad.jvm.CL");
        System.out.println(clazz);
    }
}


class CL{
    static {
        System.out.println("Class CL");
    }
}
