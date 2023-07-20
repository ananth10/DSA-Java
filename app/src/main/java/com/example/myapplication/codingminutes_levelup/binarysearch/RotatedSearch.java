package com.example.myapplication.codingminutes_levelup.binarysearch;


/**
 * Write a function that takes input an sorted array of distinct integers, which is rotated about a pivot point
 * and finds the index of any given element.
 */
public class RotatedSearch {

    public static void main(String[] args) {
        int[] a = {7, 9, 10, 1, 2, 3, 4, 5, 6};
        int k = 9;
        int result = findIndexOfGivenElement(a, k);
        System.out.println("Result:" + result);
    }

    static int findIndexOfGivenElement(int[] arr, int k) {
        int s = 0;
        int e = arr.length - 1;

        while (s <= e) {
            int mid = (s + e) / 2;
            if (arr[mid] == k) {
                return mid;
            } else if (arr[s] <= arr[mid]) { //mid lies in the L1
                if (arr[s] <= k && k <= arr[mid]) { //if key lies between s and mid in the L1
                    e = mid - 1;
                } else {
                    s = mid + 1;
                }
            } else {
                if (arr[mid] <= k && k <= arr[e]) {
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            }
        }
        return -1;
    }
}
