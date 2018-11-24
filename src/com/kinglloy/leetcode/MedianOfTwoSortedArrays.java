package com.kinglloy.leetcode;

/**
 * 4. Median of Two Sorted Arrays
 * Hard
 * <p>
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * <p>
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * <p>
 * You may assume nums1 and nums2 cannot be both empty.
 * <p>
 * Example 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * The median is 2.0
 * Example 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * The median is (2 + 3)/2 = 2.5
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        boolean odd = totalLength % 2 == 1;
        int position = odd ? totalLength / 2 : totalLength / 2 - 1;
        int[] medians = new int[2];
        boolean needReturn = false;
        for (int i = 0, j = 0; i < nums1.length || j < nums2.length; ) {
            if (i < nums1.length && j < nums2.length) {
                if (nums1[i] < nums2[j]) {
                    medians[0] = nums1[i];
                    i++;
                } else {
                    medians[0] = nums2[j];
                    j++;
                }
            } else if (i < nums1.length) {
                medians[0] = nums1[i];
                i++;
            } else {
                medians[0] = nums2[j];
                j++;
            }

            if(needReturn){
                return (medians[0] + medians[1]) / 2.0;
            }

            if (i + j - 1 == position) {
                if (odd) {
                    return medians[0];
                } else {
                    medians[1] = medians[0];
                    needReturn = true;
                }
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(new int[0], new int[]{2, 3}));
    }
}
