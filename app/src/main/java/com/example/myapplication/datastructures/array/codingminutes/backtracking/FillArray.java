package com.example.myapplication.datastructures.array.codingminutes.backtracking;

public class FillArray {

    public static void main(String[] args) {
      int[] arr = new int[100];
      int n = 5;
      fillArray(arr,n,0,1);
      printArray(arr,n);
    }

    static void fillArray(int[] arr, int n, int index, int val) {
        //base case
        if (index == n) {
            printArray(arr, n);
            return;
        }
        //recursive case
        arr[index] = val;
        fillArray(arr, n, index + 1, val + 1);
        arr[index] = -1*arr[index];
    }

    static void printArray(int[] arr, int n) {
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]+", ");
        }
    }
}
