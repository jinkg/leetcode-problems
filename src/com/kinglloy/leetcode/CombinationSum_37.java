package com.kinglloy.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum_37 {
    public static void main(String[] args) {
        List<List<Integer>> r = combinationSum(new int[]{2, 3, 5}, 7);
        System.out.println(r);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        boolean hasMin = false;
        boolean hasEqual = false;
        int equal = 0;
        for (int c : candidates) {
            if (c < target) {
                hasMin = true;
            } else if (c == target) {
                hasEqual = true;
                equal = c;
            }
        }

        if (target == 0) {
            hasEqual = true;
        }

        if (hasMin) {
            List<List<Integer>> ans = new LinkedList<>();
            for (int c : candidates) {
                List<List<Integer>> r = combinationSum(candidates, target - c);
                for (List<Integer> l : r) {
                    l.add(0, c);
                    l.remove((Integer) 0);
                    ans.add(l);
                }
            }
            removeDuplicate(ans);
            return ans;
        } else if (hasEqual) {
            List<List<Integer>> ans = new LinkedList<>();
            ans.add(new LinkedList<>(Collections.singletonList(equal)));
            return ans;
        } else {
            return new LinkedList<>();
        }
    }

    private static void removeDuplicate(List<List<Integer>> ans) {
        int n = ans.size();

        List<Integer> needDeleteIndex = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            if (elemEqual(ans.get(i), ans.get(i + 1))) {
                needDeleteIndex.add(i);
            }
        }

        int removedCount = 0;
        for (Integer i : needDeleteIndex) {
            ans.remove(i - removedCount++);
        }
    }

    private static boolean elemEqual(List<Integer> a, List<Integer> b) {
        Collections.sort(a);
        Collections.sort(b);
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
