package com.miaomiao.classLoad.gc;

public class MyTest4 {

    public static void main(String[] args) throws InterruptedException {
        byte [] bytes1 = new byte[512 *1024];
        byte [] bytes2 = new byte[512 *1024];


        myGc();
        Thread.sleep(1000);
        System.out.println("11111");


        myGc();
        Thread.sleep(1000);
        System.out.println("2222222");

        myGc();
        Thread.sleep(1000);
        System.out.println("33333333");

        myGc();
        Thread.sleep(1000);
        System.out.println("44444444");
    }

    private static void myGc(){
        for (int i = 0; i <40 ; i++) {
            byte[] bytes = new byte[1024 *1024];

        }
    }

}
