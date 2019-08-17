package com.kinglloy.leetcode;

import java.util.*;

public class GrayCode_89 {

    public static void main(String[] args) {
        long tic = System.currentTimeMillis();
        List<Integer> r = grayCode(20);
        System.out.println(System.currentTimeMillis() - tic);
    }

    public static List<Integer> grayCode(int n) {
        if (n <= 0) {
            return Collections.singletonList(0);
        }

        if (n == 1) {
            return Arrays.asList(0, 1);
        }

        List<Integer> last = grayCode(n - 1);
        List<Integer> ans = new ArrayList<>((int) Math.pow(2, n));
        ans.addAll(last);
        for (int i = last.size() - 1; i >= 0; i--) {
            ans.add((int) Math.pow(2, n - 1) + last.get(i));
        }
        return ans;
    }
}
