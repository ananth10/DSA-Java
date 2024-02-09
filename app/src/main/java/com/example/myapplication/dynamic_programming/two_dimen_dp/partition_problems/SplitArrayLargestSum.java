package com.example.myapplication.dynamic_programming.two_dimen_dp.partition_problems;

import java.util.Arrays;

public class SplitArrayLargestSum {

    public static void main(String[] args) {

        int[] arr = {1};
        int m = 2;

        int result = minValueOfMaxSum(0, arr, m);
        System.out.println("Result:" + result);

        int n = arr.length;
        int[][] dp = new int[n + 1][m + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int result1 = minValueOfMaxSumTopDown(0, arr, m, dp);
        System.out.println("TopDown Result:" + result1);
    }

    //recursive approach
    private static int minValueOfMaxSum(int i, int[] arr, int m) {
        //Base case
        if (i == arr.length) {
            if (m == 0) {
                return 0;
            }
            return Integer.MAX_VALUE;
        }

        //recursive case
        if (m <= 0) return Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        for (int j = i; j < arr.length; j++) {
            sum += arr[j];
            ans = Math.min(ans, Math.max(sum, minValueOfMaxSum(j + 1, arr, m - 1)));
            System.out.println("ANS:"+ans);
        }

        return ans;
    }

    //TopDown approach
    private static int minValueOfMaxSumTopDown(int i, int[] arr, int m, int[][] dp) {
        //Base case
        if (i == arr.length) {
            if (m == 0) {
                return 0;
            }
            return Integer.MAX_VALUE;
        }

        if (dp[i][m] != -1) {
            return dp[i][m];
        }
        //recursive case
        if (m <= 0) return Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        for (int j = i; j < arr.length; j++) {
            sum += arr[j];
            ans = Math.min(ans, Math.max(sum, minValueOfMaxSumTopDown(j + 1, arr, m - 1, dp)));
        }

        return dp[i][m] = ans;
    }
}
