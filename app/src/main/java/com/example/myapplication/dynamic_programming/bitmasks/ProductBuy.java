package com.example.myapplication.dynamic_programming.bitmasks;

import java.util.Arrays;

public class ProductBuy {

    public static void main(String[] args) {
        int[][] price = {{6, 9, 5, 2, 8, 9, 1, 6},
                {8, 2, 6, 2, 7, 5, 7, 2},
                {5, 3, 9, 7, 3, 5, 1, 4}};

        int result = findMinPrice(price);

        System.out.println("Result:" + result);
    }

    static int findMinPrice(int[][] price) {
        int k = price.length;
        int n = price[0].length;
        int[][] dp = new int[1 << k][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        //base case
        dp[0][0] = 0;

        for (int i = 0; i < k; i++) {
            dp[1 << i][0] = price[i][0];
        }

        for (int mask = 0; mask < (1 << k); mask++) {
            for (int day = 1; day < n; day++) {
                dp[mask][day] = dp[mask][day - 1]; //not buying product on the current day.
                //iterate over the product and check mask contains the product for the day
                for (int x = 0; x < k; x++) {
                    if (((mask >> 1) & 1) == 1) { //mask contains the product
                        //unset the jth bit of mask
                        int newMask = mask ^ (1 << x);
                        dp[mask][day] = Math.min(dp[mask][day], dp[newMask][day - 1]) + price[x][day];
                    }
                }
            }
        }

        return dp[(1 << k) - 1][n-1];
    }
}
