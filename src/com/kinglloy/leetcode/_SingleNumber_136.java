package com.kinglloy.leetcode;

public class _SingleNumber_136 {
    public int singleNumber(int[] nums) {
        int x = 0;
        for (int c : nums) {
            x ^= c;
        }
        return x;
    }
}
