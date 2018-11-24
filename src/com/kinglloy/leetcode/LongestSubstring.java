package com.kinglloy.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 3. Longest Substring Without Repeating Characters
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * <p>
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * <p>
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * <p>
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        List<Character> characterList = new ArrayList<>();
        int[] slots = new int[128];
        int globalMaxLength = 0;

        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (slots[c] == 1) {
                int localMaxLength = characterList.size();
                if (globalMaxLength < localMaxLength) {
                    globalMaxLength = localMaxLength;
                }
                for (Iterator<Character> iterator = characterList.iterator(); iterator.hasNext();) {
                    char c1 = iterator.next();
                    iterator.remove();
                    slots[c1] = 0;
                    if (c1 == c) {
                        break;
                    }
                }
            }
            characterList.add(c);
            slots[c] = 1;
        }
        int localMaxLength = characterList.size();
        if (globalMaxLength < localMaxLength) {
            globalMaxLength = localMaxLength;
        }
        return globalMaxLength;
    }

    public static void main(String[] args) {
        int length = new LongestSubstring().lengthOfLongestSubstring(" ");
        System.out.println(length);
    }
}
