package com.miaomiao.generic;

/**
 * @Auther: miaomiao
 * @Date: 2019-09-24 09:52
 * @Description: 泛型学习
 */
public class GenMain {
    public static void main(String[] args) {
        Plate<? extends Fruits> p=new Plate<Apple>(new Apple());

        /**
         * 都会报错
         *  p.setItem(new Fruits()); //error
         *  p.setItem(new Apple()); //error
         */
        Fruits f = p.getItem();
        /**
         * 会报错
         * Apple a = p.getItem();
         */
        Object newFruit2 =p.getItem();
        Apple a = (Apple)p.getItem();


        Plate<? super Fruits> p2=new Plate<Fruits>(new Fruits());
        p2.setItem(new Fruits());
        p2.setItem(new Apple());

        /**
         *  读出来的东西只能放到Object里
         *  Apple a1 = p2.getItem(); //error
         *  Fruits a2 = p2.getItem(); //error
         */
        Object a3 = p2.getItem();
    }
}
