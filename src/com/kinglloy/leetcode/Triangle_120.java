package com.kinglloy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle_120 {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        System.out.println(new Triangle_120().minimumTotal(triangle));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] minlen = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                if (i + 1 == n) {
                    minlen[j] = triangle.get(i).get(j);
                } else {
                    minlen[j] = triangle.get(i).get(j) + Math.min(minlen[j], minlen[j + 1]);
                }
            }
        }
        return minlen[0];
    }
}
