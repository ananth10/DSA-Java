package com.example.myapplication.datastructures.array.codingminutes.dynamic_programming;

import java.util.Arrays;

public class Wines {

    public static void main(String[] args) {
        int[] wines = {2, 4, 6, 5};
        int n = wines.length;
        int[][] dp = new int[n][n];
        int result = wines(dp, wines, 0, n - 1, 1);
        System.out.println("Max Profit:" + result);
        printDp(dp);
        int result1 = wines_bottom_up(wines, n);
        System.out.println("bottom up result: " + result1);
    }

    //Topdown approach

    static int wines(int[][] dp, int[] prices, int L, int R, int Y) {
        //base case
        if (L > R) {
            return 0;
        }
        //if state is already computed
        if (dp[L][R] != 0) {
            return dp[L][R];
        }

        //recursive case

        int pick_left = prices[L] * Y + wines(dp, prices, L + 1, R, Y + 1);
        int pick_right = prices[R] * Y + wines(dp, prices, L, R - 1, Y + 1);

        return dp[L][R] = Math.max(pick_left, pick_right);

    }

    //bottom up approach
    static private int wines_bottom_up(int[] prices, int n) {
        int[][] dp = new int[n][n];

        for (int row = n - 1; row >= 0; row--) {
            for (int col = 0; col < n; col++) {
                //only one bottle left in the cell
                if (row == col) {
                    dp[row][col] = prices[row] * n;
                    System.out.println("ROW: " + row + ", COL: " + col + ", PRICE:" + prices[row]);
                } else if (row < col) {
                    int y = n - (col - row);
                    System.out.println("ROW: " + row + ", COL: " + col + ", PRICE:" + prices[row]);
                    int pick_left = prices[row] * y + dp[row + 1][col];
                    int pick_right = prices[col] * y + dp[row][col - 1];
                    dp[row][col] = Math.max(pick_left, pick_right);
                }
            }
        }

        System.out.println();
        printDp(dp);
        return dp[0][n - 1];
    }

    private static void printDp(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            System.out.println();
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
        }
        System.out.println();
    }
}
