package com.miaomiao;

/**
 * Hello world!
 *
 */
public class App 
{


    public static void main( String[] args )
    {
        int hour = 24;
        long mi = hour * 60 * 60 * 1000;
        System.out.println(mi);
        //int类型越界了
        long mic = hour * 60 * 60 * 1000 * 1000;
        System.out.println(mic);
        System.out.println(mic/mi);
        System.out.println( "Hello World!" );
    }
}