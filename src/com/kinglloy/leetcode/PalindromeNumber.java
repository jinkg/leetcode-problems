package com.kinglloy.leetcode;

/**
 * 9. Palindrome Number
 * Easy
 * <p>
 * 1268
 * <p>
 * 1228
 * <p>
 * Favorite
 * <p>
 * Share
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 * <p>
 * Example 1:
 * <p>
 * Input: 121
 * Output: true
 * Example 2:
 * <p>
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 * <p>
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * Follow up:
 * <p>
 * Coud you solve it without converting the integer to a string?
 */
public class PalindromeNumber {

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }


    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }

        int xCopy = x;
        int revert = 0;
        while (xCopy > 0) {
            int i = xCopy % 10;
            revert = revert * 10 + i;
            xCopy /= 10;
        }

        System.out.println(revert);
        return x == revert;
    }
}
