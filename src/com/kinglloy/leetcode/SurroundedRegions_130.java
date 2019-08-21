package com.kinglloy.leetcode;

public class SurroundedRegions_130 {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}};

        new SurroundedRegions_130().solve(board);
        for (char[] chars : board) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(chars[j] + " ");
            }
            System.out.println();
        }
    }

    public void solve(char[][] board) {
        if (board == null || board.length < 3) {
            return;
        }
        int boardLen = board[0].length;
        for (int i = 0; i < boardLen; i++) {
            if (board[0][i] == 'O') {
                replace(board, 0, i);
            }
            if (board[board.length - 1][i] == 'O') {
                replace(board, board.length - 1, i);
            }
        }

        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                replace(board, i, 0);
            }
            if (board[i][boardLen - 1] == 'O') {
                replace(board, i, boardLen - 1);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void replace(char[][] board, int i, int j) {
        if (board[i][j] != 'O') {
            return;
        }
        board[i][j] = 'A';

        if (i > 0) {
            replace(board, i - 1, j);
        }

        if (i < board.length - 1) {
            replace(board, i + 1, j);
        }

        if (j > 0) {
            replace(board, i, j - 1);
        }

        if (j < board[0].length - 1) {
            replace(board, i, j + 1);
        }
    }
}
