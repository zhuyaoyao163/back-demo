package com.example.backdemo.leetcode.algorithm_1;

import com.google.common.collect.Maps;

import java.util.Arrays;
import java.util.Map;

/**
 * @description: 两数之和
 * eg:给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * @author: superman
 * @create: 2020-06-28 17:14
 **/
public class Solution {

    /**
     * 两次循环
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = Maps.newHashMap();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            if (map.containsKey(target - m.getKey())) {
                return new int[]{m.getValue(),map.get(target-m.getKey())};
            }
        }
        throw new IllegalArgumentException("no two sum solution!");
    }

    /**
     * 一次循环
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target){
        Map<Integer, Integer> map = Maps.newHashMap();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
        }
        throw new IllegalArgumentException("no two sum solution!");
    }

    /**
     * 暴力破解法
     * 时间复杂度 O(n*n)
     * 空间复杂度 O(1)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum3(int[] nums, int target){
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(nums[j] == target - nums[i])
                    return new int[]{i, j};
            }
        }
        throw new IllegalArgumentException("no two sum solution!");
    }
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
//        int[] ints = twoSum(nums, 9);
//        int[] ints = twoSum2(nums, 9);
        int[] ints = twoSum3(nums, 9);
        Arrays.stream(ints).forEach(System.out::println);
    }
}
