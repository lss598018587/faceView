package com.miaomiao.classLoad.bytecode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicSubject implements InvocationHandler {

    private Object object;

    public DynamicSubject(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开头。。。。。");
        method.invoke(object);
        System.out.println("结束。。。。。");
        return null;
    }
}
