package com.kinglloy.leetcode;

public class InterleavingString_97 {
    public static void main(String[] args) {
        System.out.println(new InterleavingString_97().isInterleave("bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa",
                "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab",
                "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab"));
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        int l = s3.length();

        if (m + n != l) {
            return false;
        }

        int j = 0;
        int k = 0;
        for (int i = 0; i < l; i++) {
            if (j < m && k < n) {
                if (s1.charAt(j) == s3.charAt(i) && s2.charAt(k) == s3.charAt(i)) {
                    return isInterleave(s1.substring(j, m), s2.substring(k + 1, n), s3.substring(i + 1, l)) ||
                            isInterleave(s1.substring(j + 1, m), s2.substring(k, n), s3.substring(i + 1, l));
                } else if (s1.charAt(j) == s3.charAt(i)) {
                    j++;
                } else if (s2.charAt(k) == s3.charAt(i)) {
                    k++;
                } else {
                    return false;
                }
            } else if (j < m) {
                if (s1.charAt(j++) != s3.charAt(i)) {
                    return false;
                }
            } else {
                if (s2.charAt(k++) != s3.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}
