package com.miaomiao.jvm;

/**
 * 1.把target 里的Dog删了，用自定义加载器去加载Dog
 * 2.cat用 AppClassLoad去加载
 * 3.在Dog里面加一行  System.out.println("cat : "+Cat.class);
 * 4.然后发现，子加载器所加载的类能够访问到父加载器所加载的类
 *
 * 3.在Cat里面加一行 System.out.println("dog : "+Dog.class);
 * 4.然后发现，父加载器所加载的类无法访问到子加载器所加载的类
 */
public class MyTest0 {
    public static void main(String[] args) throws Exception {
        MyTest load1 = new MyTest("load1");
        load1.setPath("/Users/wangmiao/Desktop/");
        Class<?> clazz = load1.loadClass("com.miaomiao.jvm.Dog");
        clazz.newInstance();
    }
}
