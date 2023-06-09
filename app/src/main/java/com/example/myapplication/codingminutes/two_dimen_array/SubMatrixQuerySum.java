package com.example.myapplication.codingminutes.two_dimen_array;

import com.google.gson.Gson;

public class SubMatrixQuerySum {

    public static void main(String[] args) {
        int M = 4; //rows
        int N = 5; //columns
        int matrix[][] = {
                {1, 2, 3, 4, 6},
                {5, 3, 8, 1, 2},
                {4, 6, 7, 5, 5},
                {2, 4, 8, 9, 4}
        };
        int aux[][] = new int[M][N];
        preprocessMatrix(matrix, aux, M, N);

        preprocess1(matrix,aux,M,N);
    }

    static void preprocessMatrix(int matrix[][], int aux[][], int M, int N) {

        //Copy first row of mat[][] to aux[][]
        for (int col = 0; col < N; col++) {
            aux[0][col] = matrix[0][col];
        }

        //Do column wise sum of the matrix and store it.
        for (int row = 1; row < M; row++) {
            for (int col = 0; col < N; col++) {
                aux[row][col] = matrix[row][col] + aux[row - 1][col];
            }
        }

        // Do row wise sum
        for (int row = 0; row < M; row++) {
            for (int col = 1; col < N; col++) {
                aux[row][col] += aux[row][col - 1];
            }
        }

        printMatrix(aux, M, N);
        int tli = 2, tlj = 2, rbi = 3, rbj = 4;
        sumQuery(aux, tli, tlj, rbi, rbj);
    }

    static void preprocess1(int matrix[][], int aux[][], int m, int n) {
        //base case
        aux[0][0] = matrix[0][0];

        for (int col = 1; col < n; col++) {
            aux[0][col] = matrix[0][col] + aux[0][col - 1];
        }

        for (int row = 1; row < m; row++) {
            aux[row][0] = matrix[row][0] + aux[row - 1][0];
        }

        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                aux[row][col] = matrix[row][col] + aux[row - 1][col] + aux[row][col - 1] - aux[row - 1][col - 1];
            }
        }

        printMatrix(aux, m, n);
    }


    static void sumQuery(int aux[][], int tli, int tlj, int rbi, int rbj) {

        // result is now sum of elements
        // between (0, 0) and (rbi, rbj)
        int res = aux[rbi][rbj];

        // Remove elements between (0, 0)
        // and (tli-1, rbj)
        if (tli > 0)
            res = res - aux[tli - 1][rbj];

        // Remove elements between (0, 0)
        // and (rbi,tlj-1)
        if (tlj > 0)
            res = res - aux[rbi][tlj - 1];

        if (tli > 0 && tlj > 0)
            res = res + aux[tli - 1][tlj - 1];

        System.out.println("RESULT::" + res);
    }

    static void printMatrix(int mat[][], int m, int n) {
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print(mat[row][col] + " ");
            }
            System.out.println(" ");
        }
    }
}
