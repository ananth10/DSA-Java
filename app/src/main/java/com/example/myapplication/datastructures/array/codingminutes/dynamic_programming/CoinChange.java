package com.example.myapplication.datastructures.array.codingminutes.dynamic_programming;

public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {4, 1, 2, 3};
        int n = coins.length-1;
        int total = 4;
        int[][] dp = new int[500][100];
        int uniqueWays = coinChange(total, n, coins, dp);
        System.out.println("combinations: " + uniqueWays);
    }

    static int coinChange(int total, int numOfCoins, int[] coins, int[][] dp) {
        //base case
        if (numOfCoins < 0 || total < 0) //if either total is 0 or not coins which mean only 0 unique ways
            return 0;
        if (total == 0) //if total is 0 and we have coins then we have one unique way
            return 1;

        if (dp[total][numOfCoins] != 0) //if we already calculated the unique ways to sum up the given total then we can re use that cell in 2D matrix.
            return dp[total][numOfCoins];

        int pick_coin = coinChange(total - coins[numOfCoins], numOfCoins, coins, dp);
        int not_pick_coin = coinChange(total, numOfCoins - 1, coins, dp);

        return dp[total][numOfCoins] = pick_coin + not_pick_coin;
    }
}
