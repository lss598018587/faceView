package com.miaomiao.jvm;

/**
 * 把类放到 bootstrap类加载器的地方，根目录加载器会进行加载
 * 把MyTest1 放到 /Library/Java/JavaVirtualMachines/jdk1.8.0_161.jdk/Contents/Home/jre/classes 这个目录下面 bootstrap就会进行加载了
 */
public class MyTest18 {
    public static void main(String[] args) throws ClassNotFoundException {


        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));

        MyTest16 load1 = new MyTest16("loaad1");
        Class<?> clazz = load1.loadClass("com.miaomiao.jvm.MyTest1");
        System.out.println(clazz);
        System.out.println(clazz.getClassLoader());
    }
}
