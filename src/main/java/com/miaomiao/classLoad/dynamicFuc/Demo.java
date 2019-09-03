package com.miaomiao.classLoad.dynamicFuc;

/**
 * @Auther: miaomiao
 * @Date: 2019-09-03 16:27
 *
 * 动态分派
 */
public class Demo {
    static class Parent{
        public void sayHello(){
            System.out.println("parent");
        }
    }

    static class Child1 extends  Parent{
        @Override
        public void sayHello() {
            System.out.println("Chaild1");
        }
    }

    static class Child2 extends  Parent{
        @Override
        public void sayHello() {
            System.out.println("Chaild2");
        }
    }

    public static void main(String[] args) {
        Parent p1 = new Child1();
        Parent p2 = new Child2();
        p1.sayHello();
        p2.sayHello();
    }
}
