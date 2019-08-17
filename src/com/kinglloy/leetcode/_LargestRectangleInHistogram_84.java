package com.kinglloy.leetcode;

public class _LargestRectangleInHistogram_84 {

    public static void main(String[] args) {
//        int[] nums = {0, 0, 0, 0, 0, 0, 0, 0, 2147483647};
        int[] nums = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(nums));
    }

    public static int largestRectangleArea(int[] heights) {
//        return largestRectangleArea(heights, 0, heights.length);
        if (heights == null || heights.length == 0) {
            return 0;
        }

//        int n = heights.length;
//
//        int maxArea = 0;
//        for (int i = 0; i < n; i++) {
//            int leftMinIdx = -1;
//            int rightMinIdx = n;
//            for (int j = i - 1; j >= 0; j--) {
//                if (heights[i] > heights[j]) {
//                    leftMinIdx = j;
//                    break;
//                }
//            }
//            for (int j = i + 1; j < n; j++) {
//                if (heights[j] < heights[i]) {
//                    rightMinIdx = j;
//                    break;
//                }
//            }
//            maxArea = Math.max(maxArea, (rightMinIdx - leftMinIdx - 1) * heights[i]);
//        }
//        return maxArea;

        int[] lessFromLeft = new int[heights.length]; // idx of the first bar the left that is lower than current
        int[] lessFromRight = new int[heights.length]; // idx of the first bar the right that is lower than current
        lessFromRight[heights.length - 1] = heights.length;
        lessFromLeft[0] = -1;

        for (int i = 1; i < heights.length; i++) {
            int p = i - 1;

            while (p >= 0 && heights[p] >= heights[i]) {
                p = lessFromLeft[p];
            }
            lessFromLeft[i] = p;
        }

        for (int i = heights.length - 2; i >= 0; i--) {
            int p = i + 1;

            while (p < heights.length && heights[p] >= heights[i]) {
                p = lessFromRight[p];
            }
            lessFromRight[i] = p;
        }

        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            maxArea = Math.max(maxArea, heights[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
        }

        return maxArea;
    }


    public static int largestRectangleArea(int[] heights, int start, int end) {
        if (start == end) {
            return 0;
        }
        if (end - start == 1) {
            return heights[start];
        }

        int minIndex = start;
        int maxIndex = start;
        for (int i = start; i < end; i++) {
            if (heights[i] < heights[minIndex]) {
                minIndex = i;
            }
            if (heights[i] > heights[maxIndex]) {
                maxIndex = i;
            }
        }
        return Math.max((end - start) * heights[minIndex],
                Math.max(largestRectangleArea(heights, start, minIndex),
                        largestRectangleArea(heights, minIndex + 1, end)));
    }
}
