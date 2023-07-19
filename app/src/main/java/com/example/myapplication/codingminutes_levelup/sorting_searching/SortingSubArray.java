package com.example.myapplication.codingminutes_levelup.sorting_searching;

import java.util.Arrays;

import kotlin.Pair;

/**
 * Write a function that takes in an array and returns two integers,
 * denoting starting and ending indices of the smallest subarray in the input array that needs to be sorted in place so that the entire input is sorted.
 * If the input array is already sorted, return a pair [-1,-1].
 */
public class SortingSubArray {
    public static void main(String[] args) {
        int[] a = {0, 2, 4, 7, 10, 11, 7, 12, 13, 14, 16, 19, 29};
        Pair<Integer, Integer> result = sortingSubArray(a);
        System.out.println("Result:" + result);

        Pair<Integer, Integer> result1 = sortingSubArray1(a);
        System.out.println("Result1:" + result1);
    }

    //this is O(NLogN) solution
    static Pair<Integer, Integer> sortingSubArray(int[] a) {
        int[] b = Arrays.copyOf(a, a.length);
        Arrays.sort(b);

        int i = 0;
        int n = a.length;

        while (i < n && a[i] == b[i]) {
            i++;
        }

        int j = a.length - 1;
        while (j >= 0 && a[j] == b[j]) {
            j--;
        }


        if (i == n) {
            return new Pair<>(-1, -1);
        }

        return new Pair<>(i, j);
    }

    //this is O(N) solution

    static Pair<Integer, Integer> sortingSubArray1(int[] arr) {
        int s = 0, e = arr.length - 1, i, min, max, n = arr.length;

        //scan left to right and find the first element which is greater than next element
        for (s = 0; s <= n - 1; s++) {
            if (arr[s] > arr[s + 1])
                break;
        }

        if (s == n - 1) { //all elements already sorted
            return new Pair<>(-1, -1);
        }

        //scan right to left and find the first element which is
        for (; e > 0; e--) {
            if (arr[e] < arr[e - 1])
                break;
        }

        //find the min and max between [s..e]
        min = arr[s];
        max = arr[s];
        for (i = s + 1; i <= e; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        //find the first element in [0..s-1] if it is greater than min, then assign that ith position to s
        for (i = 0; i < s; i++) {
            if (arr[i] > min) {
                s = i;
                break;
            }
        }

        //find the last element(if there is any)[e+1..n-1] which is smaller than max, then assign that ith position to e
        for (i = n - 1; i > e; i--) {
            if (arr[i] < max) {
                e = i;
                break;
            }
        }

        return new Pair<>(s, e);
    }
}
