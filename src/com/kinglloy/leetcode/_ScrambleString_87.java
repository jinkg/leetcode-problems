package com.kinglloy.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _ScrambleString_87 {

    public static void main(String[] args) {
        long tic = System.currentTimeMillis();
        System.out.println(isScramble("ccabcbabcbabbbbcbb", "bbbbabccccbbbabcba"));
        System.out.println(System.currentTimeMillis() - tic);
    }

    public static boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return s1 == null && s2 == null;
        }
        int m = s1.length();
        int n = s2.length();
        if (m != n) {
            return false;
        }
        if (n == 1) {
            return s1.equals(s2);
        }

        char[] chs1 = s1.toCharArray();
        char[] chs2 = s2.toCharArray();

        boolean[][][] map = new boolean[m][n][n + 1];
        return isScramble(chs1, chs2, 0, n, 0, n, map);
    }

    public static boolean isScramble(char[] chs1, char[] chs2, int start1, int end1, int start2, int end2, boolean[][][] map) {
        int m = end1 - start1;
        int n = end2 - start2;
        if (m != n) {
            return false;
        }
        if (n == 0) {
            return true;
        }
        if (n == 1) {
            return chs1[start1] == chs2[start2];
        }
        if (map[start1][start2][n]) {
            return true;
        }
        if (map[start1][start2][n - 1]) {
            if (chs1[end1 - 1] == chs2[end2 - 1]) {
                map[start1][start2][n] = true;
                return true;
            } else {
                return false;
            }
        }
        for (int i = start1 + 1; i < end1; i++) {
            int j = i - start1 + start2;
            boolean a = isScramble(chs1, chs2, start1, i, start2, j, map);
            if (a) {
                map[start1][start2][i - start1] = true;
            }
            boolean b = a && isScramble(chs1, chs2, i, end1, j, end2, map);
            if (b) {
                map[i][j][end1 - i] = true;
            }
            if (a && b) {
                return true;
            }
            boolean c = isScramble(chs1, chs2, start1, i, end2 - j + start2, end2, map);
            if (c) {
                map[start1][end2 - j + start2][i - start1] = true;
            }

            boolean d = c && isScramble(chs1, chs2, i, end1, start2, end2 - j + start2, map);
            if (d) {
                map[i][start2][end1 - i] = true;
            }

            if (c && d) {
                return true;
            }
        }
        return false;
    }

    public static int formatKey(int start1, int end1, int start2, int end2) {
//        return start1 + "_" + end1 + "_" + start2 + "_" + end2;
        int hash = start1;
        hash = hash * 31 + end1;
        hash = hash * 31 + start2;
        hash = hash * 31 + end2;
        return hash;
    }

    public static boolean isSample(char[] chs1, char[] chs2, int start1, int end1, int start2, int end2) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = start1; i < end1; i++) {
            map.put(chs1[i], map.getOrDefault(chs1[i], 0) + 1);
        }

        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = start2; i < end2; i++) {
            map2.put(chs2[i], map2.getOrDefault(chs2[i], 0) + 1);
        }

        for (char c : map.keySet()) {
            if (!map.getOrDefault(c, 0).equals(map2.getOrDefault(c, 0))) {
                return false;
            }
        }
        return true;
    }
}
