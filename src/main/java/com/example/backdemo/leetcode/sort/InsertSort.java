package com.example.backdemo.leetcode.sort;

/**
 * @description:
 * @author: superman
 * @create: 2021-05-21 16:59
 **/
public class InsertSort {

    public static void sort(int[] arrays) {
        for (int i = 1; i < arrays.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arrays[i] < arrays[j]){
                    int tmp = arrays[j];
                    arrays[j] = arrays[i];
                    arrays[i] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,4,0,-1};
        sort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
