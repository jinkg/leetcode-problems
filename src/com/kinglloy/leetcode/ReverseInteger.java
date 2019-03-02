package com.kinglloy.leetcode;

/**
 * 7. Reverse Integer
 * Easy
 * <p>
 * 1943
 * <p>
 * 2861
 * <p>
 * Favorite
 * <p>
 * Share
 * Given a 32-bit signed integer, reverse digits of an integer.
 * <p>
 * Example 1:
 * <p>
 * Input: 123
 * Output: 321
 * Example 2:
 * <p>
 * Input: -123
 * Output: -321
 * Example 3:
 * <p>
 * Input: 120
 * Output: 21
 */
public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
        System.out.println(reverse(123));
    }

    public static int reverse(int x) {
        int signal = x >= 0 ? 1 : -1;
        x *= signal;
        long result = 0;
        for (int b = x % 10; x > 0; x /= 10, b = x % 10) {
            result *= 10;
            result += b;
        }
        return (int) result == result ? signal * (int) result : 0;
    }
}
