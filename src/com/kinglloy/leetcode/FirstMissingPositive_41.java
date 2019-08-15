package com.kinglloy.leetcode;

public class FirstMissingPositive_41 {
    public static void main(String[] args) {
        int[] in = new int[]{-1, 6, 3, 2, 8, 11, 5, 0};
        int[] out = test(in);

        for (int i1 : out) {
            System.out.println(i1);
        }
    }

    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        int n = nums.length;

        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0 && nums[i] < n) {
                while ((nums[i] > 0 && nums[i] < n) && nums[i] != i && nums[i] != nums[nums[i]]) {
                    int t = nums[i];
                    nums[i] = nums[nums[i]];
                    nums[t] = t;
                }
            }
        }

        for (int i = 1; i < n; ++i) if (nums[i] != i) return i;

        if (nums[0] == n) return n + 1;
        else return n;
    }

    private static int[] test(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0 && nums[i] < n) {
                while ((nums[i] >= 0 && nums[i] < n) && nums[i] != i && nums[i] != nums[nums[i]]) {
                    int tmp = nums[i];
                    nums[i] = nums[nums[i]];
                    nums[tmp] = tmp;
                }
            }
        }
        return nums;
    }
}
