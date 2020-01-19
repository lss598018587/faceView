package com.miaomiao.suanfa.sort;

import java.util.Arrays;

/**
 * 基数排序
 */
public class RadixSort {

    public static void main(String[] args) {
        int arr[] = {53,3,542,5798,748,14,214};
//        originRadixSort(arr);
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
//        System.out.println(Math.pow(10,2));
    }
    public static void radixSort(int []arr){


        //说明
        //1.二维数组包含10个一维数组
        //2.为了防止在放入数的时候,数据溢出,则每个一维数组(桶),大小定为arr, length
        //3.名明确,基数排序是使用空间换时间的经典算法
        int[][] bucket = new int[10][arr.length];

        //为了记录每个桶中,实际存放了多少个数据,我们定义一个一维数组来记录各个桶的每次放入的数据个数
        //可以这里理解
        //比如: bucketElementCounts[0],记录的就是 bucket[0]桶的放入数据个数
        int [] bucketElementCounts = new int[10];

        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>max){
                max = arr[i];
            }
        }

        int maxLength = (max+"").length();

        for (int i = 0; i <maxLength ; i++) {

            for (int j = 0; j < arr.length; j++) {
                //取出每个元素的个位的值
                int digitOfElement = arr[j] /(int)(Math.pow(10,i))% 10;
                //放到对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];

                bucketElementCounts[digitOfElement]++;
            }
            //按照这个桶的顺序（一维数组的下标依次取出数据，放到原数组）
            int index =0;
            //遍历每一个桶，并将桶中的数据，放到原数组
            for (int k = 0; k < bucketElementCounts.length; k++) {
                //如果桶中有数据才放到原数组中
                if(bucketElementCounts[k] !=0){
                    //循环该桶即第k个桶（即第k个一维数组），放入原数组
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        arr[index] = bucket[k][l];
                        index++;
                    }
                }
            }
            bucketElementCounts = new int[10];
            bucket = new int[10][arr.length];
        }

    }


    //基数排序方法
    public static void originRadixSort(int [] arr){



            //第1轮（针对每个元素的各位进行排序）

            //说明
            //1.二维数组包含10个一维数组
            //2.为了防止在放入数的时候,数据溢出,则每个一维数组(桶),大小定为arr, length
            //3.名明确,基数排序是使用空间换时间的经典算法
            int[][] bucket = new int[10][arr.length];

            //为了记录每个桶中,实际存放了多少个数据,我们定义一个一维数组来记录各个桶的每次放入的数据个数
            //可以这里理解
            //比如: bucketElementCounts[0],记录的就是 bucket[0]桶的放入数据个数
            int [] bucketElementCounts = new int[10];

            //第一轮（针对每个元素的各位进行排序处理）
            for (int j = 0; j < arr.length; j++) {
                //取出每个元素的个位的值
                int digitOfElement = arr[j] % 10;
                //放到对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];

                bucketElementCounts[digitOfElement]++;
            }

            //按照这个桶的顺序（一维数组的下标依次取出数据，放到原数组）
            int index =0;
            //遍历每一个桶，并将桶中的数据，放到原数组
            for (int k = 0; k < bucketElementCounts.length; k++) {
                //如果桶中有数据才放到原数组中
                if(bucketElementCounts[k] !=0){
                    //循环该桶即第k个桶（即第k个一维数组），放入原数组
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        arr[index] = bucket[k][l];
                        index++;
                    }
                }
            }

            //第二轮（针对每个元素的各位进行排序处理）
            bucketElementCounts = new int[10];
            bucket = new int[10][arr.length];

            for (int j = 0; j < arr.length; j++) {
                //取出每个元素的个位的值
                int digitOfElement = arr[j] /10 % 10;
                //放到对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];

                bucketElementCounts[digitOfElement]++;
            }

            //按照这个桶的顺序（一维数组的下标依次取出数据，放到原数组）
            index =0;
            //遍历每一个桶，并将桶中的数据，放到原数组
            for (int k = 0; k < bucketElementCounts.length; k++) {
                //如果桶中有数据才放到原数组中
                if(bucketElementCounts[k] !=0){
                    //循环该桶即第k个桶（即第k个一维数组），放入原数组
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        arr[index] = bucket[k][l];
                        index++;
                    }
                }
            }
            //第三轮（针对每个元素的各位进行排序处理）
            bucketElementCounts = new int[10];
            bucket = new int[10][arr.length];

            for (int j = 0; j < arr.length; j++) {
                //取出每个元素的个位的值
                int digitOfElement = arr[j] /10/10 % 10;
                //放到对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];

                bucketElementCounts[digitOfElement]++;
            }

            //按照这个桶的顺序（一维数组的下标依次取出数据，放到原数组）
            index =0;
            //遍历每一个桶，并将桶中的数据，放到原数组
            for (int k = 0; k < bucketElementCounts.length; k++) {
                //如果桶中有数据才放到原数组中
                if(bucketElementCounts[k] !=0){
                    //循环该桶即第k个桶（即第k个一维数组），放入原数组
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        arr[index] = bucket[k][l];
                        index++;
                    }
                }
            }




    }
}
