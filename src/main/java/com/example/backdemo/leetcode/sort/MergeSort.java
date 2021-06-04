package com.example.backdemo.leetcode.sort;

import java.util.Arrays;

/**
 * @description:
 * @author: superman
 * @create: 2021-05-21 16:59
 **/
public class MergeSort {

    private static void sort(int[] arrs){
        sort(arrs, 0, arrs.length - 1, new int[arrs.length]);
    }
    private static void sort(int[] arrs, int left, int right, int[] tmp) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(arrs, left, mid, tmp);
            sort(arrs, mid + 1, right, tmp);
            merge(arrs, left, mid, right, tmp);
        }

    }
    private static void merge(int[] arrs, int left, int mid, int right, int[] tmp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if (arrs[i] < arrs[j]) {
                tmp[t++] = arrs[i++];
            } else {
                tmp[t++] = arrs[j++];
            }
        }
        while (i <= mid) {
            tmp[t++] = arrs[i++];
        }
        while (j <= mid) {
            tmp[t++] = arrs[j++];
        }
        t = 0;
        while (left <= right) {
            arrs[left++] = tmp[t++];
        }
    }
    public static void main(String []args){
        int []arr = {9,8,7,6,5,4,3,2,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
