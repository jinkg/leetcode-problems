package com.kinglloy.leetcode;

public class UniqueBinarySearchTrees_96 {
    public static void main(String[] args) {
        long tic = System.currentTimeMillis();
        System.out.println(new UniqueBinarySearchTrees_96().numTrees(5));
        System.out.println(System.currentTimeMillis() - tic);
    }

    public int numTrees(int n) {
        int[] cache = new int[n + 1];
        return numTrees(0, n, cache);
    }

    public int numTrees(int start, int end, int[] cache) {
        if (start >= end || start < 0) {
            return 0;
        }
        if (end - start == 1) {
            return 1;
        }

        if (cache[end - start] > 0) {
            return cache[end - start];
        }

        int count = 0;
        for (int i = start; i < end; i++) {
            int left = numTrees(start, i, cache);
            int right = numTrees(i + 1, end, cache);

            count += Math.max(left, 1) * Math.max(right, 1);
        }
        cache[end - start] = count;

        return count;
    }
}
