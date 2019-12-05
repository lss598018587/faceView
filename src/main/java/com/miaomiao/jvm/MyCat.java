package com.miaomiao.jvm;

public class MyCat {
    public MyCat(){
        System.out.println("myCat is loaded By:"+this.getClass().getClassLoader());
    }
}
