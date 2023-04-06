package com.example.myapplication.datastructures.array.codingminutes.backtracking;

public class NQueensWays {

    public static void main(String[] args) {
        int[][] board = new int[4][4];
        int n = board.length;
        int count = findNQueenWays(board,n,0);
        System.out.println(count);
    }

    static int findNQueenWays(int[][] board, int n, int row) {
        //base case
        if (row == n) {
            return 1;
        }

        //recursive case
        int count = 0;
        for (int col = 0; col < n; col++) {
            if (canPlaceQueen(board, n, row, col)) {
                board[row][col] = 1;
                count += findNQueenWays(board, n, row + 1);
                board[row][col] = 0;
            }
        }
        return count;
    }

    static boolean canPlaceQueen(int[][] board, int n, int row, int col) {
        //check all left diagonal from the given coordinates that there should not be any queen which 1

        int i = row;
        int j = col;

        while (i >= 0 && j >= 0) {
            if (board[i][j] == 1) {
                return false;
            }
            i--;
            j--;
        }

        //check all right diagonal from the given coordinates that there should not be any queen which 1

        i = row;
        j = col;
        while (i >= 0 && j < n) {
            if (board[i][j] == 1) {
                return false;
            }
            i--;
            j++;
        }

        //check all previous row in the same colum from the given row and col, there should not be any queen which 1

        for (int k = 0; k < row; k++) {
            if (board[k][col] == 1) {
                return false;
            }
        }

        return true;
    }
}
