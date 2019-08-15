package com.kinglloy.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PermutationsII_47 {
    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 1, 2}));
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

//        Arrays.sort(nums, start, nums.length);

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
        ans = removeDuplicate(ans);
        return ans;
    }

    private static List<List<Integer>> removeDuplicate(List<List<Integer>> ans) {
        List<List<Integer>> out = new ArrayList<>();
        for (List<Integer> c : ans) {
            boolean dup = false;
            for (List<Integer> o : out) {
                if (elemEqual(o, c)) {
                    dup = true;
                    break;
                }
            }
            if (!dup) {
                out.add(c);
            }
        }
        return out;
    }

    private static boolean elemEqual(List<Integer> a, List<Integer> b) {
        if (a.size() != b.size()) {
            return false;
        }
        int n = a.size();
        for (int i = 0; i < n; i++) {
            if (!a.get(i).equals(b.get(i))) {
                return false;
            }
        }
        return true;
    }
}
