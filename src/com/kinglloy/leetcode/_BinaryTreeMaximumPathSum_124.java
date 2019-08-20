package com.kinglloy.leetcode;

public class _BinaryTreeMaximumPathSum_124 {
    private int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(-10);
//        TreeNode left = new TreeNode(9);
//        TreeNode right = new TreeNode(20);
//        TreeNode right1 = new TreeNode(15);
//        TreeNode right2 = new TreeNode(7);
//        right.left = right1;
//        right.right = right2;
//        root.left = left;
//        root.right = right;

        TreeNode root = new TreeNode(-3);
//        TreeNode left = new TreeNode(-1);
//        root.left = left;

        System.out.println(new _BinaryTreeMaximumPathSum_124().maxPathSum(root));
    }

    int maxValue;

    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxValue;
    }

    private int maxPathDown(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));
        maxValue = Math.max(maxValue, left + right + node.val);
        return Math.max(left, right) + node.val;
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
