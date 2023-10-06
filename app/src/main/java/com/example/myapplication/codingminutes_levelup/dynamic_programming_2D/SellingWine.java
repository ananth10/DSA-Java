package com.example.myapplication.codingminutes_levelup.dynamic_programming_2D;

import java.util.Arrays;

/**
 * Selling Wine
 * ------------
 * We need to sell given wine bottles .
 * Input:
 * prices = [2,3,5,1,4]
 * <p>
 * OUTPUT:
 * 50
 * <p>
 * Constraints
 * ->We can sell one bottle every year
 * ->cost of bottle get increased by year
 * ->either we can pick left most or right most bottle
 */
public class SellingWine {
    public static void main(String[] args) {
        int[] prices = {2, 3, 5, 1, 4};
        int n = prices.length;

        int[][] dp = new int[10][10];
        for (int[] row : dp) {
            Arrays.fill(row, 0);
        }

        int profit = maxProfitTopDown(0, n - 1, 1, dp, prices);
        System.out.println("TopDown Result:" + profit);

        int profit1 = maxProfitBottomUp(prices, n);
        System.out.println("BottomUp Result:" + profit1);


    }

    private static int maxProfitTopDown(int l, int r, int y, int[][] dp, int[] prices) {
        //base case
        if (l > r) {
            return 0;
        }

        //recursive case
        if (dp[l][r] != 0) {
            return dp[l][r];
        }

        int pickLeft = prices[l] * y + maxProfitTopDown(l + 1, r, y + 1, dp, prices);
        int pickRight = prices[r] * y + maxProfitTopDown(l, r - 1, y + 1, dp, prices);

        return dp[l][r] = Math.max(pickLeft, pickRight);
    }

    private static int maxProfitBottomUp(int[] prices, int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, 0);
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (i == j) { //only one bottle left, so fill diagonal
                    dp[i][i] = n * prices[i];
                } else if (i < j) {
                    int year = n - (j - i);
                    int pickLeft = prices[i] * year + dp[i + 1][j];
                    int pickRight = prices[j] * year + dp[i][j - 1];
                    dp[i][j] = Math.max(pickLeft, pickRight);
                }
            }
        }

        //print all dp
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return dp[0][n - 1];
    }
}
