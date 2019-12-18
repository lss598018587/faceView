package com.miaomiao.classLoad.jvm;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/*
        当一个类或者一个资源文件存在多个jar中，就会存在jar hell问题
        可以通过以下方式进行诊断
 */
public class JavaHell {

    public static void main(String[] args) throws IOException {
        ClassLoader classLoader =Thread.currentThread().getContextClassLoader();
        String resourName = "java/lang/String.class";

        Enumeration<URL> urls = classLoader.getResources(resourName);
        while(urls.hasMoreElements()){
            URL url = urls.nextElement();
            System.out.println(url);
        }
    }

}
