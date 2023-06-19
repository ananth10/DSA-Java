package com.example.myapplication.codingminutes_levelup.arrays_and_vectors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class PairSum {

    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 3, -6, 9, 11};
        int sum = 4;
        List<Integer> pairs = pairSum(arr, sum);
        List<Integer> pairs1 = pairSum1(arr, sum);
        List<Integer> pairs2 = pairSum2(arr, sum);
        System.out.println("PAIRS: " + pairs);
        System.out.println("PAIRS1: " + pairs1);
        System.out.println("PAIRS2: " + pairs2);
    }

    //Approach 1 - O(N) - Using Set data structure
    static List<Integer> pairSum(int[] arr, int sum) {
        List<Integer> result = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            int x = sum - arr[i];
            if (set.contains(x)) {
                result.add(arr[i]);
                result.add(x);
                return result;
            }
            set.add(arr[i]);
        }
        return null;
    }

    //Approach 2 - O(N2) Brute force approach
    static List<Integer> pairSum1(int[] arr, int sum) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (sum == (arr[i] + arr[j])) {
                    result.add(arr[i]);
                    result.add(arr[j]);
                    return result;
                }
            }
        }
        return null;
    }

    //Approach 3 - O(nlogn) Sorting based
    static List<Integer> pairSum2(int[] arr, int sum) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
           int x = sum-arr[i];
           int res = Arrays.binarySearch(arr,x);
           if(res!=-1){
               result.add(arr[i]);
               result.add(x);
               return result;
           }
        }
        return null;
    }
}
