package com.miaomiao.jvm;

import java.sql.Driver;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * 线程上下文类加载器的一般使用模式(获取-使用-还原)
 *
 * ClassLoader classLoader Thread currentThread (). getContextclassLoader();
 *
 * try {
 *      Thread currentThread().setContextClassLoader (targetTccl):
 *      myMethod();
 *      } finally {
 *          Thread.currentThread().setContextClassLoader(classloader ):
 *      }
 *
 * myMethod里面则调用了 Thread.currentThread().getContextClassLoader(),获取当前线程的上下文类加载器做某些事情。
 *
 * 如果一个类由类加载器A加载,那么这个类的依赖类也是由相同的类加载器加载的(如果该依赖类之前没有被加载过的话)
 *
 * ContextClassLoader的作用就是为了破坏Java的类加载委托机制。
 *
 * 当高层提供了统一的接口让低层去实现,同时又要在高层加载(或实例化)低层的类时,就必须要通过线程上下文类加载器来帮助高层的classLoader
 * 找到并加载该类。
 *
 * ServiceLoader是 bootstrap加载的
 * ServiceLoader.load 去加载 应用包下面的jdbc Driver 是通过 Thread.currentThread().getContextClassLoader() 进行加载的
 */
public class MyTest26 {

    public static void main(String[] args) {
        Thread.currentThread().setContextClassLoader(MyTest26.class.getClassLoader().getParent());

        ServiceLoader<Driver> loader = ServiceLoader.load(Driver.class);
        Iterator<Driver> iterator = loader.iterator();
        while (iterator.hasNext()) {
            Driver driver = iterator.next();
            System.out.println("driver: "+driver.getClass()+", loadClass: "+driver.getClass().getClassLoader());
        }


        System.out.println("当前线程上下文类加载器："+Thread.currentThread().getContextClassLoader());

        System.out.println("serviceLoader的类加载器："+ServiceLoader.class.getClassLoader());

    }
}
