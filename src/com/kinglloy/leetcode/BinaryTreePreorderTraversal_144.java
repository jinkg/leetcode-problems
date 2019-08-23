package com.kinglloy.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal_144 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        List<Integer> ans = new BinaryTreePreorderTraversal_144().preorderTraversal(root);

        System.out.println(ans);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Stack<TreeNode> stack = new Stack<>();

        TreeNode p = root;
        while (p != null) {
            ans.add(p.val);
            stack.push(p);
            p = p.left;
        }

        while (!stack.isEmpty()) {
            p = stack.pop();
            p = p.right;
            while (p != null) {
                ans.add(p.val);
                stack.push(p);
                p = p.left;
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
