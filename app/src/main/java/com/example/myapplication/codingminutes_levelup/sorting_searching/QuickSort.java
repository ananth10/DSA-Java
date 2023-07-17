package com.example.myapplication.codingminutes_levelup.sorting_searching;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] a = {10, 5, 2, 0, 7, 6, 4};
        quickSort(a, 0, a.length - 1);
        System.out.println("Result: " + Arrays.toString(a));
    }

    static int partition(int[] a, int s, int e) {
        int pivot = a[e];
        int i = s - 1;

        for (int j = s; j < e; j++) {
            if (a[j] < pivot) {
                i++;
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        int temp = a[i + 1];
        a[i + 1] = a[e];
        a[e] = temp;
        return i + 1;
    }

    static void quickSort(int[] a, int s, int e) {
        //base case
        if (s >= e) {
            return;
        }
        //recursive case
        int pi = partition(a, s, e);
        quickSort(a, s, pi - 1);
        quickSort(a, pi + 1, e);
    }
}
