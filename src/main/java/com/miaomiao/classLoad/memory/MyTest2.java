package com.miaomiao.classLoad.memory;


/*
      虚拟机栈溢出
 */

public class MyTest2 {

    private int length;

    public int getLength() {
        return length;
    }

    public void test(){
        length++;
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        test();
    }

    public static void main(String[] args) {
        MyTest2 test2 = new MyTest2();
        try {
            test2.test();
        }catch (Throwable ex){
            System.out.println(test2.length);
            ex.printStackTrace();
        }
    }
}
