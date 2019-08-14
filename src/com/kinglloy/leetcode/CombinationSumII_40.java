package com.kinglloy.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumII_40 {
    public static void main(String[] args) {
        List<List<Integer>> r = combinationSum(new int[]{2, 3, 5}, 7);
        System.out.println(r);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        return combinationSum(candidates, 0, candidates.length, target);
    }

    private static List<List<Integer>> combinationSum(int[] candidates, int start, int end, int target) {
        boolean hasMin = false;
        boolean hasEqual = false;
        int equal = 0;
        for (int i = start; i < end; i++) {
            int c = candidates[i];
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
            for (int i = start; i < end; i++) {
                int c = candidates[i];
                List<List<Integer>> r = combinationSum(candidates, i + 1, end, target - c);
                for (List<Integer> l : r) {
                    l.add(0, c);
                    l.remove((Integer) 0);
                    ans.add(l);
                }
            }
            ans = removeDuplicate(ans);
            return ans;
        } else if (hasEqual) {
            List<List<Integer>> ans = new LinkedList<>();
            ans.add(new LinkedList<>(Collections.singletonList(equal)));
            return ans;
        } else {
            return new LinkedList<>();
        }
    }

    private static List<List<Integer>> removeDuplicate(List<List<Integer>> ans) {
        List<List<Integer>> out = new ArrayList<>();
        for (List<Integer> i : ans) {
            Collections.sort(i);
        }
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
