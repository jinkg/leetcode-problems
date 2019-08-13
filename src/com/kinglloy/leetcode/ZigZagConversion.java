package com.kinglloy.leetcode;

/**
 * 6. ZigZag Conversion
 * Medium
 * <p>
 * 903
 * <p>
 * 2829
 * <p>
 * Favorite
 * <p>
 * Share
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * <p>
 * Write the code that will take a string and make this conversion given a number of rows:
 * <p>
 * string convert(string s, int numRows);
 * Example 1:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * <p>
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 */
public class ZigZagConversion {

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 4;
        System.out.println(convert(s, numRows));
    }

    public static String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        StringBuilder[] rows = new StringBuilder[Math.min(numRows, s.length())];
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows[i] = new StringBuilder();
        }

        boolean goingDown = false;
        int i = 0;
        for (char c : s.toCharArray()) {
            rows[i].append(c);

            if (i == rows.length - 1 || i == 0) {
                goingDown = !goingDown;
            }
            i += goingDown ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : rows) {
            result.append(sb);
        }
        return result.toString();
    }
}
