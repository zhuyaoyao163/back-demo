package com.example.backdemo.leetcode.sort;

import java.util.Arrays;

/**
 * @description:
 * @author: superman
 * @create: 2021-05-27 11:38
 **/
public class BubbleSort {

    private static void sort(int[] arrs) {
        for (int i = 0; i < arrs.length-1; i++) {
            for (int j = 0; j < arrs.length-1-i; j++) {
                if (arrs[j] > arrs[j+1]){
                    swap(arrs, j, j + 1);
                }
            }
        }
    }
    /**
     * 交换数组元素
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int []arr,int a,int b){
        arr[a] = arr[a]+arr[b];
        arr[b] = arr[a]-arr[b];
        arr[a] = arr[a]-arr[b];
    }

    public static void main(String []args){
        int []arr = {9,8,7,6,5,4,3,2,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
