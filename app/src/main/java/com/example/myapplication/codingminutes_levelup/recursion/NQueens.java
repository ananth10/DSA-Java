package com.example.myapplication.codingminutes_levelup.recursion;

import java.util.Arrays;

/**
 * N-Queens
 * ----------
 * N-Queens is the problem of placing N chess queens on an NxN chess board so that
 * no two queens attack each other.
 * <p>
 * Input:
 * N = 4;
 * <p>
 * Output:
 * 2d matrix with queens
 */
public class NQueens {

    public static void main(String[] args) {
        int[][] board = new int[4][4];
        Arrays.fill(board[0], 0);
        int n = board.length;
        solveNQueens(board, n, 0);
        findAllWaysNQueens(board,n,0);
    }

    static boolean solveNQueens(int[][] board, int n, int row) {
        //base case
        if (row == n) {
            printBoard(board);
            return true;
        }

        //recursive case
        for (int col = 0; col < n; col++) {
            //place the queen
            if (canPlaceQueen(board, n, row, col)) {
                board[row][col] = 1;
                boolean isSuccess = solveNQueens(board, n, row + 1);
                if (isSuccess) {
                    count++;
                    return true;
                }
                //remove the queen
                board[row][col] = 0;
            }
        }
        return false;
    }

    static boolean canPlaceQueen(int[][] board, int n, int row, int col) {
        //check column from row 0 to till passed row
        for (int k = 0; k < row; k++) {
            if (board[k][col] == 1) {
                return false;
            }
        }
        //check left diagonal
        int i = row;
        int j = col;

        while (i >= 0 && j >= 0) {
            if (board[i][j] == 1) {
                return false;
            }
            i--;
            j--;
        }

        //check right diagonal
        i = row;
        j = col;
        while (i >= 0 && j < n) {
            if (board[i][j] == 1) {
                return false;
            }
            i--;
            j++;
        }

        return true;
    }

    static void printBoard(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    //find number of ways can place n queens
    public static int count = 0;
    static void findAllWaysNQueens(int[][] board, int n, int row) {
        //base case
        if (row == n) {
            count++;
            System.out.println("Result: "+count);
            return;
        }

        //recursive case
        for (int col = 0; col < n; col++) {
            //place the queen
            if (canPlaceQueen(board, n, row, col)) {
                board[row][col] = 1;
                findAllWaysNQueens(board, n, row + 1);
                //remove the queen
                board[row][col] = 0;
            }
        }
    }
}
