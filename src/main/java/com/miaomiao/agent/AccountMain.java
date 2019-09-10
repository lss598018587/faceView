package com.miaomiao.agent;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

/**
 * @Auther: miaomiao
 * @Date: 2019-09-07 16:29
 * @Description:
 */
public class AccountMain {
    public static void main(String[] args)
            throws ClassNotFoundException, InterruptedException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        while (true) {
            ClassLoader loader = new ClassLoader() {
                @Override
                public Class<?> loadClass(String name) throws ClassNotFoundException {
                    try {
                        String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";

                        InputStream is = getClass().getResourceAsStream(fileName);
                        if (is == null) {
                            return super.loadClass(name);
                        }

                        byte[] b = new byte[is.available()];

                        is.read(b);
                        return defineClass(name, b, 0, b.length);

                    } catch (IOException e) {
                        e.printStackTrace();
                        throw new ClassNotFoundException(name);
                    }
                }
            };
            System.out.println(loader);
            Class clazz = loader.loadClass("com.miaomiao.agent.Account");
            Object account = clazz.newInstance();
            account.getClass().getMethod("operation", new Class[]{}).invoke(account);
            Thread.sleep(20000);
        }
    }

}
