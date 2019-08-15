package com.kinglloy.leetcode;

public class _WildcardMatching_44 {
    public boolean isMatch(String str, String pattern) {
        int s = 0, p = 0, match = 0, startIdx = -1;
        int n = str.length();
        int m = pattern.length();
        while (s < n) {
            if (p < m && (pattern.charAt(p) == '?' || pattern.charAt(p) == str.charAt(s))) {
                p++;
                s++;
            } else if (p < m && pattern.charAt(p) == '*') {
                startIdx = p;
                match = s;
                p++;
            } else if (startIdx != -1) {
                p = startIdx + 1;
                match++;
                s = match;
            } else {
                return false;
            }
        }

        while (p < m && pattern.charAt(p) == '*') {
            p++;
        }

        return p == m;
    }
}
