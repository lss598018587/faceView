package com.miaomiao.classLoad.jvm;

import com.sun.crypto.provider.AESKeyGenerator;

/**
 *  1、先cd到 /Users/miaomiao/myProject/faceView/target/classes 这个目录
 *  2、执行这个命令：java -Djava.ext.dirs=./ com/miaomiao/jvm/MyTest19
 *
 *  把扩展目录改成 /Users/miaomiao/myProject/faceView/target/classes
 *  导致扩展目录下面的包无法被加载（extClassLoad没有可加载的类），导致下面报错
 *
 */
public class MyTest19 {
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println(System.getProperty("java.ext.dirs"));

        AESKeyGenerator aesKeyGenerator = new AESKeyGenerator();
        System.out.println(aesKeyGenerator.getClass().getClassLoader());
        System.out.println(MyTest19.class.getClassLoader());
    }
}
