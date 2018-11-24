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
        int skip = 0;
        int globalMaxIndex = 0;

        char[] chars = s.toCharArray();

        int globalLength = 0;

        for (int i = 0; i < chars.length; i += (skip + 1)) {
            int localLength = 1;
            skip = 0;
            int left = i - localLength;
            int right = i + localLength;
            if (left < 0) {
                for (; right < chars.length; ) {
                    if (chars[i] == chars[right]) {
                        skip++;
                        localLength++;
                        right++;
                    } else {
                        break;
                    }
                }
            } else {
                for (; left >= 0 && right < chars.length; left--, right++) {
                    if (chars[left] == chars[right]) {
                        localLength++;
                    } else if (chars[i] == chars[right] && (skip > 0 || (i + 1) == right)) {
                        skip++;
                        localLength++;
                    } else {
                        break;
                    }
                }
            }
            int totalLength;
            if (skip > 0) {
                totalLength = localLength;
            } else {
                totalLength = 2 * localLength - 1;
            }
            if (totalLength > globalLength) {
                globalLength = totalLength;
                globalMaxIndex = i;
            }
        }

        if (globalLength == 1) {
            return String.valueOf(chars[globalMaxIndex]);
        }
        if (chars[globalMaxIndex] == chars[globalMaxIndex + 1]) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < globalLength; i++) {
                sb.append(chars[globalMaxIndex]);
            }
            return sb.toString();
        }

        int start = globalMaxIndex - globalLength / 2;
        int end = globalMaxIndex + globalLength / 2;
        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; i++) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("tattarrattat"));
    }
}
