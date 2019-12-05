package com.miaomiao.jvm;

import java.io.*;

public class MyTest16 extends ClassLoader{

    private String classLoadName;
    private String path;

    public void setPath(String path) {
        this.path = path;
    }

    private final String fileExtension = ".class";

    public MyTest16(String classLoadName){
        //将系统类加载器当做该类加载器的父加载器
        super();
        this.classLoadName = classLoadName;
    }

    public MyTest16(ClassLoader parent,String classLoadName){
        //显示指定该类加载器的父加载器
        super(parent);
        this.classLoadName = classLoadName;
    }

    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        System.out.println("-----className："+className);
        System.out.println("-----class load name："+this.classLoadName);
        byte[] data = this.loadClassData(className);
        return this.defineClass(className,data,0,data.length);
    }

    private byte[] loadClassData(String className){
        InputStream is = null;
        byte[] data =null;
        ByteArrayOutputStream bos =null;
        try {
            className = className.replace(".","/");
            is = new FileInputStream(new File(this.path+className+this.fileExtension));
            bos = new ByteArrayOutputStream();
            int ch =0;
            while(-1 != (ch=is.read())){
                bos.write(ch);
            }
            data = bos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                is.close();
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return data;
    }


    public static void main(String[] args) throws Exception {
        MyTest16 load1 = new MyTest16("loader1");
//        load1.setPath("/Users/miaomiao/myProject/faceView/target/classes/");
        load1.setPath("/Users/miaomiao/Desktop/");
        Class<?> clazz = load1.loadClass("com.miaomiao.jvm.MyTest1");
        System.out.println("clazz:"+clazz.hashCode());
        Object object = clazz.newInstance();
        System.out.println(object);

        System.out.println();

        MyTest16 load2 = new MyTest16("loader2");
        load2.setPath("/Users/miaomiao/Desktop/");
        Class<?> clazz2 = load2.loadClass("com.miaomiao.jvm.MyTest1");
        System.out.println("clazz2:"+clazz2.hashCode());
        Object object2 = clazz2.newInstance();
        System.out.println(object2);

        System.out.println();

        MyTest16 load3 = new MyTest16(load2,"loader3");
        load2.setPath("/Users/miaomiao/Desktop/");
        Class<?> clazz3 = load3.loadClass("com.miaomiao.jvm.MyTest1");
        System.out.println("clazz3:"+clazz3.hashCode());
        Object object3 = clazz3.newInstance();
        System.out.println(object3);


    }
}
