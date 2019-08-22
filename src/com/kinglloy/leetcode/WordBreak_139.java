package com.kinglloy.leetcode;

import java.util.*;

public class WordBreak_139 {
    public static void main(String[] args) {
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        List<String> wordDict = Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa");

//        String s = "applepenapple";
//        List<String> wordDict = Arrays.asList("apple", "pen");

//        boolean r = new WordBreak_139().wordBreak(s, wordDict);
        boolean r = new WordBreak_139().wordBreak1(s, wordDict);
        System.out.println(r);
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int[] dp = new int[s.length()];
        return wordBreak(s, wordDict, 0, dp) == 1;
    }

    private int wordBreak(String s, List<String> wordDict, int index, int[] dp) {
        if (index >= s.length()) return 1;
        if (dp[index] != 0) {
            return dp[index];
        }

        for (int i = 0; i < wordDict.size(); i++) {
            if (!s.startsWith(wordDict.get(i), index)) continue;
            if (wordBreak(s, wordDict, index + wordDict.get(i).length(), dp) == 1) {
                dp[index] = 1;
                return dp[index];
            }
        }

        dp[index] = -1;
        return dp[index];
    }

    public boolean wordBreak1(String s, List<String> wordDict) {
        return wordBreak1(s, new HashSet<>(wordDict));
    }

    private Map<String, Boolean> map = new HashMap<>();

    public boolean wordBreak1(String s, Set<String> wordDict) {
        if (map.containsKey(s)) {
            return map.get(s);
        }

        for (int i = 0; i < s.length(); i++) {
            String sub = s.substring(0, i + 1);
            if (wordDict.contains(sub)) {
                if (i == s.length() - 1) {
                    map.put(s, true);
                    return true;
                } else {
                    if (wordBreak1(s.substring(i + 1), wordDict)) {
                        map.put(s, true);
                        return true;
                    }
                }
            }
        }
        map.put(s, false);
        return false;
    }
}
