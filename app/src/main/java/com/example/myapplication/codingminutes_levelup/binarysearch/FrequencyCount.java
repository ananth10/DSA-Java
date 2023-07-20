package com.example.myapplication.codingminutes_levelup.binarysearch;

/**
 * Given a sorted array, which can contain respected elements, and an element K, we need to find the frequency of a given element.
 */
public class FrequencyCount {
    public static void main(String[] args) {
        int[] a = {0, 1, 1, 1, 2, 2, 2, 2, 3, 4, 4, 5, 10};
        int k = 2;
        int count = frequencyCount(a, k);
        System.out.println("Result:" + count);
    }

    static int frequencyCount(int[] arr, int k) {
        return upperBound(arr, k) - lowerBound(arr, k) + 1;
    }

    static int lowerBound(int[] arr, int k) {
        int s = 0;
        int e = arr.length - 1;
        int ans = -1;

        while (s <= e) {
            int mid = (s + e) / 2;
            if (k == arr[mid]) {
                ans = mid;
                e = mid - 1;
            } else if (arr[mid] > k) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return ans;
    }

    static int upperBound(int[] arr, int k) {
        int s = 0;
        int e = arr.length - 1;
        int ans = -1;

        while (s <= e) {
            int mid = (s + e) / 2;
            if (k == arr[mid]) {
                ans = mid;
                s = mid + 1;
            } else if (arr[mid] > k) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return ans;
    }
}
