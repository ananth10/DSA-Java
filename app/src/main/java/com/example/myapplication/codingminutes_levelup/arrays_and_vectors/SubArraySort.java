package com.example.myapplication.codingminutes_levelup.arrays_and_vectors;

import java.util.Arrays;

import kotlin.Pair;

public class SubArraySort {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 8, 6, 7, 9, 10, 11};
        Pair<Integer, Integer> result = subArraySort(arr);
        Pair<Integer, Integer> result1 = subArraySort(arr);
        System.out.println("RESULT:" + result);
        System.out.println("RESULT1:" + result1);
    }

    //Approach 1  - O(nlogn)

    static Pair<Integer, Integer> subArraySort(int[] arr) {
        int[] b;
        b = Arrays.copyOf(arr, arr.length);
        Arrays.sort(b);
        int n = arr.length;
        int i = 0;
        while (i < n && arr[i] == b[i]) {
            i++;
        }
        int j = arr.length - 1;
        while (j >= 0 && arr[j] == b[j]) {
            j--;
        }
        if (i == arr.length)
            return new Pair<>(-1, -1);

        return new Pair<>(i, j);
    }

    //Approach 2 - O(n)

    static Boolean outOfOrder(int[] arr, int i) {
        int x = arr[i];

        if (i == 0)
            return x > arr[1];

        if (i == arr.length - 1)
            return x < arr[i - 1];

        return x > arr[i + 1] || x < arr[i - 1];
    }

    static Pair<Integer, Integer> subArraySort1(int[] arr) {
        int n = arr.length;
        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;
        //find smallest and largest value, so then we can find positions
        for (int i = 0; i < n; i++) {
            if (outOfOrder(arr, i)) {
                smallest = Math.min(smallest, arr[i]);
                largest = Math.max(largest, arr[i]);
            }
        }

        if (smallest == Integer.MAX_VALUE)
            return new Pair<>(-1, -1);

        //find the correct positions of start an end of unordered sub array
        int left = 0;
        while (left < n && smallest >= arr[left]) {
            left++;
        }
        int right = n - 1;
        while (right >= 0 && largest <= arr[right]) {
            right--;
        }

        return new Pair<>(left, right);
    }

}
