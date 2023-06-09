package com.example.myapplication.codingminutes.divide_conquer;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9};
        int x = 9;
        int s = 0;
        int e = arr.length - 1;
        int result = binarySearch(arr, s, e, x);
        System.out.println("INDEX::" + result);
    }

    static int binarySearch(int[] arr, int s, int e, int x) {
        //base case
        if (e >= s) {
            int mid = s + (e - s) / 2;
            if (arr[mid] == x) {
                return mid;
            }
            if (x > arr[mid]) {
                return binarySearch(arr, mid + 1, e, x);
            } else {
                return binarySearch(arr, s, mid - 1, x);
            }
        }
        return -1;
    }
}
