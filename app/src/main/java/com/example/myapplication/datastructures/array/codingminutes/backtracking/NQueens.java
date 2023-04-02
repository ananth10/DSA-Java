package com.example.myapplication.datastructures.array.codingminutes.backtracking;

public class NQueens {

    public static void main(String[] args) {
      int[][] board = new int[4][4];
      int n = board.length;
      solveNQueen(board,n,0);
    }

    static boolean canPlaceQueen(int[][] board, int n, int row, int col) {
        //check all rows above the given row and same column
        for (int i = 0; i<row; i++) {
            if (board[i][col] == 1) {
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

    static boolean solveNQueen(int[][] board, int n, int row) {
        //base case
        if (row==n) {
            printBoard(board, n);
            return true;
        }
        //recursive case
        for (int col = 0; col < n; col++) {
            if (canPlaceQueen(board, n, row, col)) {
                board[row][col] = 1;
                boolean success = solveNQueen(board, n, row + 1);
                if(success){
                    return true;
                }
                //back tracking code below
                board[row][col] = 0;
            }
        }
        return false;
    }

    static void printBoard(int[][] board, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
