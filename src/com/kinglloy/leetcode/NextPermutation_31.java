package com.kinglloy.leetcode;

import java.util.Arrays;

public class NextPermutation_31 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1};
        nextPermutation(nums);
        System.out.println(nums);
    }

    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        boolean changed = false;
        for (int i = n - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                int k = i;
                for (int j = i + 1; j < n; j++) {
                    if (nums[j] < nums[k] && nums[j] > nums[i - 1]) {
                        k = j;
                    }
                }
                int tmp = nums[k];
                nums[k] = nums[i - 1];
                nums[i - 1] = tmp;
                Arrays.sort(nums, i, n);
                changed = true;
                break;
            }
        }
        if (!changed) {
            for (int i = 0; i < n / 2; i++) {
                int tmp = nums[i];
                nums[i] = nums[n - i - 1];
                nums[n - i - 1] = tmp;
            }
        }
    }
}
