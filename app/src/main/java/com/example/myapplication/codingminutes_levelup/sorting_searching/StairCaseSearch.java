package com.example.myapplication.codingminutes_levelup.sorting_searching;



import kotlin.Pair;

/**
 * You are given a M x N matrix which is row wise and column wise sorted.
 * You have to search the index of a given integer K in the matrix.
 * */
public class StairCaseSearch {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 4, 9},
                {2, 5, 10},
                {6, 7, 11}
        };
        int k = 11;

        Pair<Integer, Integer> pair = stairCaseSearch(arr, k);
        System.out.println("Result:" + pair);
    }

    static Pair<Integer, Integer> stairCaseSearch(int[][] arr, int key) {
        int i = 0;
        int j = arr[0].length - 1;

        while (i < arr.length && j >= 0) {
            int val = arr[i][j];
            if (val == key) {
                return new Pair<>(i, j);
            }
            if (val > key) {
                j--;
            } else {
                i++;
            }
        }
        return null;
    }
}
