package com.kinglloy.leetcode;

public class NextPermutation_31 {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        boolean changed = false;
        for (int i = n - 1; i > 0; i--) {
            if (nums[i] >= nums[i - 1]) {
                if (i == n - 1) {
                    int tmp = nums[i];
                    nums[i] = nums[i - 1];
                    nums[i - 1] = tmp;
                    changed = true;
                    break;
                } else {
                    int tmp = nums[n - 1];
                    System.arraycopy(nums, i - 1, nums, i, n - i);
                    nums[i - 1] = tmp;
                    changed = true;
                    break;
                }
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
