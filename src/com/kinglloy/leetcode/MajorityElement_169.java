package com.kinglloy.leetcode;

public class MajorityElement_169 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 3, 3, 3};
        System.out.println(new MajorityElement_169().majorityElement(nums));
    }

    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int n : nums) {
            if (count == 0) {
                candidate = n;
            }
            count += candidate == n ? 1 : -1;
        }
        return candidate;
    }
}
