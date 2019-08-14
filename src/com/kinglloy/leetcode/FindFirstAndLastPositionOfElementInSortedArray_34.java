package com.kinglloy.leetcode;

public class FindFirstAndLastPositionOfElementInSortedArray_34 {
    public int[] searchRange(int[] nums, int target) {
        int leftTarget = searchLeaning(nums, true, target);
        if (!(leftTarget >= 0 && leftTarget < nums.length) || nums[leftTarget] != target) {
            return new int[]{-1, -1};
        }

        int rightTarget = searchLeaning(nums, false, target);

        return new int[] {leftTarget, rightTarget - 1};
    }

    private int searchLeaning(int[] nums, boolean isleft, int target) {
        int l = 0, r = nums.length;
        while(l < r) {
            int mid = (l + r) / 2;
            if(nums[mid] > target || isleft && nums[mid] == target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}

