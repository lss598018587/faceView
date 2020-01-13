package com.miaomiao.excel;

import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class AppMain {
    public static void main(String[] args) {
//        Workbook workbook = StreamingReader.builder().rowCacheSize(100).bufferSize(100).open(fi);
//        EasyExcel.read(fileName, DemoData.class, new DemoDataListener()).sheet().doRead();

        List<String> list = new ArrayList<>();
        list.add("1");
        if(!CollectionUtils.isEmpty(list)){
            System.out.println("123");
        }
        byte[] a = new byte[100];

        a[0]=1;
        int [] num = new int[100];
        int [] arr = new int[100];

        System.out.println(new BigDecimal("6749.53")
                .setScale(0, BigDecimal.ROUND_HALF_UP)
                .intValue());


        TreeMap map = new TreeMap();
        map.put("6","6");
        map.put("2","2");
        map.put("1","1");
        map.put("3","3");

        SortedMap sub = map.tailMap("5");

        System.out.println(sub.firstKey());;
        System.out.println(map.firstKey());;


    }
}
