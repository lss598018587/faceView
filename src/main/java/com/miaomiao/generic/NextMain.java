package com.miaomiao.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: miaomiao
 * @Date: 2019-09-24 10:20
 * @Description:
 */
public class NextMain {

    public static void main(String[] args) {
        List<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(2L);

        List<Long> list2= new ArrayList<>(2);
        list2.add(3L);
        list2.add(4L);
        copy(list2,list);
        System.out.println(list2.get(0));
    }

    public static <T> void copy(List<? super T> dest, List<? extends T> src)
    {
        for (int i=0; i<src.size(); i++)
            dest.set(i,src.get(i));
    }
}
