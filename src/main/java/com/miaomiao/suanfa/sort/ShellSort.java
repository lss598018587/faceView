package com.miaomiao.suanfa.sort;

import java.util.Arrays;

/**
 * 希尔排序
 */
public class ShellSort {

    public static void main(String[] args) {
        int arr[] ={8,9,1,7,2,3,5,4,6,0};
//        originShellSort(arr);
//        shellSort(arr);
        sheellSortMove(arr);
    }

    //移位
    public static void shellSort(int [] arr){
        int temp = 0;
        int count =0;
        for(int gap = arr.length/2;gap>0;gap = gap/2){
            for (int i = gap; i < arr.length ; i++) {
                for (int j = i-gap; j >=0 ; j-=gap) {
                    if(arr[j] > arr[j + gap]){
                        temp = arr[j];
                        arr[j] = arr[j+gap];
                        arr[j+gap] = temp;
                    }
                }
            }

            System.out.println("希尔排序"+(++count)+"轮排序="+ Arrays.toString(arr));
        }
    }

    //交换
    public static void sheellSortMove(int [] arr){
        int count =0;
        for(int gap = arr.length/2;gap>0;gap = gap/2){
            //从第gap个元素，逐个对其所在的组进行直接插入排序
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if(arr[j] < arr [j-gap]){
                    while (j - gap >=0 && temp < arr[j-gap]){
                        //移动
                        arr[j] = arr[j-gap];
                        j-=gap;
                    }
                    //当退出while后，就给temp找到插入的位置
                    arr[j] = temp;
                }
            }
            System.out.println("希尔排序"+(++count)+"轮排序="+ Arrays.toString(arr));
        }
    }


    public static void originShellSort(int [] arr){

        int temp = 0;

        //希尔排序的第1轮排序
        //因为第1轮排序，是将10个数据分成了 10/2 = 5组
        for (int i = 5; i < arr.length ; i++) {
            //遍历各组中所有的元素（共5组，每组2个元素），步长5
            for (int j = i-5; j >=0 ; j-=5) {
                //如果当前元素大于加上步长后的那个元素，那就需要交换
                if(arr[j] > arr[j + 5]){
                    temp = arr[j];
                    arr[j] = arr[j+5];
                    arr[j+5] = temp;
                }
            }
        }

        System.out.println("希尔排序1轮排序="+ Arrays.toString(arr));

        //希尔排序的第2轮排序
        //因为第2轮排序，是将10个数据分成了 5/2 = 2组
        for (int i = 2; i < arr.length ; i++) {
            //遍历各组中所有的元素（共5组，每组2个元素），步长5
            for (int j = i-2; j >=0 ; j-=2) {
                //如果当前元素大于加上步长后的那个元素，那就需要交换
                if(arr[j] > arr[j + 2]){
                    temp = arr[j];
                    arr[j] = arr[j+2];
                    arr[j+2] = temp;
                }
            }
        }

        System.out.println("希尔排序2轮排序="+ Arrays.toString(arr));


        //希尔排序的第3轮排序
        //因为第3轮排序，是将10个数据分成了 2/2 = 1组
        for (int i = 1; i < arr.length ; i++) {
            //遍历各组中所有的元素（共5组，每组2个元素），步长5
            for (int j = i-1; j >=0 ; j-=1) {
                //如果当前元素大于加上步长后的那个元素，那就需要交换
                if(arr[j] > arr[j + 1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        System.out.println("希尔排序3轮排序="+ Arrays.toString(arr));


    }
}
