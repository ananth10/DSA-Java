package com.example.myapplication.dynamic_programming.two_dimen_dp.partition_problems;

import java.util.Arrays;

public class BestTimeToBuySellStocks {
    public static void main(String[] args) {
        int k = 2; //max num of transactions (1buy+1sell=1 transaction)
        int[] prices = {2, 4, 1};


        int maxProfit = findMaxProfit(0, k, true, prices);
        System.out.println("Result:" + maxProfit);


        int[][][]dp = new int[1001][2][101];
        for(int[][] row: dp){
            for (int[] col:row){
                Arrays.fill(col,-1);
            }
        }
        int maxProfit1 = findMaxProfitDp(0, k, 1, prices,dp);
        System.out.println("Dp Result:" + maxProfit1);
    }

    private static int findMaxProfit(int i, int k, boolean buy, int[] prices) {
        //base case
        if (i == prices.length) {
            return 0;
        }
        //either dont buy/sell stock
        int ans = findMaxProfit(i + 1, k, true, prices);

        if (k == 0)
            return 0;
        //buy stock
        if (buy) {
            ans = Math.max(ans, -(prices[i]) + findMaxProfit(i + 1, k, false, prices));
        } else {
            ans = Math.max(ans, prices[i] + findMaxProfit(i + 1, k - 1, true, prices));
        }

        return ans;
    }


    private static int findMaxProfitDp(int i, int k, int buy, int[] prices,int[][][]dp) {
        //base case
        if (i == prices.length) {
            return 0;
        }

        if(dp[i][buy][k]!=-1){
            return dp[i][buy][k];
        }
        //either dont buy/sell stock
        int ans = findMaxProfitDp(i + 1, k, 1, prices,dp);

        if (k == 0)
            return 0;
        //buy stock
        if (buy==1) {
            ans = Math.max(ans, -(prices[i]) + findMaxProfitDp(i + 1, k, 0, prices,dp));
        } else {
            ans = Math.max(ans, prices[i] + findMaxProfitDp(i + 1, k - 1, 1, prices,dp));
        }

        return dp[i][buy][k] = ans;
    }
}
