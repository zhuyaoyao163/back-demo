package com.example.backdemo.leetcode.sort;

import java.util.Arrays;

/**
 * @description:
 * @author: superman
 * @create: 2021-05-27 11:28
 **/
public class SelectSort {

    private static void sort(int[] arrs) {
        for (int i = 0; i < arrs.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arrs.length; j++) {
                if (arrs[j] < arrs[i]) {
                    min = j;
                }
            }
            if (min != i) {
                swap(arrs, min, i);
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

    public static void main(String[] args) {
        int []arr = {9,8,7,6,5,4,3,2,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
