package com.kinglloy.leetcode;

public class MaximumProductSubarray_152 {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] maxDp = new int[nums.length];
        int[] minDp = new int[nums.length];
        maxDp[0] = nums[0];
        minDp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxDp[i] = Math.max(minDp[i - 1] * nums[i], Math.max(nums[i], maxDp[i - 1] * nums[i]));
            minDp[i] = Math.min(minDp[i - 1] * nums[i], Math.min(nums[i], maxDp[i - 1] * nums[i]));
        }

        int max = maxDp[0];
        for (int i1 : maxDp) {
            if (i1 > max) {
                max = i1;
            }
        }
        return max;
    }
}
