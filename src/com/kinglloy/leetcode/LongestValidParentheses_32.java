package com.kinglloy.leetcode;

import java.util.Stack;

public class LongestValidParentheses_32 {

    public static void main(String[] args) {
//        System.out.println(longestValidParentheses("((())))()())))(((()()(())))((()(())()((()))())())())()())))))))(((()(())(()))(()()(()()((()))()(())(()(())))))()(())(()()(((()(()()))))((()()))))))()((()())()()))((())()((((()))()()()((()())))())((())))))))(()()((((((()))(((((((()()))((())()(()())()()()(()())(()())(())))()()))))()(((())(())(()())()))()(()))(())((()))))(())))()))((()((()(())(()()()()()))(())())()))))()(()(((())))()()()(((()((()))(()((((((())((()))(()(())(()))(())())))()()))))())(()((()()())()))((((()(()))()()))(()())))((()))(()((((()(())(())()((()))(()))())))(((()(())))((())()(()(((())))())())()()()())((()()))))))(()))(())()(((()))()()((()))(()))(((()))))))))(()(())())(()((())(()()))((())))(()())((((())))(()(()))())(((()(()((()(())((())())(()))(())))()()(())((()()))((()()((()()())())()))())()))())()))())(()(()))(()))()(())))((((())()())()()())((()())(()())(()()))()(())(())))))()()()((()(())(((()(())()()))(()()((()(((()))))))))(((()((()()((()(((((())((()((()((((((((())()))())((())((()((()(()((())(((()(()))())))))))))))))()((()(())())))()(()))(((()))())()(((()))))((()(())(()())(((()(((()((((())()))))(())((()(((((()((()(()()()()((()((((((((((((())()(()))()()(()())()(()(((()((()(()()()())))((())()))())()()))())(((()(())))))()()()(((())))((()(()(((())(())(()((((()(((()(())(((((())()))())())()()(()())((((()(())))((()())))))))))()(()(())))))))()))()())))((())(()()()()()()()(())(()())))))())((()()))))()))))((())((()(((()))))(((()()))()(()((()()())()))(((()(()((())(()(()(()()))()((()(())))()((())))))(())()(())()))((())(((((()))()())(())))((((()((())())(())))(())))))((())())())((((()((())))()()((()()()))()())())(()())(((()))()()))))(()(())(()))()())(()())(()))(((((((()(()))())()())()())((()(((((()())(((())))()())))(()(()(())()((())()))(())))())()))((((()))())((()))(())))))(()))))))(()))))(())))())()()())()()(())()()(((((()))(((()()))()(()((((()(()(()(())))())))())(()()())()(()))())(()()))(()()((()()))))))(())((()()))(())))())())(())((((()))))()))()))()()()))))((((()((())(()))(()()))(())()())(()())))(()(()(())((()())()((())(()))()))()))))((())))(())(()))()()()()()))((())(((()(())))(((((((()(()))(()))())()((()))(()(())((()((()((())))()()((())))))((((())()())(()()(((()()((()))()()((())))(((()())((((()(())())))())()()()(())()))))))()()((()))())(()(((()()))((())))())())())((((()(((()(())())()())((()((()(()((())()(()))()((())))()(()))))(((()))())())(()((()))))()()(((((()))())))(()(()(())((((())())))((()()())(((((((()(()(()))(())))))()))(()(((((())()))((()()()()((()))()(()()()()))(()))))())())()))()(()()(((())((()))(()())))((()()(((())())))))))(())))((()(()(((())((((()))))(()()()))))(((((((())(()(()))(()(())((())(()(()(()(()())(())()(())(()()(()(()))())(())()()(((()())(())(()(((()()(())()((((()()))())(((()(((((()())()(())))()))))(()(()()(()(()()(((()))()))((()())))()(()(())))))))())((((()()))(()))))()((()))(()))())()))()))))(()(())()()()))(((((()))()())())(()())())))()())))))()()()())))))(())(((()))((())((()()))))()((((()(()(()))))(()(())(((())(()()(((()(())()())(()()(()(()())))()())))(((()()((()())()()((()))()))(((()((((()(((()(((()(()())((()))))()(()())(())()(()(((())((()))(())()(())()(()(())()))())()))()())(()))))()))))((()()()((()(()()(())))())(())()(()()))))))))()((()))((((())))())))((()()()(()(()((((()((()))()()((())((())(()))))(())())(((()()(()))))))(()()))()))((()(()(())()))(((())()))(())(()((((()((()()()))()()))(()()(())())((((((())(())((()())()(()())))()))())(()()(()(()()()(()()()()))(()(()()())())((()()()(((()((()())()()((()()(()((()())()())()((()))(()((()())))))))(())((((())(((((())(((())(()))(((()((()()())()((()(()))()()()(()((((())))(())())))((())))(()(((((()()()((())((((((((()()((((())))())())())))))))(((()())(((()))())))()))((())())())))))))))(()()(((())))))(())()()))((())()))(()(()))((()(()((((()(()(((()))))()))(()(()))())())()()(((())())(((()))))(((()())))()(()())()())()))())())(()()(((()()))(())(((()((())((((())))))((()))))(()((()(())))()(())((()(())((()(()())())))()))))(())())(()())()()()((())))((()()))()()()((((()())))))()))))()))())()((()(())()()(())(((()((()))(()(()()))(()))()))))))))))))(()()))(((())((()(((()()()(()())((((()(()()()))())))())(()())))(()((((()))((()()())(((()))()())(()(()((()(()))))(())()()((()())((()(()(()))((()((()())(((()(((((()()()))(()()(()(((()(()())()()()))((()(()())))())(()(()))(())()())))()()()))()())(()(((((()))()()((((()()()()))()()(()((()))(()))))))))))()))()(()((((((())(()))()((())))(((((())))))(()))))()()(()()()(((((()))()())()((((()()))()(())())))(((()((())))))))))(()()()((()))(()())((())))()()((()())))()()(()))))))))()(((()(()))()())((((((())))(((()(()())())))(())())())()()((((()(()(((())(()()(((((()))(()(())()))))))()))()())))()()(()))(((()))()())))((())(((()()))((((((())))(((())()()(()((()))())(()((()()(((())())()))()()())())(()()((((((((())))()(((())(()))))()()())()(())))(((((()())(((())()()))))()((())())(())()(()(()()((()))()(()(((()))))()()())(())()()()(((()((()()()(()())())(())()(((((()())(())()((((()()()))()((())()((()(()(((()(()))()())())()())()(()()(()(((()))()(())(()())(())((())()((()()())(()))))()(()()))))((())()()((()((()()(()((()()())(())))))())))()))))(((((()(()())(()))((()))()(()())())())))()(()()(()((())))))()()))((())((((()))))())((()))())((())((()(()((()))()()()))()((((((())((((((()((((((((()))(()(((()(((((((((())(())())()())))))))())())))()))(()))))()(()))(())))()()()((()()))(())(()))(()()(()())))()(()()()()())))(())((((()))(((((())(()(((((())((()((((()))(((((()))(()())()))))())()))()(()()))((((()))()())(())))()((())))(((((()()((()()((()))))()((())())()))(((((((((()((())((((())()())))(())())()))())))())()))()(()()(()))(()()()((())((()))())))()(()())()(((((((()))))(()()()((()(())))())()))((())())(()(()(())()()())))))(()()()))())()))()())(((())(())))()(())())))()((()(()(())()()()((()))()))((())((((()((((((()()()))()))())())))))()(())(()())))()(((()())(((())))((())()()))((())())()()(()()())()))())(((()((()(((()())(()(())(((())))()))))))())()((((((()))))))()(()))()))())))())((((())(())()(())()))()))((((((((()()(())())((((())))((((()(())()()(())()))())()))(((()((()))()(((((()()()))))(()(()())))(((()(((()(())())((((())(()((()((()(()()(()()))()))()()))()))))))())()(())())))(((())))((()))((()(())())((())))((()))()))(((()))))(()())()())())()())))())))(())))(())())()((()())()()))((()()())(((((()())))())))()()()((((((())())()((())()))(()))()(()())()())(())()())((()((())(())()()()()((())(()())()()((())))()(((()(()(((((()(())))()(()))()(()))()))())()))()())()(()))))()()())(((())((()((())(()(()))()((()))))))(())(()(())())()()((())((())((((())))))(()()())(()()())(())())(((()()(())(())))()()))(())))))())(())()(((())())))((()(((())))(()((())()))()))((()()())()(((((())((((())))(())()()((()()(()()))(()((()))((())())))))))()())))())())((()(()()()()()))))()))((())(((((()())(()))((())))((()(())))))))))(((())(()(())(()(())((()((()))()((())())()())()((()(())())()(((()()((()(()())))))())((())(((()())(((()(()((())((()(((())(()()((((((()))())))())(()(()(()()())())((()))((())(())(())())))()(()())()))())(())((((())()((())))))(()()((())(((((()))()()))()()())(()(((()))())()()()))(((()()))(()(()((())(())))()()((((()()))()(())()())()()()()()(()()))(((())(((()()()((((((((((()()()(((()))))))())))()(((((((()((((((((()))()(((())())())())((((((()()))(()))()))))(())()())))())(()))(((())()()()((()()((())(()))((()(()())))()(()((()((())()()()()(())()()((())())())()()))()()))))((()()((())(((())(())())))((())())())(()))))())))))()((()(()(()))))()))((((())((())())(()))))()((()))(())((()()))()()((())(())())))(())))))()()(()())((()(())(((()((())))()())))()))()))))(())()(()))((()()()()))(())))(()()(())(((()(((()()))()((()))())()))(()(()))())))))))()((()(()))(((())())(())(()))(())(()((()))))))(()())(()()()(((()(((((()))((()))))(()))(())())(((()(()())(()()()()))())(()((()(()))()))())))(((()(()))))()))(()()((())())(()()())((()))(())))()()))(())))())))(()((())((()))((()))))())()()()((((((())((())()))(()))(())(())())))()())()((())))((()()())(()))(((()))())())))(())(())())()())()))((((()()()()))(())))((((())))(())(()((((()))())()))))))()()()))())))()((())))))((())())))()()(()()(()(()()()())((((())))(())(((())(()(()((((())(()()()(()(()((())(())(()())((((()((()((((((()((((())(((()())()((((()((())()(()(()(()((()()()(()(()())(((()(())(()(())(())(()))()((((((((()()(())))(()()(((())()(()(((((()())((()(())()())(((()(()(())()((((((((())()((()()((((())(((()(()((()((((()((((()(()(())())()(((()()))))))(()(((())()(((()())))((()))))(()()))))(()))))))((())())((())))()()()(()((()))()))()))()()()()()))(((((((()((()))((())()(()(()))()((((((((((((()(())))))(()())))()(()()(()(()()))))(((((()()((())()))())()()()))(())())()())()()((()()(()(()()(()))))))()()))(()()((()))))()((()()()())))(((()(((()()(())(())(()(((())(()((()(()))(()()((())()(()()())()))))))(()()((())((()())))(())(()))()(()))(()))()))()(())()(()())))(()))(()()(((()))))())))))((())())))))()()()))(()))((()())())()()))(((())((()((())()(()))()((()))()(())))))))()()())())))(()()(())(()))(())))))()(()))(()()))))))))((((()()()()()))(()))((()((())))(()())(((()()()(())))))()))()())())(()()()))))))((()())))((())))(())()((()))()(()())())))))(((()()(()(())()())(((((()))((()(())(())))))))()()))))))((()((((()()))()))(()()))(()()(())))))(((()()))(()())))(())()((()((()(((()()()()((()())())(()(((((((()((((())(()((((()()(())))))(()())))))(()())))())(())))((()(()))(()())(((())))((((())))))((()))()(((((((())())())((())))))))(()))))))))()((()()())((())))(())))((()(((()(())(())))()()()()))(())(()(())()())(())))()())((()((()((()()((())())))(()((())()()))()))((()()(()))(((((((()))((())((())((())()()((((((((()())()()()))(()()(((()(())()))()))()))()()(()(((((()))))((())(((()))()((((((((()()()()(()))()(()))()(())))))))()((((()()((()(())()((()))((()()(()()))))))))))(())(()))()()((((())))()((())(()((()((()(())()))()()((((()))))()))())))))())(((()()))()))()(()))(()))()((()((((((())())))()))()((())(()(())))))))()))(()()()())())()))((()))(()((()((()())))))((((())()()())(())())()((()((()())()())()(()))))((()())))()))()()))))()((())))())(()))()))(()((())(()))))()()))(()()((((()()))(((()()())(()(()(((()))())))((((()())()()()(())()()()((()))))((()()(()()))()())))(((((()(())())))))(()))))())))(())())()))))((()))))))(((())(((())()(((())))(()))()())(((()(()(((()))))()(()()(())())))))())())()()((())))()(())((()))((())(()())(()()()(()()())((())())))))((()(()())()()))))(()()(()()()(()()))((((((()))(()())(())(())())((())(()(()))((()()(()))))()))()(())))())))())(()((())))((())(()()()(()))((()((((((()())()()))))()))((()((())()))()((((()()()(((())())))()()()())())())(()())()))()(())(())()))())((()(((((()))(())(((((()))(()())(()(()(())()((()(()(()))()(()))))()(((())(()((((((()))(()(((()()())()())((()())))((()((()())()((((((())()))(()))))(()()()()))())())((((((((())((((()()()))(())()()))(()(()()(()(()))))(()))(()()()(())()()(())(()))())((()()((()(()))()))))())((()())())(((((()(()()))((()()()))()()(()(()(((()())(((((((((()))()())(()(()(())(((((()()))))(()())(()())())(())))))((()))())(((()((((()))()))(()(()(((()()(()(((()()))(())))((((()(()()))))((((()()())()))())()))))((())((((((())()()))()))()(((()((())(()((((()())())((((((((((()(((((()())()()(()))))))()((((())())(((()()((((()()())()(((((())))()))(())())(((()(((())()))()()()()(())))(()(((()(()))())))()(((()()()()()(()(((()(((()))()(())(())()()))()((()))))))()(((((()(()()((())(())((())))()(()())(())))())((())(()(()()(((())((()()(()()((()))))())))()(()))()))))))())())))((((((()())))(())(()))()()))()(())))))))((()))(()()()()))()())()()()()))()()())))))))((())(())))(()))(())((()())))(()(((()))((((())())))(())((())())))))(((()())(())()(())))((()()()((()(()))()))(())))((()(()()((()()()))((()))((()))()))(()())()()(((((((((()(()))()())()((())((((((((()(())()(((()((())()((((((((()))())))(()((()((())())())((()()())))(()(()((((((()))))((((())))((()()(())()())()()())(())(((()(()()(())(((())((((())()()(()()(((())()(())((()(()(((()(()())))()))((()()())(())))))(()(()))()))()(()))))(()((()))()())(())(())(()))((()())()))())()())((((()))))())())(((()))(((()()((()((())(())()()))))(((()((((()(((((((((())()()()(())((()(()()(()()(()()(())()())(((((()))))()(())(((()((((()())(()(((()))))()))())((((()()((()(()))))((())(())(()(()))()()(((()))(((((((((()())))((())()(()(((((((()))))))()()(())(((()(()())()()))((()()))((((()(())())))((()())))))()))))))))()()(((())())((()))())((())((()()))())((((((((())((()((())())))))()()))))))()()(())))))()))()()(((()))))(())((((()()()()))((()((((()()(())(((((()())()))))))())())()((((((((((()))()))((()))(())())(()(()(())((()()(()((())(())((((())(()()(()((()((()(((((()(()()((((())(())())(()()())()())((()(())()(())()))))"));
        System.out.println(longestValidParentheses2("()()"));

    }

    public static int longestValidParentheses2(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

    public static int longestValidParentheses(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int n = s.length();
        int maxLen = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < n - 1; i++) {
            if ((n - i) < maxLen) {
                break;
            }
            int len;
            if (i != 0 && chars[i] == chars[i - 1]) {
                len = checkParentheses(chars, i, maxLen);
            } else {
                len = checkParentheses(chars, i, n);
            }
            if (maxLen < len) {
                maxLen = len;
            }
        }

        return maxLen;
    }

    private static int checkParentheses(char[] chars, int start, int end) {
        if (chars[start] != '(') {
            return 0;
        }

        boolean popped = false;
        Stack<Pair> stack = new Stack<>();
        for (int i = start; i < end; i++) {
            char c = chars[i];
            if (c == '(') {
                stack.push(new Pair(c, i));
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return i - start;
                } else {
                    stack.pop();
                    popped = true;
                }
            } else {
                return 0;
            }
        }

        if (stack.isEmpty()) {
            return end - start;
        } else if (popped) {
            int maxLength = 0;
            int last = end;
            while (!stack.isEmpty()) {
                int value = stack.pop().v;
                int length = last - value - 1;
                last = value;
                if (maxLength < length) {
                    maxLength = length;
                }
            }
            int length = last - start;
            if (maxLength < length) {
                maxLength = length;
            }
            return maxLength;
        } else {
            return 0;
        }
    }

    public static class Pair {
        char c;
        int v;

        Pair(char c, int v) {
            this.c = c;
            this.v = v;
        }
    }
}
