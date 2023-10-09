package com.example.myapplication.codingminutes_levelup.dynamic_programming_2D;


import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Coin Change 2
 * Given a value N and an integer vector COINS representing coins of different denominations. Considering you have infinite supply of each coin, your task is to find total number of combinations of these coins that make a sum of N.
 * If that amount of money cannot be made up by any combination of the coins, return 0.
 * Input Format:
 * In the function an integer N is given, and a vector COINS consisting of coins.
 * Output Format:
 * Return an integer representing total number of combinations.
 * Constraint:
 * Total number of ways <= 10^12.
 * Sample Testcase:
 * Input:
 * 4
 * 1 2 3
 * Output:
 * 4
 * Explanation:
 * {1, 1, 1, 1}, {1, 1, 2}, {1, 3}, {2, 2} are different combinations having a sum of 4.
 */
public class CoinChange {

    public static void main(String[] args) {
        int sum = 4;
        int[] coins = {1, 2, 3};
        int n = coins.length;
        int[][] dp = new int[sum+1][n+1];
        for (int[] row : dp) {
            Arrays.fill(row, 0);
        }

        int combinations = coinChangeTopdown(sum, n - 1, coins, dp);
        for (int[] row : dp){
            System.out.println(Arrays.toString(row));
        }
        System.out.println("TopDown approach:" + combinations);

        int combinations1 = coinChangeBottomUp(sum,coins);
        System.out.println("BottomUp:"+combinations1);
    }

    //TopDown approach
    private static int coinChangeTopdown(int sum, int n, int[] coins, int[][] dp) {
        //base case
        if (n < 0 || sum < 0) {
            return 0;
        }
        if (sum == 0) {
            return 1;
        }

        //recursive case
        if (dp[sum][n] != 0) {
            return dp[sum][n];
        }
        int exclude = coinChangeTopdown(sum, n - 1, coins, dp);
        int include = coinChangeTopdown(sum - coins[n], n, coins, dp);

        return dp[sum][n] = include + exclude;
    }

    //BottomUp

    private static int coinChangeBottomUp(int sum, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n+1][sum+1];
        for (int[] row : dp) {
            Arrays.fill(row, 0);
        }
        //fill base case
        //fill row , row is different coins and sum is 0, when sum is 0 still we could make 0 sum by excluding all coins, so possibility is 1
        for (int coin = 0; coin <=n; coin++) {
            dp[coin][0] = 1;
        }
        //fill the column , column is sum amount from 1 to sum and coin is 0, when we have no coins we cannot make any amount
        for (int sum1 = 1; sum1<=sum; sum1++) {
            dp[0][sum] = 0;
        }

        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=sum; j++) {
                if(j>=coins[i-1]){
                    dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j];
                }
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        for (int[] row : dp){
            System.out.println(Arrays.toString(row));
        }
        return dp[n][sum];
    }
}
