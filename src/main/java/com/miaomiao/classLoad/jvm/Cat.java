package com.miaomiao.classLoad.jvm;

public class Cat {
    public Cat(){
        System.out.println("cat classLoad:"+this.getClass().getClassLoader());
        System.out.println("cat classLoad parent:"+this.getClass().getClassLoader().getParent());
        System.out.println("Dog : "+Dog.class);
    }
}
