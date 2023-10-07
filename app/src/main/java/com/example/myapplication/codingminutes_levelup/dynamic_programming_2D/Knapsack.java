package com.example.myapplication.codingminutes_levelup.dynamic_programming_2D;

import java.util.Arrays;

/**
 * KnapSack
 * --------
 * <p>
 * Given weights and prices of n items, we need to put a subset of items in a bag of capacity
 * W such that we get the maximum total value in the bag, also known as knapsack
 * INPUT
 * N = 4 w = 11
 * wts = [2,7,3,4]
 * prices = {5,20,20,10}
 * <p>
 * OUTPUT:
 * 40
 */
public class Knapsack {
    public static void main(String[] args) {
        int n = 4, w = 11;
        int[] weights = {2, 7, 3, 4};
        int[] prices = {5, 20, 20, 10};

        int cost = knapSackRecursion(weights, prices, n, w);
        System.out.println("Recursion Result:" + cost);

        int[][] dp = new int[n + 1][w + 1];
        for (int[] row : dp) {
            Arrays.fill(row, 0);
        }
        int cost1 = knapSackTopDown(weights, prices, n, w, dp);
        System.out.println("TopDown Result:" + cost1);

        int cost2 = knapsackBottomUp(weights, prices, n, w);
        System.out.println("BottomUp:" + cost2);
    }

    //Recursion approach
    private static int knapSackRecursion(int[] weights, int[] prices, int n, int w) {
        //base case
        if (n == 0 || w == 0) {
            return 0;
        }

        int pickItem = 0;
        int notPickItem = 0;

        if (weights[n - 1] <= w) {
            pickItem = prices[n - 1] + knapSackRecursion(weights, prices, n - 1, w - weights[n - 1]);
        }
        notPickItem = knapSackRecursion(weights, prices, n - 1, w);

        return Math.max(pickItem, notPickItem);
    }

    //TopDown Approach
    private static int knapSackTopDown(int[] weights, int[] prices, int n, int w, int[][] dp) {
        //base case
        if (n == 0 || w == 0) {
            return 0;
        }

        if (dp[n][w] != 0) {
            return dp[n][w];
        }

        int pickItem = 0;
        int notPickItem;

        if (weights[n - 1] <= w) {
            pickItem = prices[n - 1] + knapSackTopDown(weights, prices, n - 1, w - weights[n - 1], dp);
        }
        notPickItem = knapSackTopDown(weights, prices, n - 1, w, dp);

        return dp[n][w] = Math.max(pickItem, notPickItem);
    }

    //BottomUp

    private static int knapsackBottomUp(int[] weights, int[] prices, int N, int W) {
        int[][] dp = new int[N + 1][W + 1];
        for (int[] row : dp) {
            Arrays.fill(row, 0);
        }

        for (int n = 1; n <= N; n++) {
            for (int w = 1; w <= W; w++) {
                int pickItem = 0, notPickItem = 0;
                if (weights[n - 1] <= w) {
                    pickItem = prices[n - 1] + dp[n - 1][w - weights[n - 1]];
                }
                notPickItem = dp[n - 1][w];
                dp[n][w] = Math.max(pickItem, notPickItem);
            }
        }

        //print dp
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < W; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[N][W];
    }
}
