package com.example.myapplication.dynamic_programming.one_dimen_dp;

import java.util.Arrays;

public class SUPW {

    public static void main(String[] args) {
        int n = 8;
        int[] mins = {3, 2, 3, 2, 3, 5, 1, 3};
        System.out.println("Result:" + supwBottomUp(n, mins));

        int[] dp = new int[n];
        Arrays.fill(dp, 0);
        supwTopDown(n - 1, mins, dp);
        int result = Math.min(Math.min(dp[n - 1], dp[n - 2]), dp[n - 3]);
        System.out.println("TopDown Result:" + result);
        System.out.println("TopDown Result:" + Arrays.toString(dp));
    }

    //bottom up
    private static int supwBottomUp(int n, int[] mins) {
        int[] dp = new int[n];
        Arrays.fill(dp, 0);

        dp[0] = mins[0];
        dp[1] = mins[1];
        dp[2] = mins[2];

        for (int i = 3; i < n; i++) {
            dp[i] = (Math.min(Math.min(dp[i - 1], dp[i - 2]), dp[i - 3])) + mins[i];
        }
        System.out.println("Bottom Result:" + Arrays.toString(dp));
        return Math.min(Math.min(dp[n - 1], dp[n - 2]), dp[n - 3]);
    }

    //TopDown
    private static int supwTopDown(int n, int[] mins, int[] dp) {

        //base case
        if (n < 3) {
            return dp[n]=mins[n];
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        //recursive case
        return dp[n] = (Math.min(Math.min(supwTopDown(n - 1, mins, dp), supwTopDown(n - 2, mins, dp)), supwTopDown(n - 3, mins, dp))) + mins[n];
    }
}
