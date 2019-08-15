package com.kinglloy.leetcode;

public class TrappingRainWater_42 {
    public static void main(String[] args) {
        int[] height = new int[]{5, 2, 1, 2, 1, 5};
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int n = height.length;
        int c = 0;
        for (int i = 0; i < n - 1; ) {
            int maxIndex = i + 1;
            for (int j = i + 1; j < n; j++) {
                if (height[j] >= height[i]) {
                    maxIndex = j;
                    break;
                } else {
                    if (height[maxIndex] <= height[j]) {
                        maxIndex = j;
                    }
                }
            }
            c += count(height, i, maxIndex + 1);
            i = maxIndex;
        }
        return c;
    }

    public static int count(int[] height, int start, int end) {
        int min = Math.min(height[start], height[end - 1]);
        int total = min * Math.max(0, end - start - 2);
        for (int i = start + 1; i < end - 1; i++) {
            total -= Math.min(min, height[i]);
        }
        return total;
    }
}
