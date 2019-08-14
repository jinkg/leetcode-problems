package com.kinglloy.leetcode;

public class DivideTwoIntegers_29 {
    public static void main(String[] args) {
        System.out.println(divide(2147483647, 1));
    }

    public static int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return 0;
        }
        if (dividend == 0) {
            return 0;
        }

        int sign = ((dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0)) ? 1 : -1;
        if (dividend < 0) {
            dividend = -dividend;
        }
        if (dividend == Integer.MIN_VALUE) {
            dividend = Integer.MAX_VALUE;
        }
        if (divisor < 0) {
            divisor = -divisor;
        }
        int i = 0;
        int sum = divisor;
        while (dividend >= sum) {
            i++;
            sum += divisor;
            while (sum + sum + sum < dividend && sum + sum + sum > 0) {
                sum = sum + sum + sum;
                i += i;
            }
            if (sign > 0 && i == Integer.MAX_VALUE) {
                break;
            }
        }
        if (sign > 0) {
            return i;
        } else {
            return -i;
        }
    }
}
