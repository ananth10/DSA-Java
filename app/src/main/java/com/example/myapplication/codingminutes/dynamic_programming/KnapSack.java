package com.example.myapplication.codingminutes.dynamic_programming;

public class KnapSack {

    public static void main(String[] args) {

        int N = 4;
        int W = 11;
        int[] wts = {2, 7, 3, 4};
        int[] prices = {5, 20, 20, 10};

        int maxProfit = knapSack(wts, prices, N, W);
        System.out.println("Max Profit:" + maxProfit);

        int[][] dp = new int[100][100];
        int maxProfit1 = knapSackTopDown(wts, prices, N, W,dp);
        System.out.println("TopDown Max Profit:" + maxProfit1);
    }

    //bottom up
    static int knapSack(int[] wts, int[] prices, int N, int W) {
        int[][] dp = new int[N + 1][W + 1];
        for (int n = 0; n <= N; n++) {
            for (int w = 0; w <= W; w++) {
                if (n == 0 || w == 0) {
                    dp[n][w] = 0;
                } else if (wts[n - 1] <= w) {
                    dp[n][w] = Math.max(prices[n - 1] + dp[n - 1][w - wts[n - 1]], dp[n - 1][w]);
                } else {
                    dp[n][w] = dp[n - 1][w];
                }
            }
        }
        return dp[N][W];
    }

    //top down

    static int knapSackTopDown(int[] wts, int[] prices, int N, int W, int[][] dp) {
        //base case
        if (N == 0 || W == 0) {
            return 0;
        }
        //recursive case
        int include = 0, notInclude = 0;
        if (wts[N - 1] <= W) {
            include = prices[N - 1] + knapSackTopDown(wts, prices, N - 1, W - wts[N - 1], dp);
        }
        notInclude = knapSackTopDown(wts, prices, N - 1, W, dp);

        dp[N][W] = Math.max(include, notInclude);
        return dp[N][W];
    }
}
