package com.kinglloy.leetcode;

public class FindMinimumInRotatedSortedArrayII_154 {
    public static void main(String[] args) {
        int[] nums = new int[]{10, 1, 10, 10, 10};
        System.out.println(new FindMinimumInRotatedSortedArrayII_154().findMin(nums));
    }

    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1, mid = 0;

        while (l < r) {
            mid = (l + r) / 2;
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else if (nums[mid] < nums[r]) {
                r = mid;
            } else {
                r--;
            }
        }
        return nums[l];
    }
}
