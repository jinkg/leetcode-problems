package com.kinglloy.leetcode;

public class JumpGameIII_55 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 1, 4};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        int curFast = 0, curEnd = 0;
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            curFast = Math.max(curFast, curFast + nums[i]);
            if (i == curEnd) {
                if (curEnd == curFast) {
                    return false;
                }
                curEnd = curFast;
            }
        }
        return true;
    }
}
