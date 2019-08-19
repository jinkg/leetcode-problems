package com.kinglloy.leetcode;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII_95 {
    public static void main(String[] args) {
        List<TreeNode> p = new UniqueBinarySearchTreesII_95().generateTrees(3);
        System.out.println(p);
    }

    public List<TreeNode> generateTrees(int n) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        return generateTrees(nums, 0, n);
    }

    public List<TreeNode> generateTrees(int[] nums, int start, int end) {
        List<TreeNode> ans = new ArrayList<>();
        if (start >= end || start < 0) {
            return ans;
        }
        if (end - start == 1) {
            ans.add(new TreeNode(nums[start]));
            return ans;
        }

        for (int i = start; i < end; i++) {
            List<TreeNode> left = generateTrees(nums, start, i);
            List<TreeNode> right = generateTrees(nums, i + 1, end);

            if (!left.isEmpty() && !right.isEmpty()) {
                for (TreeNode l : left) {
                    for (TreeNode r : right) {
                        TreeNode p = new TreeNode(nums[i]);
                        p.left = l;
                        p.right = r;
                        ans.add(p);
                    }
                }
            } else if (!left.isEmpty()) {
                for (TreeNode l : left) {
                    TreeNode p = new TreeNode(nums[i]);
                    p.left = l;
                    ans.add(p);
                }
            } else if (!right.isEmpty()) {
                for (TreeNode r : right) {
                    TreeNode p = new TreeNode(nums[i]);
                    p.right = r;
                    ans.add(p);
                }
            } else {
                TreeNode p = new TreeNode(nums[i]);
                ans.add(p);
            }
        }

        return ans;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
