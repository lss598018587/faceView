package com.miaomiao.tmonitor;

import java.io.File;
import java.lang.instrument.Instrumentation;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * @Auther: miaomiao
 * @Date: 2019-09-07 16:17
 * @Description:
 */
public class MyAgent {
    public static void premain(String args, Instrumentation inst) {

        ClassLoader parentClassLoader = Thread.currentThread().getContextClassLoader();

        /**
         * 创建Core加载器
         */
        ClassLoader coreClassLoader = buildCoreClassLoader();

    }
    private static ClassLoader buildCoreClassLoader() throws MalformedURLException, URISyntaxException {
        // 设置ParentClassLoader
        ClassLoader parent = BundleClassLoader.class.getClassLoader();

        if(parent == null) {
            parent = BundleClassLoader.getSystemClassLoader();
        }

        // core相关的所有jar
        URL[] coreJars = FileJarSearch.searchJar(BootStrapContext.getInstances().getMonitorHome() + File.separator + "core");

        logger(coreJars);

        // core的独立ClassLoader
        BundleClassLoader coreLoader = new BundleClassLoader(coreJars, parent);

        // 保存classLoader的引用后面执行Facade的时候需要使用
        BootStrapContext.getInstances().setCoreClassLoader(coreLoader);

        return coreLoader;

    }
}
