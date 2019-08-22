package com.kinglloy.leetcode;

public class _SingleNumberII_137 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 3, 2};
        System.out.println(new _SingleNumberII_137().singleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for (int num : nums) {
            ones = (ones ^ num) & ~twos;
            twos = (twos ^ num) & ~ones;
        }
        return ones;
    }
}
