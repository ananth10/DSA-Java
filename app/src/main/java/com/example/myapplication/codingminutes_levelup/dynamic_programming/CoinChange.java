package com.example.myapplication.codingminutes_levelup.dynamic_programming;

import java.util.Arrays;

/**
 * Given an array of coin denominations and integer M representing target money.
 * we need to find the min coins required to make the change.
 * <p>
 * INPUT:
 * coins = {1,3,7,10}
 * m = 15
 * OUTPUT:
 * 3 (7+7+1)
 */
public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {1, 3, 7, 10};
        int amount = 15;

        int result = minCoins(coins, amount);

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int result1 = minCoinsTopDown(coins, amount, dp);
        System.out.println("Result:" + result);
        System.out.println("TopDown Result:" + result1);
    }

    //Bottom up approach

    private static int minCoins(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 0);
        dp[0] = 0; //require 0 coins to make 0 amount

        for (int amnt = 1; amnt <= amount; amnt++) {

            dp[amount] = Integer.MAX_VALUE;

            for (int coin : coins) {
                if (amnt - coin >= 0 && dp[amnt - coin] != Integer.MAX_VALUE) {
                    dp[amnt] = Math.min(dp[amnt], dp[amnt - coin]) + 1; //1 means current coin, we need to add
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount]; //if we cannot use given coins then return -1 otherwise return min of coins required to make the given amount
    }

    //TopDown approach
    private static int minCoinsTopDown(int[] coins, int amount, int[] dp) {
        //base case
        if (amount == 0) {
            return 0;
        }
        if (dp[amount] != Integer.MAX_VALUE) {
            return dp[amount];
        }

        for (int i = 0; i < coins.length; i++) {
            if (amount - coins[i] >= 0) {
                dp[amount] = Math.min(minCoinsTopDown(coins, amount - coins[i], dp) + 1, dp[amount]);
            }
        }

        return dp[amount];
    }
}
