package com.kinglloy.leetcode;

public class DecodeWays_91 {
    public static void main(String[] args) {
        System.out.println(new DecodeWays_91().numDecodings("100"));
    }

    public int numDecodings(String s) {
//        int[] cacheMap = new int[s.length()];
//        return numDecodings(s.toCharArray(), 0, cacheMap);
        return numDecodingsDp(s);
    }

    private int numDecodingsDp(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int n = s.length();
        int dp0 = 1;
        int dp1 = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= n; i++) {
            int tmp = 0;
            int first = s.charAt(i - 1) - '0';
            int last = (s.charAt(i - 2) - '0') * 10 + first;
            if (last >= 10 && last <= 26) {
                tmp += dp0;
            }
            if (first >= 1 && first <= 9) {
                tmp += dp1;
            }

            dp0 = dp1;
            dp1 = tmp;

            if (dp1 == 0) {
                break;
            }
        }
        return dp1;
    }

    private int numDecodings(char[] chs, int start, int[] cacheMap) {
        int n = chs.length;
        if (n <= start) {
            return 0;
        }
        if (chs[start] == '0') {
            return 0;
        }
        if (n - start == 1) {
            return 1;
        }
        if (n - start == 2 && (chs[start] - '0') * 10 + (chs[start + 1] - '0') <= 26) {
            if (chs[start + 1] == '0') {
                return 1;
            } else {
                return 2;
            }
        }
        if (cacheMap[start] > 0) {
            return cacheMap[start];
        }
        int ans;
        if ((chs[start] - '0') * 10 + (chs[start + 1] - '0') > 26) {
            ans = numDecodings(chs, start + 1, cacheMap);
        } else if (chs[start + 1] == '0') {
            ans = numDecodings(chs, start + 2, cacheMap);
        } else {
            ans = numDecodings(chs, start + 1, cacheMap) + numDecodings(chs, start + 2, cacheMap);
        }
        cacheMap[start] = ans;
        return ans;
    }
}
