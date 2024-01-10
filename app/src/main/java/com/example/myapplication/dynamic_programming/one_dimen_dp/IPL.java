package com.example.myapplication.dynamic_programming.one_dimen_dp;

import java.util.Arrays;

public class IPL {

    public static void main(String[] args) {
        int n = 8;
        int[] fees = {3, 2, 3, 2, 3, 5, 1, 3};
        System.out.println("BottomUp Result:" + iplBottomUp(n, fees));
        System.out.println("TopDown Result:" + iplTopDown(n,fees));
    }


    private static int iplBottomUp(int n, int[] fees) {
        int sum = 0;

        for (int fee : fees) {
            sum += fee;
        }

        int[] dp = new int[n];

        dp[0] = fees[0];
        dp[1] = fees[1];
        dp[2] = fees[2];

        for (int i = 3; i < n; i++) {
            dp[i] = Math.min(Math.min(dp[i - 1], dp[i - 2]), dp[i - 3]) + fees[i];
        }
        return sum - Math.min(Math.min(dp[n - 1], dp[n - 2]), dp[n - 3]);
    }

    private static int iplTopDown(int n, int[] fees) {
        int sum = 0;
        for (int fee : fees) {
            sum += fee;
        }
        int[] dp = new int[n];
        Arrays.fill(dp, 0);
        iplTopDownHelper(n - 1, fees, dp);
        return sum - Math.min(Math.min(dp[n - 1], dp[n - 2]), dp[n - 3]);
    }

    private static int iplTopDownHelper(int n, int[] fees, int[] dp) {

        //base case
        if (n < 3) {
            return dp[n] = fees[n];
        }
        if (dp[n] != 0) {
            return dp[n];
        }

        return dp[n] = Math.min(Math.min(iplTopDownHelper(n - 1, fees, dp), iplTopDownHelper(n - 2, fees, dp)), iplTopDownHelper(n - 3, fees, dp)) + fees[n];
    }
}
