package com.kinglloy.leetcode;

public class FindMinimumInRotatedSortedArray_153 {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        System.out.println(new FindMinimumInRotatedSortedArray_153().findMin(nums));
    }

    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int l = 0, r = nums.length - 1;
        int min = nums[0];
        while (l <= r) {
            if (nums[l] <= nums[r]) {
                min = Math.min(nums[l], min);
                break;
            }
            int middle = (l + r) / 2;
            min = Math.min(nums[middle], min);
            if (nums[l] <= nums[middle]) {
                l = middle + 1;
            } else {
                r = middle - 1;
            }
        }
        return min;
    }
}
