package com.kinglloy.leetcode;

public class _MaximumSubarray_53 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int tmp = nums[0], result = nums[0];
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (tmp + nums[i] < nums[i]) {
                tmp = nums[i];
            } else {
                tmp += nums[i];
            }
            if (tmp > result) {
                result = tmp;
            }
        }

        return result;
    }
}
