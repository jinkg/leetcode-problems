package com.kinglloy.leetcode;

public class _JumpGameII_45 {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 6, 4, 4, 6, 9, 4, 4, 7, 4, 4, 8, 2, 6, 8, 1, 5, 9, 6, 5, 2, 7, 9, 7, 9, 6, 9, 4, 1, 6, 8, 8, 4, 4, 2, 0, 3, 8, 5};
        System.out.println(jump(nums));
    }

    public static int jump(int[] nums) {
//        return jump(nums, 0);

        int jump = 0, curFastest = 0, curEnd = 0;
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            curFastest = Math.max(curFastest, i + nums[i]);
            if (i == curEnd) {
                jump++;
                curEnd = curFastest;
            }
        }
        return jump;
    }

    private static int jump(int[] nums, int start) {
        int n = nums.length;
        if (n - start <= 1) {
            return 0;
        }
        if (n - start <= nums[start]) {
            return 1;
        }

        int minCount = -2;
        for (int i = 1; i <= nums[start]; i++) {
            if (start + i < n) {
                int count = jump(nums, start + i) + 1;
                if (count > 0 && (minCount < 0 || count < minCount)) {
                    minCount = count;
                }
            }
        }
        return minCount;
    }
}
