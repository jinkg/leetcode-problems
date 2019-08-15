package com.kinglloy.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Permutations_46 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        List<List<Integer>> r = permute(nums);
        System.out.println(r);
    }

    public static List<List<Integer>> permute(int[] nums) {
        return permute(nums, 0);
    }

    public static List<List<Integer>> permute(int[] nums, int start) {
        List<List<Integer>> ans = new LinkedList<>();

        if (nums == null || nums.length - start == 0) {
            return ans;
        }

        if (nums.length - start == 1) {
            List<Integer> r = new LinkedList<>();
            r.add(nums[start]);
            ans.add(r);
            return ans;
        }

//        Arrays.sort(nums, start + 1, nums.length);

        int n = nums.length;
        for (int i = start; i < n; i++) {
            int t = nums[i];
            nums[i] = nums[start];
            nums[start] = t;

            List<List<Integer>> r = permute(nums, start + 1);
            for (List<Integer> row : r) {
                row.add(0, nums[start]);
            }
            ans.addAll(r);

            t = nums[i];
            nums[i] = nums[start];
            nums[start] = t;


        }
        return ans;
    }
}
