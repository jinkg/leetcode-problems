package com.kinglloy.leetcode;

public class SearchInRotatedSortedArray_33 {
    public static void main(String[] args) {
        int[] nums = new int[]{7, 8, 1, 2, 3, 4, 5, 6};
        System.out.println(search(nums, 2));
    }

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
//        return search(nums, 0, nums.length, target);

        int n = nums.length, l = 0, r = n - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[l] <= nums[mid]) {
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

    private static int search(int[] nums, int start, int end, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (end <= start) {
            return -1;
        }
        int middle = (start + end) / 2;
        if (nums[start] == target) {
            return start;
        }
        if (nums[middle] == target) {
            return middle;
        }
        if (nums[end - 1] == target) {
            return end - 1;
        }
        if (nums[start] < target) {
            if (target < nums[middle]) {
                return binary(nums, start, middle + 1, target);
            } else {
                if (nums[middle] > nums[start]) {
                    return search(nums, middle + 1, end, target);
                } else {
                    return search(nums, start, middle, target);
                }
            }
        } else if (target < nums[end - 1]) {
            if (target > nums[middle]) {
                return binary(nums, middle, end, target);
            } else {
                if (nums[middle] > nums[end - 1]) {
                    return search(nums, middle + 1, end, target);
                } else {
                    return search(nums, start, middle, target);
                }
            }
        } else {
            return -1;
        }
    }

    private static int binary(int[] nums, int start, int end, int target) {
        int l = start, r = end;
        int j = (l + r) / 2;
        while (l <= r) {
            if (nums[j] == target) {
                return j;
            } else if (nums[j] > target) {
                r = j - 1;
            } else {
                l = j + 1;
            }
            j = (l + r) / 2;
        }
        return -1;
    }
}
