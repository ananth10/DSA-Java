package com.example.myapplication.datastructures.array.codingminutes.divide_conquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 1, 9, 7, 8};
        int start = 0;
        int end = arr.length-1;
        mergeSort(arr, start, end);
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
        System.out.println(Arrays.toString(arr));
    }

    static int[] merge(int[] arr, int s, int e) {
        int i = s;
        int mid = (s + e) / 2;
        int j = mid + 1;
        List<Integer> list = new ArrayList<>();
        while (i <= mid && j<=e) {
            if (arr[i] < arr[j]) {
                list.add(arr[i]);
                i++;
            } else {
                list.add(arr[j]);
                j++;
            }
        }

        //copy remaining element from left array add to list
        while (i <= mid) {
            list.add(arr[i++]);
        }
        //copy remaining element from right array add to list
        while (j <= e) {
            list.add(arr[j++]);
        }
        //move all elements into original array
        int k = 0;
        for (int m = s; m<=e; m++) {
            arr[m] = list.get(k++);
        }
        return arr;
    }
}
