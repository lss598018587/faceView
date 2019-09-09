package com.miaomiao.tmonitor;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * @Auther: miaomiao
 * @Date: 2019-09-09 19:09
 * @Description:
 */
public class BundleClassLoader extends URLClassLoader {

    private static ClassLoader system = null;

    public BundleClassLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);

        system = String.class.getClassLoader();
        if (system == null) {
            system = getSystemClassLoader();
            while (system.getParent() != null) {
                system = system.getParent();
            }
        }
    }
}
