package com.example.myapplication.datastructures.array.codingminutes.divide_conquer;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 0, 7, 6, 4};
        System.out.println("Unsorted Array:"+Arrays.toString(arr));
        int s = 0;
        int e = arr.length - 1;
        quickSort(arr,s,e);
        System.out.println("Sorted Array:"+Arrays.toString(arr));
    }

    static int partition(int[] arr, int s, int e) {
        //select pivot element
        int pivot = arr[e];
        int i = s - 1;

        for (int j = s; j <= e; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[e];
        arr[e] = temp;
        return i + 1;
    }

    static void quickSort(int[] arr, int s, int e) {
        //base  case
        if (s >= e) {
            return;
        }
        //recursive case
        int pivotIndex = partition(arr, s, e);
        quickSort(arr, s, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, e);
    }
}
