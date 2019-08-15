package com.kinglloy.leetcode;

public class _ClimbingStairs_70 {
    public int climbStairs(int n) {
        int[] memo = new int[n];
        return climbStairs(0, n, memo);
    }

    public int climbStairs(int i, int n, int[] memo) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (memo[i] > 0) {
            return memo[i];
        }
        memo[i] = climbStairs(i + 1, n, memo) + climbStairs(i + 2, n, memo);
        return memo[i];
    }
}
