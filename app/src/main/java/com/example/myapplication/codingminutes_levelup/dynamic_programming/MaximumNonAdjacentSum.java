package com.example.myapplication.codingminutes_levelup.dynamic_programming;

import java.util.Arrays;

/**
 * Maximum Non Adjacent Sum
 * -----------------------
 * Given an integer array, we need to find the maximum sum with non adjacent element
 * Input:
 * 6, 10, 12, 7, 9, 14
 * <p>
 * OUTPUT:
 * 32
 */
public class MaximumNonAdjacentSum {

    public static void main(String[] args) {
        int[] arr = {6, 10, 12, 7, 9, 14};
        int n = arr.length;

        int[] dp = new int[n];
        Arrays.fill(dp, 0);
        int sum = maxSumTopDown(arr, n - 1, dp);
        System.out.println("TopDown Result:" + sum);
        int sum2 = maxSumBottomUp(arr, n);
        System.out.println("BottomUp Result:" + sum2);

    }


    //TopDown Approach
    private static int maxSumTopDown(int[] arr, int n, int[] dp) {
        //base case
        if (n == 0) {
            return dp[n] = arr[n];
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        int option2 = Integer.MIN_VALUE;
        int option1 = maxSumTopDown(arr, n - 1, dp);
        if (n > 1) {
            option2 = maxSumTopDown(arr, n - 2, dp) + arr[n];
        }

        return dp[n] = Math.max(option1, option2);
    }

    private static int maxSumBottomUp(int[] arr, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 0);

        dp[0] = arr[0];
        dp[1] = arr[1];

        for (int i = 2; i < n; i++) {
            int option1 = dp[i - 1];
            int option2 = dp[i - 2] + arr[i];
            dp[i] = Math.max(option1, option2);
        }

        return dp[n - 1];
    }
}
