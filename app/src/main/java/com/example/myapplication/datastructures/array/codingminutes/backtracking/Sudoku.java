package com.example.myapplication.datastructures.array.codingminutes.backtracking;

public class Sudoku {

    public static void main(String[] args) {
        int[][] mat = {{5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}};
        int n = mat.length;
        int row = 0;
        int col = 0;
        solveSudoku(mat, n, row, col);
    }

    static boolean solveSudoku(int[][] mat, int n, int row, int col) {
        //base case
        if (row == n) {
            printSudoku(mat, n);
            return true;
        }
        //recursive case
        //check column has reached the end, then increase row
        if (col == n) {
            return solveSudoku(mat, n, row + 1, 0);
        }
        //skip already filled cell
        if (mat[row][col] != 0) {
            return solveSudoku(mat, n, row, col + 1);
        }

        //check and put the number
         //cell to be filled
        //try out all possibilites
        for (int num = 1; num <= n; num++) {
            if (isSafeToPutNumber(mat, n, num, row, col)) {
                mat[row][col] = num;
                boolean solveSubProblems = solveSudoku(mat, n, row, col + 1);
                if (solveSubProblems) {
                    return true;
                }
            }
        }

        // if no option works, backtracking
        mat[row][col] = 0;
        return false;
    }

    static boolean isSafeToPutNumber(int[][] mat, int n, int num, int row, int col) {
        //check row and columns
        for (int k = 0; k < n; k++) {
            if (mat[k][col] == num || mat[row][k] == num) {
                return false;
            }
        }

        //check sub grids
        int sx = (row / 3) * 3;
        int sy = (col / 3) * 3;
        for (int x = sx; x < sx + 3; x++) {
            for (int y = sy; y < sy + 3; y++) {
                if (mat[x][y] == num) {
                    return false;
                }
            }
        }


        return true;
    }

    static void printSudoku(int[][] mat, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
