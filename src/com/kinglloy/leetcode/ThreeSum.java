package com.kinglloy.leetcode;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                int low = i + 1, hight = nums.length - 1;
                while (low < hight) {
                    int twoSum = nums[low] + nums[hight];
                    if (twoSum == -nums[i]) {
                        result.add(Arrays.asList(nums[i], nums[low], nums[hight]));

                        while (low < hight && nums[low + 1] == nums[low]) {
                            low++;
                        }
                        while (low < hight && nums[hight - 1] == nums[hight]) {
                            hight--;
                        }
                        low++;
                        hight--;
                    } else if (twoSum < -nums[i]) {
                        low++;
                    } else {
                        hight--;
                    }
                }
            }
        }
        return result;
    }
}
