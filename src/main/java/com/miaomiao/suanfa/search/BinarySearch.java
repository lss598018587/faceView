package com.miaomiao.suanfa.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 二分查找法
 */
public class BinarySearch {

   static List<Integer> list =  new ArrayList<Integer>();

    public static void main(String[] args) {
        int arr[] = {1,8,10,89,1000,1000,1000,1234};
        int resIndex = binarySearch(arr,0,arr.length,88);
        List<Integer> resIndexs = binarySearch2(arr,0,arr.length,1000);
        System.out.println(resIndex);
        System.out.println(Arrays.toString(resIndexs.toArray()));
    }

    public static int binarySearch(int[]arr,int left,int right,int findVal){
        if (left > right) {
            System.out.println("left:"+left+",right:"+right);
            return -1;
        }
        int mid = (left+right)/2;
        int minVal = arr[mid];
        if(findVal>minVal){
            return  binarySearch(arr,mid+1,right,findVal);
        }else if(findVal<minVal){
            return  binarySearch(arr,left,mid-1,findVal);
        }else{
            return mid;
        }
    }
    public static List<Integer> binarySearch2(int[]arr, int left, int right, int findVal){
        if (left > right || findVal<arr[0] || findVal> arr[arr.length-1]) {
            System.out.println("left:"+left+",right:"+right);
            return list;
        }
        int mid = (left+right)/2;
        int minVal = arr[mid];
        if(findVal>minVal){
            return  binarySearch2(arr,mid+1,right,findVal);
        }else if(findVal<minVal){
            return  binarySearch2(arr,left,mid-1,findVal);
        }else{
            int temp = mid-1;
            while (true){
                if(temp<0 || arr[temp] != findVal){
                    break;
                }
                //否则，就temp放入到数队列里
                list.add(temp);
                temp -=1;
            }
            list.add(mid);
              temp = mid+1;
            while (true){
                if(temp>arr.length-1 || arr[temp] != findVal){
                    break;
                }
                //否则，就temp放入到list
                list.add(temp);
                temp+=1;
            }

            return list;


        }
    }

}
