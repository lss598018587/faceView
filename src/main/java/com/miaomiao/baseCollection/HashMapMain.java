package com.miaomiao.baseCollection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class HashMapMain {
    static final int MAXIMUM_CAPACITY = 1 << 30;
    public static void main(String[] args) {
        Map<String,String> map = new HashMap();
        map.put("Str","123");
        System.out.println(tableSizeFor(3));
        System.out.println(tableSizeFor(19));
        System.out.println(tableSizeFor(45));
        Hashtable<String,String> map2 = new Hashtable<>();
        map2.put("12","123");

        ArrayList list = new ArrayList(2);
        list.add(1);
    }
    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
