package com.miaomiao.jvm;

/**
 *
 * 初始化一个类时，并不会先初始化它的接口，但会先加载它的接口
 * 在初始化一个接口，并不会先初始化它的父接口
 */
public class MyTest5 {
    public static void main(String[] args) {

        System.out.println(MyChild5.a);
        System.out.println("================");

        System.out.println(MyParent5_1.thread);

    }
}

interface MyParent5 {
   public static Thread thread = new Thread(){
       {
           System.out.println("MyParent5 invoked");
       }
   };
}
class MyChild5 implements MyParent5{
    public static int a=5;
}


interface Mygrandpa5_1{
    public static Thread thread = new Thread(){
        {
            System.out.println("Mygrandpa5_1 invoked");
        }
    };
}
interface MyParent5_1 extends Mygrandpa5_1{
    public static Thread thread = new Thread(){
        {
            System.out.println("MyParent5_1 invoked");
        }
    };
}