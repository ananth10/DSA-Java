package com.example.myapplication.codingminutes_levelup.sorting_searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {
    public static void main(String[] args) {
        int[] a = {5, 3, 6, 1, 7, 4, 9, 18, 11};
        mergeSort(a, 0, a.length - 1);
        System.out.println("Result: "+ Arrays.toString(a));
    }

    static void mergeSort(int[] arr, int s, int e) {
        //base case
        if (s >= e) {
            return;
        }
        //recursive case
        int mid = (s + e) / 2;
        mergeSort(arr, s, mid);
        mergeSort(arr, mid + 1, e);
        merge(arr, s, e);
    }

    static int[] merge(int[] arr, int s, int e) {
        int i = s;
        int mid = (s + e) / 2;
        int j = mid+1;
        List<Integer> list = new ArrayList<>();

        while (i <= mid && j <= e) {
            if (arr[i] < arr[j]) {
                list.add(arr[i]);
                i++;
            } else {
                list.add(arr[j]);
                j++;
            }
        }
        //if any elements left in the left array, add it to list
        while (i <= mid) {
            list.add(arr[i++]);
        }

        //if any elements left in the right array, add it to list
        while (j <= e) {
            list.add(arr[j++]);
        }

        int m = 0;
        //move all element to original array
        for (int k = s; k <= e; k++) {
            arr[k] = list.get(m++);
        }

        return arr;
    }
}
