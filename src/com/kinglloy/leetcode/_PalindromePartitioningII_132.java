package com.kinglloy.leetcode;

public class _PalindromePartitioningII_132 {
    public static void main(String[] args) {
        String s = "aabb";

        System.out.println(new _PalindromePartitioningII_132().minCut(s));
    }

    public int minCut(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = i;
        }
        for (int i = 0; i < n; i++) {
            cut(s, i, i, dp);
            cut(s, i, i + 1, dp);
        }

        return dp[n - 1];
    }

    private void cut(String s, int i, int j, int[] dp) {
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) != s.charAt(j)) {
                return;
            }
            if (i == 0) {
                dp[j] = 0;
            } else {
                dp[j] = Math.min(dp[j], dp[i - 1] + 1);
            }
            i--;
            j++;
        }
    }
}
