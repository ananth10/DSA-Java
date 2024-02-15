package com.example.myapplication.dynamic_programming.subsequences;

import java.util.Arrays;

public class LongestIncreaseSubSequence {
    public static void main(String[] args) {
        int[] arr = {7, 49, 23, 8, 30, 22, 44, 28, 23, 9, 40, 15};

        int maxLis = findLis(arr);
        System.out.println("Result: "+maxLis);
    }

    private static int findLis(int[] arr) {
        int n = arr.length;

        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1); //default LIS is 1 for each element

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {

                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int maxLis = 1;
        for (int i = 0; i < dp.length; i++) {
            maxLis = Math.max(maxLis, dp[i]);
        }

        return maxLis;
    }
}
