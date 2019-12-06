package com.miaomiao.classLoad.jvm;

public class Dog {
    public Dog(){
        System.out.println("cat classLoad:"+this.getClass().getClassLoader());
        new Cat();
        System.out.println("cat : "+Cat.class);
    }
}
