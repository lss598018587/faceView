package com.miaomiao.invokeM;

import java.lang.reflect.Field;

/**
 * 循环依赖的的解决
 * A--->持有B
 * B--->持有A
 * 1.A实例化，发现A中B的属性还未实例化，
 * 2.B实例化，发现B中的A还未实例化，A就先初始化赋值到B中，A里的B先置为null
 * 3.通过反射，实现了所有值的赋值
 */
public class AppInvoke {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        //1,需要依赖mouse，去初始化mouse
        Teacher t = new Teacher();
        //2，需要依赖teacher，去初始化teacher
        Mouse m = new Mouse();
        //3，需要依赖mouse，去缓存里拿出第二步里的mouse
        Teacher t2 = new Teacher();


        Field field = t2.getClass().getDeclaredField("mouse");
        field.setAccessible(true);
        field.set(t2, m);


        Field field2 = m.getClass().getDeclaredField("teacher");
        field2.setAccessible(true);
        field2.set(m, t2);

        Field field3 = t.getClass().getDeclaredField("mouse");
        field3.setAccessible(true);
        field3.set(t, m);

        System.out.println("22221111");
    }
}
