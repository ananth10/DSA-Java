package com.example.myapplication.dynamic_programming.one_dimen_dp;


import java.util.Arrays;

/**
 * You are given a positive N , you have to reduce it to one by performing following steps
 * ->Reduce it to n-1.(n->n-1)
 * ->If it divisible by 2, then divide by 2 (n->n/2)
 * ->If it divisible by 3, then divide by 3 (n->n/3)
 */
public class MinStepToReachOne {

    public static void main(String[] args) {
        int n = 10;
        minStepTopDown(n);
        int result = minStepBottomUp(n);
        System.out.println("BottomUp Result:" + result);
    }

    private static void minStepTopDown(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        int result = minStepTopDownHelper(n, dp);
        System.out.println("TopDown Result:" + result);
    }

    private static int minStepTopDownHelper(int n, int[] dp) {
        //base case
        if (n == 1) {
            return 0;
        }

        if (dp[n] != -1) {
            return dp[n];
        }
        //recursive case
        int ans = Integer.MAX_VALUE;
        if (n % 2 == 0) {
            ans = Math.min(ans, minStepTopDownHelper(n / 2, dp));
        }
        if (n % 3 == 0) {
            ans = Math.min(ans, minStepTopDownHelper(n / 3, dp));
        }
        ans = Math.min(ans, minStepTopDownHelper(n - 1, dp));
        return dp[n] = ans + 1;
    }

    private static int minStepBottomUp(int n) {
        int[] dp = new int[n + 1];

        dp[0] = 0;

        for (int i = 2; i <= n; i++) {
            int ans = Integer.MAX_VALUE;
            if (i % 2 == 0) {
                ans = Math.min(ans, dp[i / 2]);
            }
            if (i % 3 == 0) {
                ans = Math.min(ans, dp[i / 3]);
            }
            ans = Math.min(ans, dp[i - 1]);
            dp[i] = ans + 1;
        }
        return dp[n];
    }
}
