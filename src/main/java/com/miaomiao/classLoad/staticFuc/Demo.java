package com.miaomiao.classLoad.staticFuc;

/**
 * @Auther: miaomiao
 * @Date: 2019-09-03 15:54
 *
 * 静态分派
 *
 */
public class Demo {
    static class Parent{

    }
    static class Child1 extends Parent{}
    static class Child2 extends Parent{}

    public void sayHello(Child1 c){
        System.out.println("c1 is call");
    }
    public void sayHello(Child2 c){
        System.out.println("c2 is call");
    }
    public void sayHello(Parent c){
        System.out.println("p is call");
    }

    public static void main(String[] args) {

        Parent p1 = new Child1();
        Parent p2 = new Child2();
        Demo d = new Demo();
        d.sayHello(p1);
        d.sayHello(p2);

        //实际类型发生改版,静态类型未发生变化
        Parent p = new Child1();
        p = new Child2();

        //静态类型发生变化
        d.sayHello((Child2)p);
    }
}
