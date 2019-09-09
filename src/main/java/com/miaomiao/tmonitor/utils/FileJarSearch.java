package com.miaomiao.tmonitor.utils;

import java.io.File;
import java.io.FilenameFilter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class FileJarSearch {

    public static URL[] searchJar(String directory) throws MalformedURLException {

        File homeDir = new File(directory);

        if (homeDir == null || !homeDir.exists()){
            return null;
        }

        File[] jarsfile = homeDir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File file, String s) {
                if (s.endsWith(".jar")){
                    return true;
                }
                return false;
            }
        });

        Set<URL> jars = new HashSet<URL>();
        for (File jarFile : jarsfile){
            jars.add(jarFile.toURI().toURL());
        }

        URL[] jarArray = new URL[jars.size()];
        jars.toArray(jarArray);

        return jarArray;
    }

}
