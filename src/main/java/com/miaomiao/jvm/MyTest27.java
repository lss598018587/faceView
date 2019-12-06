package com.miaomiao.jvm;

import java.sql.Connection;
import java.sql.DriverManager;


/**
 * Reflection.getCallerClass() 方法被调用所处于的那个类
 */

public class MyTest27 {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://locahost:3306/","","");
    }
}
