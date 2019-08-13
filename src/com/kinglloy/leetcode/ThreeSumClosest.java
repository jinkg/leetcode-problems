package com.kinglloy.leetcode;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        int result = nums[0] + nums[1] + nums[nums.length - 1];
        if (nums.length == 3) {
            return result;
        }
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            if (nums[i] + nums[n - 1] + nums[n - 2] < target) {
                result = nums[i] + nums[n - 1] + nums[n - 2];
                continue;
            }
            if (nums[i] + nums[i + 1] + nums[i + 2] > target) {
                result = lessGap(result, nums[i] + nums[i + 1] + nums[i + 2], target);
                continue;
            }
            int start = i + 1, end = n - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum == target) {
                    return sum;
                }
                result = lessGap(result, sum, target);
                if (sum > target) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return result;
    }

    private int lessGap(int sum, int temp, int target) {
        return Math.abs(sum - target) < Math.abs(temp - target) ? sum : temp;
    }
}
