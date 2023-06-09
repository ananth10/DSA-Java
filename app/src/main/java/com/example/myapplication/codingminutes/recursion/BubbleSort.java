package com.example.myapplication.codingminutes.recursion;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int arr[] = {5, 4, 3, 2, 1};
        int n = arr.length;
        System.out.println(Arrays.toString(bubbleSort(arr, n, 0)));

    }

    static int[] bubbleSort(int[] arr, int n, int j) {
        //base case
        if (n == 1) {
            return arr;
        }
        if (j == n - 1) {
            j = 0;
           return bubbleSort(arr, n - 1, j);
        }
        if (arr[j] > arr[j + 1]) {
            int temp = arr[j];
            arr[j] = arr[j + 1];
            arr[j + 1] = temp;
        }
        return bubbleSort(arr, n , j+1);
    }
}
