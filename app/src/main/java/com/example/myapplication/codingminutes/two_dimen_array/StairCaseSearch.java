package com.example.myapplication.codingminutes.two_dimen_array;

import java.util.HashMap;

import kotlin.Pair;

public class StairCaseSearch {

    public static void main(String[] args) {
        int array[][] = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}
        };

        int rows = 4;
        int columns = 4;
        int key = 50;

//        Pair pair = findStairCase(array, rows, columns, key);
//        System.out.println(pair);

        Pair pair1 = findGivenNumber(array,rows,columns,key);
        System.out.println(pair1);
    }

    static Pair findStairCase(int array[][], int rows, int columns, int key) { //bruteforce approach
        int i = 0;
        int j = 0;
        if (key < array[0][0] || key > array[rows - 1][columns - 1]) {
            return new Pair(-1, -1);
        }
        while (i < rows) {
            System.out.println(array[i][j]);
            if (array[i][j] == key) {
                return new Pair(i, j);
            }
            if (j < columns - 1) {
                j++;
            } else {
                i++;
                j = 0;
            }
        }
        return new Pair(-1, -1);
    }

    static Pair findGivenNumber(int arr[][], int rows, int columns, int key){
        int i = 0;
        int j = columns-1;

        if(key<arr[0][0] || key>arr[rows-1][columns-1]){
            return new Pair(-1, -1);
        }

        while (i<rows){
            while (j>=0){
                int value  = arr[i][j];
                if(value==key){
                    return new Pair(i, j);
                }
                else if(value>key){
                    j--;
                }else{
                    i++;
                }
            }
        }

        return new Pair(-1, -1);
    }
}
