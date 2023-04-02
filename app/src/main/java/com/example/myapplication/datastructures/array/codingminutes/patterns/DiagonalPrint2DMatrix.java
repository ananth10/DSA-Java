package com.example.myapplication.datastructures.array.codingminutes.patterns;

public class DiagonalPrint2DMatrix {

    public static void main(String[] args) {
        int[][] arr = new int[3][3];
        int n = arr.length;

        print2DMatrixCrossDiagonal(arr, n);
    }

    static void print2DMatrixCrossDiagonal(int[][] arr, int n) {
        int row = 0;
        int col = 0;
        while (row < n && col < n) {
            arr[row][col] = 1;
            row++;
            col++;
        }

        row = n-1;
        col = 0;
        while (row>=0 && col < n) {
            arr[row][col] = 1;
            row--;
            col++;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
