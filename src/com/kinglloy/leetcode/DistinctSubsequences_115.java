package com.kinglloy.leetcode;

public class DistinctSubsequences_115 {
    public static void main(String[] args) {
        System.out.println(new DistinctSubsequences_115().numDistinct(
                "adbdadeecadeadeccaeaabdabdbcdabddddabcaaadbabaaedeeddeaeebcdeabcaaaeeaeeabcddcebddebeebedaecccbdcbcedbdaeaedcdebeecdaaedaacadbdccabddaddacdddc",
                "bcddceeeebecbc"));

//        System.out.println(new DistinctSubsequences_115().numDistinct(
//                "babgbag",
//                "bag"));
    }

    public int numDistinct(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return 0;
        }

        int[][] cache = new int[s.length()][t.length()];
        for (int i = 0; i < cache.length; i++) {
            for (int j = 0; j < cache[0].length; j++) {
                cache[i][j] = -1;
            }
        }
        return numDistinct(s.toCharArray(), 0, t.toCharArray(), 0, cache);
    }

    public int numDistinct(char[] s, int sStart, char[] t, int tStart, int[][] cache) {
        if (s == null || s.length - sStart == 0 || t == null || t.length - tStart == 0) {
            return 0;
        }

        int m = s.length;
        int n = t.length;

        if (n - tStart > m - sStart) {
            return 0;
        }

        if (cache[sStart][tStart] >= 0) {
            return cache[sStart][tStart];
        }

        int ans = 0;
        char t0 = t[tStart];
        for (int i = sStart; i < m; i++) {
            if (s[i] == t0) {
                if (i < m - 1 && n - tStart > 1) {
                    ans += numDistinct(s, i + 1, t, tStart + 1, cache);
                } else if (n - tStart > 1) {
                    break;
                } else {
                    ans += 1;
                }
            }
        }
        cache[sStart][tStart] = ans;

        return ans;
    }
}
