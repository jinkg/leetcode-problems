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
        String s = "abc";
        int numRows = 2;
        System.out.println(convert(s, numRows));
    }

    public static String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        int sLength = s.length();
        int numColumns = getColumns(s.length(), numRows);
        char[][] map = new char[numRows][numColumns];
        boolean revert = false;
        int index = 0;
        for (int c = 0; c < numColumns; c++) {
            if (revert) {
                for (int r = numRows - 2; r > 0; r--) {
                    if (index >= sLength) {
                        break;
                    }
                    map[r][c] = s.charAt(index++);
                }
                revert = false;
            } else {
                for (int r = 0; r < numRows; r++) {
                    if (index >= sLength) {
                        break;
                    }
                    map[r][c] = s.charAt(index++);
                }
                if (numRows > 2) {
                    revert = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (
                int r = 0;
                r < numRows; r++) {
            for (int c = 0; c < numColumns; c++) {
                if (map[r][c] > 0) {
                    sb.append(map[r][c]);
                }

                System.out.print(map[r][c]);
            }
            System.out.println();
        }
        return sb.toString();
    }

    private static int getColumns(int length, int row) {
        if (row == 1) {
            return length;
        }
        if (row == 2) {
            return (int) Math.ceil(length / 2f);
        }

        return (length / (row + row - 2)) * (row - 1) + Math.max(row, length % (row + row - 2)) - row + 1;
    }
}
