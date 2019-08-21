package com.kinglloy.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence_128 {
    public static void main(String[] args) {
        int[] nums = new int[]{2147483646, -2147483647, 0, 2, 2147483644, -2147483645, 2147483645};
        System.out.println(new LongestConsecutiveSequence_128().longestConsecutive(nums));
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int max = 0;
        for (int num : set) {
            if (num == Integer.MIN_VALUE || !set.contains(num - 1)) {
                int m = 1;
                while (num < (Integer.MAX_VALUE - m) && set.contains(num + m)) {
                    m++;
                }
                max = Math.max(max, m);
            }
        }

        return max;
    }
}
