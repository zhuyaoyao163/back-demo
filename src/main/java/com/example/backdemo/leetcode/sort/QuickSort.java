package com.example.backdemo.leetcode.sort;

/**
 * @description:
 * @author: superman
 * @create: 2021-05-21 16:59
 **/
public class QuickSort {

    public static void sort(int[] arrays, int low, int high) {
        if (low < high) {
            int index = getIndex(arrays, low, arrays.length - 1);
            sort(arrays, low, index - 1);
            sort(arrays, index + 1, high);
        }

    }

    public static int getIndex(int[] arrays, int low, int high) {
        int tmp = arrays[low];
        while (low < high){
            while (low < high && arrays[high] >= tmp){
                high--;
            }
            arrays[low] = arrays[high];
//            low++;
            while (low < high && arrays[low] <= tmp) {
                low++;
            }
            arrays[high] = arrays[low];
//            high--;
        }
        arrays[low] = tmp;
        return low;

    }


    public static void main(String[] args) {
        int[] arr = { 49, 38, 65, 97, 23, 22, 76, 1, 5, 8, 2, 0, -1, 22 };
        sort(arr, 0, arr.length - 1);
        System.out.println("排序后:");
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
