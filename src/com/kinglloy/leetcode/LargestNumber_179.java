package com.kinglloy.leetcode;

import java.util.Arrays;

public class LargestNumber_179 {
    public static void main(String[] args) {
        int[] nums = new int[]{824, 938, 1399, 5607, 6973, 5703, 9609, 4398, 8247};
        System.out.println(new LargestNumber_179().largestNumber(nums));
    }

    public String largestNumber(int[] nums) {
        String[] list = new String[nums.length];
        for (int i = 0; i < list.length; i++) {
            list[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(list, (o1, o2) -> {
            if (o1 == null && o2 == null) {
                return 0;
            }
            if (o1 == null) {
                return 1;
            }
            if (o2 == null) {
                return -1;
            }

            if (o1.equals(o2)) {
                return 0;
            }

            String c = o1 + o2;
            String d = o2 + o1;

            return d.compareTo(c);
        });
        if (list[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String n : list) {
            sb.append(n);
        }
        return sb.toString();
    }
}
