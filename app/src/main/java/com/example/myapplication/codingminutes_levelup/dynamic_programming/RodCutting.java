package com.example.myapplication.codingminutes_levelup.dynamic_programming;


import java.util.Arrays;

/**
 * Rod Cutting
 * -----------
 * Given rod with length and price list for each length
 * and need to find max profit for cutting rod.
 * <p>
 * INPUT:
 * N = 8
 * prices[] = {1,5,8,9,10,7,17,20}
 */
public class RodCutting {
    public static void main(String[] args) {
        int n = 8;
        int[] prices = {1, 5, 8, 9, 10, 17, 17, 20};

        int profit = maxProfit(n, prices);
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        int profit1 = maxProfileTopDown(n, prices, dp);
        System.out.println("Max Profit: " + profit);
        System.out.println("TopDown Max Profit: " + profit1);
        int profit2 = maxProfitBottomUp(n, prices);
        System.out.println("BottomUp Max Profit: " + profit2);
    }

    //normal recursive approach
    private static int maxProfit(int length, int[] prices) {
        //base case
        if (length <= 0) {
            return 0;
        }

        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < length; i++) {
            int cut = i + 1;
            int currentAns = prices[i] + maxProfit(length - cut, prices);

            ans = Math.max(currentAns, ans);
        }

        return ans;
    }

    //TopDown Approach

    private static int maxProfileTopDown(int length, int[] prices, int[] dp) {
        //base case
        if (length <= 0) {
            return 0;
        }
        if (dp[length] != Integer.MIN_VALUE) {
            return dp[length];
        }
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < length; i++) {
            int cut = i + 1;
            int currentAns = prices[i] + maxProfileTopDown(length - cut, prices, dp);

            ans = Math.max(currentAns, ans);
        }

        return dp[length] = ans;
    }

    //BottomUp approach
    private static int maxProfitBottomUp(int length, int[] prices) {
        int[] dp = new int[length + 1];
        Arrays.fill(dp, 0);

        dp[0] = 0;


        for (int rodLen = 1; rodLen <= length; rodLen++) {
            int ans = Integer.MIN_VALUE;
            for (int j = 0; j < rodLen; j++) {
                int cut = j + 1;
                int current_ans = prices[j] + dp[rodLen - cut];
                ans = Math.max(current_ans, ans);
            }
            dp[rodLen] = ans;
        }

        return dp[length];
    }
}
