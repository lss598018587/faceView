package com.miaomiao.classLoad.bytecode;

public class MiaoMiaoTest {
    private String name="111";

    private int miaomiao=2;

    public MiaoMiaoTest(){
        miaomiao=5;
    }

    public MiaoMiaoTest(int m){
        System.out.println("123");
    }

    public void call(){
        System.out.println("123");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
