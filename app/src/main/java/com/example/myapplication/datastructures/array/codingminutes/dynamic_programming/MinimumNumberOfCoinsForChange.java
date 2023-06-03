package com.example.myapplication.datastructures.array.codingminutes.dynamic_programming;

import java.util.Arrays;

public class MinimumNumberOfCoinsForChange {
    public static void main(String[] args) {
        int[] denoms = {1, 5, 7, 10};
        int m = 8;

        int result = minNumberOfCoins(denoms, m);
        System.out.println(result);
    }

    //bottom up dp
    static int minNumberOfCoins(int[] denoms, int m) {
        int[] dp = new int[m + 1];
        Arrays.fill(dp, 0);
        dp[0] = 0;

        for (int i = 1; i <= m; i++) {
            dp[i] = Integer.MAX_VALUE;

            for (int coin : denoms) {
                if ((i - coin) >= 0 && dp[i-coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i - coin], dp[i]) + 1;
                }
            }
        }

        return dp[m] == Integer.MAX_VALUE ? -1 : dp[m];
    }
}
