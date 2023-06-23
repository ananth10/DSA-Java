package com.example.myapplication.codingminutes_levelup.arrays_and_vectors;


import java.util.Arrays;
import java.util.HashSet;

public class MinimumDifference {
    public static void main(String[] args) {
        int[] a1 = {23, 5, 10, 17, 30};
        int[] a2 = {26, 134, 135, 14, 19};
        Pair result = minimumDifference(a1, a2);
        Pair result1 = minimumDifference1(a1, a2);
        System.out.println("RESULT:" + result);
        System.out.println("RESULT1:" + result1);
    }

    private static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "first=" + first +
                    ", second=" + second +
                    '}';
        }
    }

    //Approach 1 - Brute Force - O(n)
    static Pair minimumDifference(int[] arr1, int[] arr2) {
        Pair minPair = new Pair(Integer.MAX_VALUE, Integer.MAX_VALUE);
        int n1 = arr1.length;
        int n2 = arr2.length;
        int minDifferance = Integer.MAX_VALUE;

        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                if (Math.abs(arr1[i] - arr2[j]) < minDifferance) {
                    minDifferance = Math.abs(arr1[i] - arr2[j]);
                    minPair = new Pair(arr1[i], arr2[j]);
                }
            }
        }
        return minPair;
    }

    //Approach 2 - Sorting & Iterate - O(nlogn)
    static Pair minimumDifference1(int[] arr1, int[] arr2) {
        Pair minPair = new Pair(Integer.MAX_VALUE, Integer.MAX_VALUE);
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int n1 = arr1.length;
        int n2 = arr2.length;
        int minDiff = Integer.MAX_VALUE;
        int p = 0, q = 0;

        while (p < n1 && q < n2) {
            if (Math.abs(arr1[p] - arr2[q]) < minDiff) {
                minDiff = Math.abs(arr1[p] - arr2[q]);
                minPair = new Pair(arr1[p],arr2[q]);
            }
            if (arr1[p] < arr2[q]) {
                p++;
            } else {
                q++;
            }
        }
        return minPair;
    }
}
