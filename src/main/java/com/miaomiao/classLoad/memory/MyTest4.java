package com.miaomiao.classLoad.memory;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/*
    方法区产生内存溢出

 */
public class MyTest4 {
    public static void main(String[] args) {
        for (;;){
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(MyTest4.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new Proxy());

            System.out.println("hello world");

            enhancer.create();
        }
    }


}


class Proxy implements MethodInterceptor {

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        Object result = null;
        try {
            //前置通知
            System.out.println("前置通知");
            result = proxy.invokeSuper(obj, args);
            //后置通知
            System.out.println("后置通知");
        } catch (Exception e) {
            //异常通知
            exception();
        } finally {
            //方法返回前通知
            beforeReturning();
        }

        return result;
    }
    private void exception() {
        System.out.println("exception method invoke...");
    }
    private void beforeReturning() {
        System.out.println("beforeReturning method invoke...");
    }
}
