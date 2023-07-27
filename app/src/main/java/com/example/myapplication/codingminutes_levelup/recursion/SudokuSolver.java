package com.example.myapplication.codingminutes_levelup.recursion;

/**
 * Sudoku Solver
 * ------------
 * Given a partially filled sudoku matrix of 9x9, with a function to fill the matrix using sudoku rules
 * <p>
 * Input:
 * 2D matrix
 * <p>
 * output:
 * Solved 2D matrix
 */
public class SudokuSolver {

    public static void main(String[] args) {
        int[][] board = {{5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}};
        int n = 9;
        if (!solveSudoku(board, n, 0, 0)) {
            System.out.println("No solution exist");
        }
    }

    private static boolean solveSudoku(int[][] board, int n, int row, int col) {
        //base case
        if (row == n) {
            printBoard(board);
            return true;
        }
        if (col == n) {
            return solveSudoku(board, n, row + 1, 0);
        }
        //skip the prefilled cell
        if (board[row][col] != 0) {
            return solveSudoku(board, n, row, col + 1);
        }
        //recursive case
        for (int k = 1; k <= n; k++) {
            //is it safe to place the number or not
            if (CanPlaceThisNumber(board, n, row, col, k)) {
                board[row][col] = k;
                boolean solveSubProblem = solveSudoku(board, n, row, col + 1);
                if (solveSubProblem) {
                    return true;
                }
            }
        }
        //if no option works then put back 0 and tell to previous call
        board[row][col] = 0;
        return false;
    }

    private static boolean CanPlaceThisNumber(int[][] board, int n, int row, int col, int k) {
        //check row and column
        for (int i = 0; i < n; i++) {
            if (board[i][col] == k || board[row][i] == k) { //check given number already present in the position
                return false;
            }
        }

        int sx = (row / 3) * 3; //sx = (row/3)*3
        int sy = (col / 3) * 3; //sy = (col/3)*3
        //check sub grid
        for (int i = sx; i < sx + 3; i++) {
            for (int j = sy; j < sy + 3; j++) {
                if (board[i][j] == k) {
                    return false;
                }
            }
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
}
