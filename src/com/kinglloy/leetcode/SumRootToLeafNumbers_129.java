package com.kinglloy.leetcode;

public class SumRootToLeafNumbers_129 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);

        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);

        System.out.println(new SumRootToLeafNumbers_129().sumNumbers(root));
    }

    private int result;

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        result = 0;
        rootToLeaf(root, 0);
        return result;
    }

    public void rootToLeaf(TreeNode root, int sum) {
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            result += sum;
        }
        if (root.left != null) {
            rootToLeaf(root.left, sum);
        }
        if (root.right != null) {
            rootToLeaf(root.right, sum);
        }
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
