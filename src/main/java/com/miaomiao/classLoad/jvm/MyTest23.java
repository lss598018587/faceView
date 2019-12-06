package com.miaomiao.classLoad.jvm;


import sun.misc.Launcher;

public class MyTest23 {


    public static void main(String[] args) {

        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));

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

        //ClassLoader就是由 Bootstrap加载的
        System.out.println(ClassLoader.class.getClassLoader());


        //Launcher是由 Bootstrap加载的，那么他里面的静态内部类 AppClassLoader、ExtClassLoader都是由Bootstrap加载的
        System.out.println(Launcher.class.getClassLoader());

        System.out.println("----------------");

        System.out.println(ClassLoader.getSystemClassLoader());

        System.out.println(MyTest23.class.getClassLoader());

        System.out.println(System.getProperty("java.system.class.loader"));
    }
}
