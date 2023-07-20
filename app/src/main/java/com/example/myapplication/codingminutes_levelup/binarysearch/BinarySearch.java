package com.example.myapplication.codingminutes_levelup.binarysearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[] a = {2, 4, 6, 10, 15, 17, 22, 24, 30};
        int key = 24;

        int result = binarySearch(a, key);
        System.out.println("Result:" + result);
    }

    static int binarySearch(int[] arr, int key) {
        int s = 0;
        int e = arr.length - 1;

        while (s <= e) {
            int mid = (s + e) / 2;
            if (key == arr[mid]) {
                return mid;
            } else if (key > arr[mid]) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }

        return -1;
    }
}
