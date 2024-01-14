package com.example.myapplication.dynamic_programming.one_dimen_dp;

import java.util.Arrays;

public class RodCutting {

    public static void main(String[] args) {
        int n = 8;
        int[] prices = {1, 3, 4, 5, 7, 9, 10, 11};

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        int result = rodCuttingTopDown(n, prices, dp);
        System.out.println("TopDown Result: " + result);

        int result1 = rodCuttingBottomUp(n, prices);
        System.out.println("BottomUp Result: " + result1);
    }

    private static int rodCuttingTopDown(int n, int[] prices, int[] dp) {
        //base case
        if (n == 0) {
            return 0;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, prices[i - 1] + rodCuttingTopDown(n - i, prices, dp));
        }

        return dp[n] = ans;
    }


    private static int rodCuttingBottomUp(int n, int[] prices) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 0);

        dp[0] = 0;
        for (int i = 1; i <= n; i++) {

            int ans = Integer.MIN_VALUE;

            for (int j = 0; j < i; j++) {
                int cut = j + 1;
                ans = Math.max(ans, prices[j] + dp[i - cut]);
            }

            dp[i] = ans;
        }
        return dp[n];
    }
}
