package com.miaomiao.base;

public class Cat implements Anima {
    @Override
    public void execu(Student stu) {
        System.out.println(stu.handleResult("123"));
    }

    public static void main(String[] args) {
        Cat c = new Cat();
        Cat.Student st = new Cat.Student(){
            @Override
            public String handleResult(String c) {
                return "qwe"+c;
            }
        };
        c.execu(st);
    }
}
