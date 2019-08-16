package com.kinglloy.leetcode;

import java.util.*;

public class _MinimumWindowSubstring_76 {
    public static void main(String[] args) {
        String s = "ABCDDDDDDEEAFFBC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {
        char[] chs = s.toCharArray();
        char[] tChs = t.toCharArray();

        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : tChs) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        int n = s.length();
        int tN = t.length();
        int i = 0, j = i + tN;

        int minLength = -1;
        int minStart = -1;
        while (j <= n) {
            while (i < j && tMap.getOrDefault(chs[i], 0) <= 0) {
                i++;
            }
            while (j <= n && tMap.getOrDefault(chs[j - 1], 0) <= 0) {
                j++;
            }
            if (j > n || i >= j) {
                break;
            }
            if (isValid(chs, i, j, tMap)) {
                if (minLength == -1 || minLength > j - i) {
                    minLength = j - i;
                    minStart = i;
                }
                i++;
            } else {
                j++;
            }
        }
        return minStart < 0 ? "" : s.substring(minStart, minLength + minStart);
    }

    private static boolean isValid(char[] chs, int start, int end, Map<Character, Integer> tMap) {
        Map<Character, Integer> chsMap = new HashMap<>();
        for (int i = start; i < end; i++) {
            chsMap.put(chs[i], chsMap.getOrDefault(chs[i], 0) + 1);
        }

        for (Character c : tMap.keySet()) {
            if (chsMap.getOrDefault(c, 0) < tMap.getOrDefault(c, 0)) {
                return false;
            }
        }
        return true;
    }

    private static int indexOf(char[] chs, char c) {
        int result = -1;
        for (int i = 0; i < chs.length; i++) {
            if (c == chs[i]) {
                return i;
            }
        }
        return result;
    }

    private static int[] calLength(int[] dp) {
        int min = -1;
        int max = -1;
        for (int i : dp) {
            if (i < 0) {
                return new int[]{-1, -1};
            }
            if (min == -1 || i < min) {
                min = i;
            }
            if (max == -1 || i > max) {
                max = i;
            }
        }
        return new int[]{min, max - min + 1};
    }
}
