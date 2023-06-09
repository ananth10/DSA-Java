package com.example.myapplication.codingminutes.backtracking;

public class NQueensAllWays {

    public static void main(String[] args) {
        int[][] board = new int[4][4];
        int n = board.length;
        int count = solveNQueen(board, n, 0);
        System.out.println(count);
    }

    static boolean canPlaceQueen(int[][] board, int n, int row, int col) {

        //check previous rows and same column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }

        //check all left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        //check all right diagonal
        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    static int solveNQueen(int[][] board, int n, int row) {
        //base case
        if (row == n) {
            return 1;
        }
        //recursive case
        int ways = 0;

        for (int col = 0; col < n; col++) {
            if (canPlaceQueen(board, n, row, col)) {
                board[row][col] = 1;
                ways += solveNQueen(board, n, row + 1);
                board[row][col] = 0;
            }
        }
        return ways;
    }
}
