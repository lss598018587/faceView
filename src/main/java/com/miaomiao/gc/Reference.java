package com.miaomiao.gc;


import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class Reference {
    public static void main(String[] args) {
        soft();
        System.out.println();
        weak();
        System.out.println();
        phantom();
    }
    private static void soft(){
        SoftReference soft = new SoftReference("soft");
        System.out.println("soft="+soft.get());
        System.out.println("------gc------");
        System.gc();
        System.out.println("soft="+soft.get());
    }
    private static void weak(){
//        WeakReference weak = new WeakReference(new String("weak"));
        WeakReference weak = new WeakReference("weak");
        System.out.println("weak="+weak.get());
        System.out.println("------gc------");
        System.gc();
        System.out.println("weak="+weak.get());
    }
    private static void phantom(){
        String value = "phontom";
        PhantomReference<String> phantom = new PhantomReference<>(value,new ReferenceQueue<String>());
        System.out.println("phantom="+phantom.get());
    }
}
