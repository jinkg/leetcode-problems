package com.kinglloy.leetcode;

public class ValidSudoku_36 {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        for (char[] r : board) {
            if (!isValid(r)) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            char[] col = new char[9];
            for (int j = 0; j < 9; j++) {
                col[j] = board[j][i];
            }
            if (!isValid(col)) {
                return false;
            }
        }

        int x = 0;
        int y = 0;
        for (int i = 0; i < 9; i++) {
            char[] col = new char[9];

            for (int j = 0; j < 3; j++) {
                System.arraycopy(board[j + y * 3], x * 3, col, j * 3, 3);
            }
            x++;
            if (x % 3 == 0) {
                x = 0;
                y++;
            }

            if (!isValid(col)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValid(char[] row) {
        if (row == null || row.length == 0) {
            return false;
        }
        int[] l = new int[10];
        for (char c : row) {
            if (c >= '1' && c <= '9') {
                l[c - '0']++;
                if (l[c - '0'] > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
