package com.example.myapplication.codingminutes_levelup.arrays_and_vectors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triplets {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 15};
        int sum = 18;
        List<List<Integer>> triplets = tripletSum(arr, sum);
        System.out.println(triplets);
    }

    static List<List<Integer>> tripletSum(int[] arr, int sum) {
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> triplets;
        int n = arr.length;
        //we need at least 3 elements to process 2 pointers, like one element from array iteration and other 2 elements from remaining array
        for (int i = 0; i <= n - 3; i++) {
            int j = i + 1;
            int k = n - 1;
            //two pointer approach
            while (j < k) {
                int currentSum = arr[i];
                currentSum += arr[j];
                currentSum += arr[k];

                if (currentSum == sum) {
                    triplets = new ArrayList<>();
                    triplets.add(arr[i]);
                    triplets.add(arr[j]);
                    triplets.add(arr[k]);
                    result.add(new ArrayList<>(triplets));
                    j++;
                    k--;
                } else if (currentSum > sum) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return result;
    }
}
