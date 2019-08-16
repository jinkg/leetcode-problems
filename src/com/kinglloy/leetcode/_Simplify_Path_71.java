package com.kinglloy.leetcode;

import java.util.*;

public class _Simplify_Path_71 {
    public static void main(String[] args) {
        System.out.println(simplifyPath("/home//foo/"));
    }

    public static String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        Set<String> skip = new HashSet<>(Arrays.asList("..", ".", ""));
        for (String dir : path.split("/")) {
            if (dir.equals("..") && !stack.isEmpty()) {
                stack.pop();
            } else if (!skip.contains(dir)) {
                stack.push(dir);
            }
        }
        StringBuilder res = new StringBuilder();
        for (String dir : stack) {
            res.insert(0, "/" + dir);
        }
        return res.length() == 0 ? "/" : res.toString();
    }
}
