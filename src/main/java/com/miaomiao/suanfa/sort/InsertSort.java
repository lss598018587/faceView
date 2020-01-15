package com.miaomiao.suanfa.sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int arr[] = {1,5,23,13,4};

        System.out.println("排序前》》"+Arrays.toString(arr));

        inserSort(arr);
        System.out.println("排序后》》"+Arrays.toString(arr));
    }

    public static void inserSort(int[] arr){
        for(int i=1;i<arr.length;i++){
            int insertVal = arr[i];
            int insertIndex = i-1;

            while(insertIndex>=0 && insertVal<arr[insertIndex]){
                arr[insertIndex + 1] =arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex + 1] = insertVal;

            System.out.println("第"+i+"轮插入");
            System.out.println(Arrays.toString(arr));
        }
    }
}
