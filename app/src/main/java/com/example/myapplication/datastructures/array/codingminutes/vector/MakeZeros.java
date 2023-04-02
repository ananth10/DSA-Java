package com.example.myapplication.datastructures.array.codingminutes.vector;


import com.google.gson.Gson;

import java.util.ArrayList;

import kotlin.Pair;


public class MakeZeros {

    public static void main(String[] args) {
//        makeZeros();
        makeZeros1();
    }

    static void makeZeros() {
        int matrix[][] = {
                {5, 4, 3, 9},
                {2, 0, 7, 6},
                {1, 3, 4, 0},
                {9, 8, 3, 4}
        };
        printMatrix(matrix);

        int length = matrix.length;
        ArrayList<Pair<Integer, Integer>> listPair = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if (matrix[i][j] == 0) {
                    for (int l = 0; l < length; l++) {
                        listPair.add(new Pair<>(i, l));
                    }
                    for (int k = 0; k < length; k++) {
                        listPair.add(new Pair<>(k, j));
                    }
                    break;
                }
            }
        }
        for (int m = 0; m < listPair.size(); m++) {
            Pair<Integer, Integer> pair = listPair.get(m);
            matrix[pair.getFirst()][pair.getSecond()] = 0;
        }

        printMatrix(matrix);
    }


    static void makeZeros1() {
        int matrix[][] = {
                {5, 4, 3, 9},
                {2, 0, 7, 6},
                {1, 3, 4, 0},
                {9, 8, 3, 4}
        };
        printMatrix(matrix);

        int length = matrix.length;
        ArrayList<Integer> rows = new ArrayList<>();
        ArrayList<Integer> cols = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                    break;
                }
            }
        }


        for(int row:rows){
            for (int col=0;col<length;col++){
                matrix[row][col]=0;
            }
        }
        for(int col:cols){
            for (int row=0;row<length;row++){
                matrix[row][col]=0;
            }
        }
        printMatrix(matrix);
    }

    static void printMatrix(int mat[][]) {
        System.out.println();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
