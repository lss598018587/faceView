package com.miaomiao.classLoad.staticFuc;

/**
 * @Auther: miaomiao
 * @Date: 2019-09-03 16:02
 * @Description:
 */
public class Demo2 {
//    public void SayHello(int a){
//        System.out.println("int");
//    }
    public void SayHello(short a){
        System.out.println("int");
    }
//    public void SayHello(char a){
//        System.out.println("char");
//    }
    public void SayHello(Object a){
        System.out.println("Object");
    }
    public void SayHello(long a){
        System.out.println("long");
    }
    public void SayHello(Character a){
        System.out.println("Character");
    }
    public void SayHello(char... a){
        System.out.println("char...");
    }

    public static void main(String[] args) {
        new Demo2().SayHello('a');
    }
}
