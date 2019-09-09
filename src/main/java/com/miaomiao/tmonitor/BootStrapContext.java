package com.miaomiao.tmonitor;


import com.miaomiao.tmonitor.interfaces.BeanRegistry;

import java.lang.instrument.Instrumentation;

/**
 * 引导类上下文
 */
public class BootStrapContext {
    // 单例
    private static BootStrapContext instances = new BootStrapContext();
    // 核心加载器
    private ClassLoader coreClassLoader;
    // instrumentation
    private Instrumentation instrumentation;
    // agent主目录
    private String monitorHome;

    private BeanRegistry beanRegistry;

    private BootStrapContext() {}

    public static BootStrapContext getInstances() {
        return instances;
    }

    public static void setInstances(BootStrapContext instances) {
        BootStrapContext.instances = instances;
    }

    public ClassLoader getCoreClassLoader() {
        return coreClassLoader;
    }

    public void setCoreClassLoader(ClassLoader coreClassLoader) {
        this.coreClassLoader = coreClassLoader;
    }

    public Instrumentation getInstrumentation() {
        return instrumentation;
    }

    public void setInstrumentation(Instrumentation instrumentation) {
        this.instrumentation = instrumentation;
    }

    public String getMonitorHome() {
        return monitorHome;
    }

    public void setMonitorHome(String monitorHome) {
        this.monitorHome = monitorHome;
    }

    public BeanRegistry getBeanRegistry() {
        return beanRegistry;
    }

    public void setBeanRegistry(BeanRegistry beanRegistry) {
        this.beanRegistry = beanRegistry;
    }
}
