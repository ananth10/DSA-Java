package com.example.myapplication.codingminutes_levelup.binarysearch;

import java.util.Arrays;

import kotlin.Pair;

/**
 * Given two non-empty arrays, find the pair of numbers(one from each array)
 * whose absolute difference is minimum. print the any one pair with the smallest
 * difference.
 */
public class MinPairs {

    public static void main(String[] args) {
        int[] a = {-1, 5, 10, 20, 3};
        int[] b = {26, 134, 135, 15, 17};

        Pair<Integer, Integer> pair = minPair(a, b);
        System.out.println("Result:" + pair);
        System.out.println("Result 1:" + minPair1(a,b));
    }


    static int lowerBound(int[] arr, int k) {
        int s = 0;
        int e = arr.length - 1;
        int ans = -1;
        int diff = Integer.MAX_VALUE;

        while (s <= e) {
            int mid = (s + e) / 2;
            if (k == arr[mid]) {
                ans = mid;
                e = mid - 1;
            } else if (arr[mid] > k) {
                if (Math.abs(arr[mid] - k) < diff) {
                    diff = Math.abs(arr[mid] - k);
                    ans = mid;
                }
                e = mid - 1;
            } else {
                if (Math.abs(arr[mid] - k) < diff) {
                    diff = Math.abs(arr[mid] - k);
                    ans = mid;
                }
                s = mid + 1;
            }
        }
        return ans;
    }

    private static Pair<Integer, Integer> minPair(int[] a, int[] b) {
        Arrays.sort(b);

        int p1 = 0, p2 = 0;
        int diff = Integer.MAX_VALUE;
//iterate over first array's element and find nearest element from second array.
        for (int val : a) {
            int lb = lowerBound(b, val);
            System.out.println("LB:" + lb);

            //left index of lb
            if (lb >= 1 && val - b[lb - 1] < diff) {
                diff = val - b[lb - 1];
                p2 = val;
                p1 = b[lb - 1];
            }

            //greater or right
            if (lb != b.length && b[lb] - val < diff) {
                diff = b[lb] - val;
                p1 = val;
                p2 = b[lb];
            }
        }

        return new Pair<>(p1, p2);
    }

    //Another approach - O(mlogm + nlogn)
    static Pair<Integer, Integer> minPair1(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int n = a.length;
        int m = b.length;
        int i = 0;
        int j = 0;
        int diff = Integer.MAX_VALUE;
        Pair<Integer, Integer> pair = null;
        while (i < n && j < m) {
            if (Math.abs(a[i] - b[j]) < diff) {
                diff = Math.abs(a[i] - b[j]);
                pair = new Pair<>(a[i], b[j]);
            }
            if (a[i] < b[j]) {
                i++;
            } else {
                j++;
            }
        }
        return pair;
    }
}
