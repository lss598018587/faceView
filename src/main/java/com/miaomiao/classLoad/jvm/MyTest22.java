package com.miaomiao.classLoad.jvm;


/**
 * 1、cd 到 /Users/miaomiao/myProject/faceView/target/classes 这个目录
 * 2、执行这个命令：java -Djava.ext.dirs=./ com/miaomiao/jvm/MyTest22
 * 发现加载当前的类还是 appclassLoad，不是扩展类加载器加载
 *
 * 结论，扩展类加载器加载 类，需要把类打成jar包
 * 这里尝试着先把MyTest1打成jar包
 *
 * jar cvf test.jar com/miaomiao/jvm/MyTest1.class
 * 然后再执行 java -Djava.ext.dirs=./ com/miaomiao/jvm/MyTest22，发现MyTest1是 ExtClassLoader加载的
 *
 */
public class MyTest22 {

    static {
        System.out.println("MyTest22");
    }

    public static void main(String[] args) {
        System.out.println(MyTest22.class.getClassLoader());
        System.out.println(MyTest1.class.getClassLoader());
    }
}
