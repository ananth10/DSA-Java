package com.example.myapplication.codingminutes_levelup.sorting_searching;


/**
 * Write a function that takes input an array of distinct integers, and returns kth smallest in the array.
 * */
public class QuickSelect {
    public static void main(String[] args) {
        int[] a = {10, 5, 2, 0, 7, 6, 4};
        int k = 1;
        int result = quickSort(a, 0, a.length - 1, k);
        System.out.println("Result:" + result);
    }

    static int partition(int[] a, int s, int e) {
        int i = s - 1;
        int pivot = a[e];

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

    static int quickSort(int[] a, int s, int e, int k) {
        int p = partition(a, s, e);
        if (p == k) {
            return a[p];
        } else if (k < p) {
            return quickSort(a, s, p - 1, k);
        } else {
            return quickSort(a, p + 1, e, k);
        }
    }
}
