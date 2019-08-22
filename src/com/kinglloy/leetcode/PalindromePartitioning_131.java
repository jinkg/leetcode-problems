package com.kinglloy.leetcode;

import java.util.*;

public class PalindromePartitioning_131 {
    public static void main(String[] args) {
        String s = "ababababababababababababcbabababababababababababa";

        List<List<String>> r = new PalindromePartitioning_131().partition1(s);

        System.out.println(r);
    }

    List<List<String>> res = new ArrayList<>();
    int len;
    boolean[][] dp;

    private void dfs(int startIdx, List<String> list, String s) {
        if (startIdx == len) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = startIdx; i < len; ++i) {
            if (dp[startIdx][i]) {
                list.add(s.substring(startIdx, i + 1));
                dfs(i + 1, list, s);
                list.remove(list.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        len = s.length();
        if (len == 0) return res;
        dp = new boolean[len][len];
        char[] sArr = s.toCharArray();
        for (int i = 0; i < len; ++i) {
            dp[i][i] = true;
            for (int j = 0; j < i; ++j) {
                if (sArr[i] == sArr[j] && (j + 1 > i - 1 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                }
            }
        }
        dfs(0, new ArrayList<>(), s);
        return res;
    }

    private Map<String, List<List<String>>> map = new HashMap<>();

    public List<List<String>> partition1(String s) {
        List<List<String>> ans = new LinkedList<>();
        if (s.length() == 1) {
            List<String> l = new LinkedList<>();
            l.add(s);
            ans.add(l);
            return ans;
        }

        if (map.containsKey(s)) {
            System.out.println(s);
            return map.get(s);
        }

        for (int i = 1; i <= s.length(); i++) {
            String sub = s.substring(0, i);
            int j = 0, k = i - 1;
            while (j < k && sub.charAt(j) == sub.charAt(k)) {
                j++;
                k--;
            }
            if (j >= k) {
                List<List<String>> r = i == s.length() ? new LinkedList<>() : partition1(s.substring(i));

                if (r.isEmpty()) {
                    List<String> l = new LinkedList<>();
                    l.add(sub);
                    ans.add(l);
                } else {
                    List<List<String>> r1 = new LinkedList<>();
                    for (List<String> l : r) {
                        List<String> l1 = new LinkedList<>(l);
                        l1.add(0, sub);
                        r1.add(l1);
                    }
                    ans.addAll(r1);
                }
            }
        }
        map.put(s, ans);
        return ans;
    }
}
