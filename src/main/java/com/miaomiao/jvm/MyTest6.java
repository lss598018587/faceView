package com.miaomiao.jvm;

/**
 * 当一个接口在初始化时，并不要求其父接口都完成了初始化
 * 只有在真正使用到父接口的时候（入引用接口中所定义的常量时），才会初始化
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

