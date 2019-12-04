package com.miaomiao.jvm;

import java.io.*;

public class MyTest extends ClassLoader {
    private String classLoadName;
    private String fileExtension = ".class";

    private String path;

    public void setPath(String path) {
        this.path = path;
    }

    public MyTest(String classLoadName) {
        super();
        this.classLoadName = classLoadName;
    }

    public MyTest(ClassLoader parent, String classLoadName) {
        super(parent);
        this.classLoadName = classLoadName;
    }

    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        System.out.println("className : "+className);
        System.out.println("class load Name : "+this.classLoadName);
        byte[] data = this.loadClassData(className);
        return this.defineClass(className, data, 0, data.length);
    }

    private byte[] loadClassData(String className) {
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream bos = null;
        try {
            className = className.replace(".", "/");
            is = new FileInputStream(new File(this.path + className + this.fileExtension));
            bos = new ByteArrayOutputStream();
            int ch;
            while (-1 != (ch = is.read())) {
                bos.write(ch);
            }
            data = bos.toByteArray();
        } catch (Exception e) {
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


}
