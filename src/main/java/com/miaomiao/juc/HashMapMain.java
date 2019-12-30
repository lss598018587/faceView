package com.miaomiao.juc;

import java.util.HashMap;
import java.util.Map;

public class HashMapMain {
    public static void main(String[] args) {
        MyMap<String,String> map = new MyMap<>(4);
        map.put("123","123");
        map.put("111","123");
        map.put("444","123");
        map.put("555","123");

    }
}
