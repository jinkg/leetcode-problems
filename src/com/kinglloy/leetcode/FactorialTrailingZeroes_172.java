package com.kinglloy.leetcode;

public class FactorialTrailingZeroes_172 {
    public static void main(String[] args) {
        System.out.println(new FactorialTrailingZeroes_172().trailingZeroes(15));
    }

    public long trailingZeroes(int n) {
        long ans = 1;
        for (int i = 2; i <= n; i++) {
            ans *= i;
        }
        return ans;
    }
}
