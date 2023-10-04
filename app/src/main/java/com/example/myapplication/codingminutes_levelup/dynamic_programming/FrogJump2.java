package com.example.myapplication.codingminutes_levelup.dynamic_programming;


import java.util.Arrays;

/**
 * There are N stones, for each i (1 <= i <= N), the height of Stone i is h[i]. There is a frog who is initially on Stone 1. He will repeat the following action some number of times to reach Stone N:
 * If the frog is currently on Stone i, jump to one of the following: Stone i+1,i+2,…,i+K. Here, a cost of |hi−hj| is incurred, where j is the stone to land on.
 * Find the minimum possible total cost incurred before the frog reaches Stone N.
 * Input Format
 * Function contains a vector containing height of stones and an integer K.
 * Output Format
 * Return a single integer representing minimum possible total cost incurred.
 * Constraints
 * 2 <= n <= 100000
 * 1 <= k <= 100
 * 1 <= h[i] <= 10000
 * Sample Testcase:
 * Input:
 * k=3
 * 10 30 40 50 20
 * Output:
 * 30
 */
public class FrogJump2 {

    public static void main(String[] args) {
        int k = 3;
        int[] stones = {10, 30, 40, 50, 20};
        int minCost = minCost(stones, k);
        System.out.println("Bottom UP Min Cost:" + minCost);

        int[] dp = new int[stones.length];
        Arrays.fill(dp, 0);
        int minCost1 = minCostTopDown(stones, k, dp, stones.length - 1);
        System.out.println("Top Down Min Cost:" + minCost1);
    }

    //BottomUp
    private static int minCost(int[] stones, int k) {
        int n = stones.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 0);

        dp[1] = Math.abs(stones[0] - stones[1]);

        for (int i = 2; i < n; i++) {
            int ans = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int cost = Math.abs(stones[i] - stones[i - j]) + dp[i - j];
                    ans = Math.min(ans, cost);
                }
            }
            dp[i] = ans;
        }
        return dp[n - 1];
    }

    //TopDown
    private static int minCostTopDown(int[] stones, int k, int[] dp, int i) {
        //base case
        if (i == 0) {
            return 0;
        }
        if (dp[i] != 0) {
            return dp[i];
        }
        int ans = Integer.MAX_VALUE;
        for (int j = 1; j <= k; j++) {
            if (i - j >= 0) {
                minCostTopDown(stones, k, dp, i - 1);
                int cost = dp[i - j] + Math.abs(stones[i] - stones[i - j]);
                ans = Math.min(cost, ans);
            }
        }
        return dp[i] = ans;
    }
}
