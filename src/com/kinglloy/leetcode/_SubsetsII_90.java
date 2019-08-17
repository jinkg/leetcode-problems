package com.kinglloy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _SubsetsII_90 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> r = subsetsWithDup(nums);
        System.out.println(r);
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> resultSet = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        Arrays.sort(nums);
        dfs(0, nums, subset, resultSet);
        return resultSet;
    }

    public static void dfs(int index, int[] nums, List<Integer> subset, List<List<Integer>> resultSet) {
        resultSet.add(new ArrayList<>(subset));

        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1]) {
                continue;
            }
            subset.add(nums[i]);
            dfs(i + 1, nums, subset, resultSet);
            subset.remove(subset.size() - 1);
        }
    }
}
