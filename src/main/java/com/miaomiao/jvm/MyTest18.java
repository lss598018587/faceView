package com.miaomiao.jvm;

/**
 * 把类放到 bootstrap类加载器的地方，根目录加载器会进行加载
 * 把MyTest1 放到 /Library/Java/JavaVirtualMachines/jdk1.8.0_161.jdk/Contents/Home/jre/classes 这个目录下面 bootstrap就会进行加载了
 */
public class MyTest18 {
    public static void main(String[] args) throws ClassNotFoundException {


        /**
         * 內建于JM中的启动类加载器会加载java.1ang.Classloader以及其他的Java平台类,
         * 当JVM启动时,一块特殊的机器码会运行,它会加载扩展类加载器与系统类加载器,
         * 这块特殊的机器码叫做启动类加载器( Bootstrap)
         *
         * 启动类加载器并不是Java类,而其他的加载器则都是Java类,
         * 启动类加载器是特定于平台的机器指令,它负责开启整个加载过程。
         *
         * 所有类加载器(除了启动类加载器)都被实现为Java类。不过,总归要有一个组件来加载第一个Java类加载器,从而让整个加载过程能够顺利
         * 进行下去,加载第一个纯Java类加载器就是启动类加载器的职责
         * 启动类加载器还会负责加载供JRE正常运行所需要的基本组件,这包括java.util与java.lang包中的类等等
         */
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));

        MyTest16 load1 = new MyTest16("loaad1");
        Class<?> clazz = load1.loadClass("com.miaomiao.jvm.MyTest1");
        System.out.println(clazz);
        System.out.println(clazz.getClassLoader());
//        System.out.println(clazz.getClassLoader());
    }
}
