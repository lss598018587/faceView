package com.miaomiao.suanfa.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {

//        int arr[] = {3,9,-1,10,20};
        int arr[] = {1,2,5,6,11};
        int temp = 0;
        //标识变量，判断是否进行过交换
        boolean flag = false;
        for (int i = 0; i <arr.length -1 ; i++) {

            for (int j = 0; j < arr.length-1-i; j++) {
                if(arr[j]>arr[j+1]){
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            System.out.println("第"+(i+1)+"趟排序后的数组");
            System.out.println(Arrays.toString(arr));

            //在一趟排序中，一次交换都没有发生过，直接退出
            if(!flag){
                break;
            }

        }
    }
}
