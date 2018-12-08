package com.kinglloy.leetcode;

/**
 * 5. Longest Palindromic Substring
 * Medium
 * <p>
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example 1:
 * <p>
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 * <p>
 * Input: "cbbd"
 * Output: "bb"
 */
// todo need complete
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.equals("")) {
            return "";
        }

        int[] maxResult = new int[2];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int[] result = getPalindromicLong(chars, i);
            if (maxResult[1] < result[1]) {
                maxResult = result;
            }
        }

        return s.substring(maxResult[0], maxResult[0] + maxResult[1]);
    }

    private int[] getPalindromicLong(char[] chars, int position) {
        int[] result = new int[2];
        // mode 1
        int mode1Length = 0;
        if (position < chars.length - 1) {
            int start = position;
            int end = position + 1;
            while (start >= 0 && end < chars.length && chars[start] == chars[end]) {
                start--;
                end++;
                mode1Length++;
            }
            mode1Length *= 2;
            if (mode1Length > result[1]) {
                result[0] = start + 1;
                result[1] = mode1Length;
            }
        }

        // mode 2
        int mode2Length = 0;
        if (position < chars.length && position >= 0) {
            int start = position - 1;
            int end = position + 1;
            while (start >= 0 && end < chars.length && chars[start] == chars[end]) {
                start--;
                end++;
                mode2Length++;
            }
            mode2Length *= 2;
            mode2Length++;
            if (mode2Length > result[1]) {
                result[0] = start + 1;
                result[1] = mode2Length;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("a"));
    }
}
