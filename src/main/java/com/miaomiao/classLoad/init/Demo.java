package com.miaomiao.classLoad.init;

/**
 * @Auther: miaomiao
 * @Date: 2019-09-02 16:08
 *
 * 静态变量被调用，类会被初始化
 * 静态变量前加个 final ，类就不会被初始化
 *
 *
 */
public class Demo {
    static {
        System.out.println("我被初始化了");
    }
    public final static int m =31;

}
