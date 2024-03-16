package com.example.myapplication.dynamic_programming.problems;

import java.util.Arrays;

public class KnapsackMemo {
    static int w = 8;
    static int[] values = {30, 50, 60};
    static int[] wts = {3, 4, 5};

    static int n = values.length;

    static int[][] dp = new int[n][8];

    public static void main(String[] args) {
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int result = knapsackMemo(0, 0);
        System.out.println("Result:" + result);

        int result1 = knapsackUsingValues();
        System.out.println("Result1:" + result1);
    }

    private static int knapsackMemo(int i, int wt) {

        //base case
        if (i >= n)
            return 0;

        if (dp[i][wt] != -1) {
            return dp[i][wt];
        }
        int take = 0;
        if (wt + wts[i] <= w) {
            take = values[i] + knapsackMemo(i + 1, wt + wts[i]);
        }
        int notTake = knapsackMemo(i + 1, wt);

        return dp[i][wt] = Math.max(take, notTake);
    }

    /*
     * Constraints
     * 1<N<100
     * 1<W<10^9
     * 1<wi<W
     * 1<vi<10^3
     * */

    static int[] v = {5, 6, 4, 6, 5, 2};
    static int[] weights = {6, 5, 6, 6, 3, 7};

    static int N  = 101;
    static int nn = 6;
    static int W = 15;

    static int k = 100001;
    static long[][] mW = new long[N][k];
    static long[][] DP = new long[N][k];

    static int knapsackUsingValues() {
        for (long[] row : mW) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        //base case
        DP[0][0] = 1;
        mW[0][0] = 0;

        for (int i = 1; i <= nn; i++) {
            for (int val = 0; val < k; val++) {

                //not taking
                if (dp[i - 1][val] == 1) {
                    dp[i][val] = 1;
                    mW[i][val] = Math.min(mW[i][val], mW[i - 1][val]);
                }
                //taking
                if (val - v[i] >= 0 && dp[i - 1][val - v[i]] == 1 && mW[i - 1][val - v[i]] + weights[i] <= W) {
                    dp[i][val] = 1;
                    mW[i][val] = Math.min(mW[i][val], mW[i - 1][val - v[i]] + weights[i]);
                }
            }

        }

        int ans = 0;
        for (int val = 0; val < k; val++) {
            if (dp[nn][val] == 1) {
                ans = val;
            }
        }

        return ans;
    }
}
