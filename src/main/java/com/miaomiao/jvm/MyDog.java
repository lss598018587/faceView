package com.miaomiao.jvm;

public class MyDog {
    public MyDog(){
        System.out.println("MyDog is loaded By:"+this.getClass().getClassLoader());
        new MyCat();
    }
}
