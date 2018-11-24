package com.kinglloy.leetcode;

/**
 * 1.
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * <p>
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int min = nums[0];
        int max = nums[0];
        int len = nums.length;
        int val1, j;
        int i = 0;
        for (; i < len; i++) {
            val1 = nums[i];
            if (val1 < min) {
                min = val1;
            }
        }
        i--;
        for (; ; i--) {
            val1 = nums[i];
            if (val1 + min <= target) {
                for (j = i + 1; j < len; j++) {
                    if (val1 + nums[j] == target) {
                        return new int[]{i, j};
                    }
                }
            }
        }
    }
}
