package com.miaomiao.classLoad.memory;

public class MyTest3 {
    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                B.method();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                A.method();
            }
        }).start();
    }
}

class A{
    public static synchronized void method(){
        System.out.println("method from A");
        try {
            Thread.sleep(5000);
            System.out.println("xixi");
            B.method();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class B{
    public static synchronized void method(){
        System.out.println("method from     B");
        try {
            Thread.sleep(5000);
            A.method();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}