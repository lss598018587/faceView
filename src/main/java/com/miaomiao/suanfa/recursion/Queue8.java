package com.miaomiao.suanfa.recursion;

import java.util.Arrays;

public class Queue8 {

    //代表有多少个皇后
    int max = 8;

    //每一行所放的皇后
    public static int nomals[] = new int[8];

    private static int nums = 0;

    public static void main(String[] args) {

        for (int i = 1; i <= 8; i++) {
            nomals[0] = i;
            digui( 1);
        }
        System.out.println("一共有这么多种方案："+nums);
    }

    /**
     * @param row  代表要填充的行
     * @return
     */
    public static void digui( int row) {

        if (row == 7 ) {
            for (int j = 1; j <= 8; j++) {
                if(judge(row,j)){
                    nums++;
                    nomals[row]=j;
                    System.out.println(Arrays.toString(nomals));
                }
            }
        } else {
            //j代表列
            for (int j = 1; j <= 8; j++) {
                if(judge(row,j)){
                    nomals[row]=j;
                    digui(row+1);
                }
            }
        }
    }

    /**
     * @param row    代表即将要填充的行
     * @param column 代表即将要填充的列
     * @return
     */
    public static boolean judge(int row, int column) {
        for (int i = 0; i < row; i++) {
            //i代表每一行，num代表那一行的第几列，已经填充了
            int num = nomals[i];
            //列与列相等，说明此位置有问题
            if (num == column) {
                return false;
            }
            //是否在同一斜线
            /**
             * 列如：第一个元素是0，0  那么2,2 或 3,3肯定在同一斜线上
             * 列如：第一个元素是 0,1 那么 2,3 或 3,4肯定在同一斜线上
             */
           if( Math.abs(row-i) == Math.abs( nomals[i]-column) ){
               return false;
           }
        }
        return true;
    }

}
