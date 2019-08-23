package com.kinglloy.leetcode;

import java.util.*;

public class BinaryTreePostorderTraversal_145 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);

        List<Integer> ans = new BinaryTreePostorderTraversal_145().postorderTraversal(root);

        System.out.println(ans);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Map<TreeNode, Integer> statMap = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode p = root;
        while (p != null) {
            stack.push(p);
            statMap.put(p, 1);
            p = p.left;
        }

        while (!stack.isEmpty()) {
            p = stack.peek();
            if (!statMap.containsKey(p)) {
                p = p.left;
                while (p != null) {
                    stack.push(p);
                    statMap.put(p, 1);
                    p = p.left;
                }
            } else if (statMap.get(p) == 1) {
                statMap.put(p, 2);
                p = p.right;
                while (p != null) {
                    stack.push(p);
                    statMap.put(p, 1);
                    p = p.left;
                }
            } else if (statMap.get(p) == 2) {
                p = stack.pop();
                ans.add(p.val);
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
