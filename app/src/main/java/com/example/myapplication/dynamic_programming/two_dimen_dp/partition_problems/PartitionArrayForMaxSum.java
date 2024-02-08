package com.example.myapplication.dynamic_programming.two_dimen_dp.partition_problems;

import java.util.Arrays;

public class PartitionArrayForMaxSum {
    public static void main(String[] args) {
        int k = 3; //at most sub-array can be
        int[] arr = {1, 15, 7, 9, 2, 5, 10};

        int result = maxSum(0, k, arr);
        System.out.println("Result:" + result);

        int[] dp = new int[arr.length+1];
        Arrays.fill(dp,-1);
        int result1 = maxSumTopDown(0,k,arr,dp);
        System.out.println("TopDown Result:" + result1);
    }

    //recursive approach
    private static int maxSum(int i, int k, int[] arr) {
        if (i == arr.length)
            return 0;
        int ans = 0, max = 0;
        for (int j = i; j < Math.min(arr.length, i + k); j++) {
            max = Math.max(max, arr[j]);
            ans = Math.max(ans, max * (j - i + 1) + maxSum(j + 1, k, arr));
        }

        return ans;
    }

    //Top Down Approach

    private static int maxSumTopDown(int i, int k, int[] arr, int[] dp) {
        if (i == arr.length)
            return 0;
        if (dp[i] != -1)
            return dp[i];

        int ans = 0, max = 0;
        for (int j = i; j < Math.min(arr.length, i + k); j++) {
            max = Math.max(max, arr[j]);
            ans = Math.max(ans, max * (j - i + 1) + maxSum(j + 1, k, arr));
        }

        return dp[i] = ans;
    }

}
