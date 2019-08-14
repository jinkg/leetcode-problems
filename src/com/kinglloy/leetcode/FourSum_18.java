package com.kinglloy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum_18 {
    public static void main(String[] args) {
        List<List<Integer>> result = fourSum(new int[]{0, 0, 0, 0}, 0);
        System.out.println(result);
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n - 3; i++) {
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
            if (nums[i] + nums[n - 1] + nums[n - 2] + nums[n - 3] < target) continue;
            if (i == 0 || nums[i - 1] != nums[i]) {
                for (int j = i + 1; j < n - 2; j++) {
                    if (j == i + 1 || nums[j - 1] != nums[j]) {
                        int start = j + 1, end = n - 1;
                        while (start < end) {
                            int sum = nums[i] + nums[j] + nums[start] + nums[end];
                            if (sum > target) {
                                end--;
                            } else if (sum < target) {
                                start++;
                            } else {
                                ans.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
                                while (start < end && nums[start] == nums[start + 1]) {
                                    start++;
                                }
                                while (start < end && nums[end] == nums[end - 1]) {
                                    end--;
                                }
                                start++;
                                end--;
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }
}
