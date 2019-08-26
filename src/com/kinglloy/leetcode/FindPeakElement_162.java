package com.kinglloy.leetcode;

public class FindPeakElement_162 {
    public static void main(String[] args) {
//        int[] nums = new int[]{1, 2, 1, 3, 5, 6, 4};
        int[] nums = new int[]{2, 3};
        System.out.println(new FindPeakElement_162().findPeakElement(nums));
    }

    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (l == r) {
                return mid;
            }
            if (mid == 0) {
                if (nums[mid] > nums[mid + 1]) {
                    return mid;
                } else if (nums[mid] < nums[mid + 1]) {
                    return mid + 1;
                }

            }
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid] < nums[mid - 1]) {
                r = mid - 1;
            } else if (nums[mid] < nums[mid + 1]) {
                l = mid + 1;
            } else {
                return -1;
            }
        }
        return -1;
    }
}
