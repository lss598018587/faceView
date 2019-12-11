package com.miaomiao.classLoad.bytecode;

import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        RealSubject realSubject = new RealSubject();
        DynamicSubject subject = new DynamicSubject(realSubject);
        Subject sub = (Subject) Proxy.newProxyInstance(RealSubject.class.getClassLoader(),RealSubject.class.getInterfaces(),subject);
        sub.request();
    }
}
