package com.miaomiao.classLoad.jvm;

/**
 * 1.调用 Singleton.getInstance() 进入类的准备阶段
 * 1-1.Singleton counter1为 0
 * 1-2.Singleton singleton =null
 * 1-3.Singleton counter2为 0
 *
 * 2.进行初始化阶段
 * 2-1. Singleton counter1 因为没有赋值，还是0
 * 2-2  执行 singleton = new Singleton();
 * 2-3  Singleton counter2进行0的赋值
 */
public class MyTest6 {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();

        System.out.println("counter1:"+singleton.counter1);
        System.out.println("counter2:"+singleton.counter2);

    }
}

class Singleton{
    public static int counter1;

    private static Singleton singleton = new Singleton();

    private Singleton(){
        counter1++;
        counter2++;
        System.out.println(counter1);
        System.out.println(counter2);
    }
    public static int counter2=0;

    public static Singleton getInstance(){
        return singleton;
    }
}

