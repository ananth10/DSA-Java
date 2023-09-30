package com.example.myapplication.codingminutes_levelup.dynamic_programming;

import java.util.Arrays;

/**
 * Frog Min Cost
 * ------------
 * There are N stones, given in the form of an array, each element in array represents the height
 * of ith stone, there is a frog who is initially on stone 1
 * <p>
 * Frog will repeat the following action some number of times to reach stone N,
 * <p>
 * If the frog is currently on stone i jump to stone i+1 or i+2 here
 * a cost of [hi-hj] is occurred, where j is the stone to land on
 * <p>
 * Find the minimum possible total cost incurred before the frog reaches stone N
 * <p>
 * INPUT:
 * 30 10 60 10 60 50
 * OUTPUT
 * 40
 */
public class FrogMinCost {

    public static void main(String[] args) {
        int[] stones = {30, 10, 60, 10, 60, 50};
        int n = stones.length;

        int cost = minCost(stones, n);
        System.out.println("Result:" + cost);
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        int cost1 = minCostTopDown(stones, n - 1, dp);
        System.out.println("Result:" + cost1);
    }

    //BottomUp approach
    static int minCost(int[] stones, int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 0);

        //base case
        dp[1] = Math.abs(stones[0] - stones[1]);

        for (int i = 2; i < n; i++) {
            int op1 = Math.abs(stones[i] - stones[i - 1]) + dp[i - 1];
            int op2 = Math.abs(stones[i] - stones[i - 2]) + dp[i - 2];
            dp[i] = Math.min(op1, op2);
        }
        return dp[n - 1];
    }

    //TopDown Approach

    static int minCostTopDown(int[] stones, int n, int[] dp) {
        //base case
        if (n == 0) {
            return 0;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int jump2 = Integer.MAX_VALUE;
        int jump1 = minCostTopDown(stones, n - 1, dp) + Math.abs(stones[n] - stones[n - 1]);
        if (n > 1) {
            jump2 = minCostTopDown(stones, n - 2, dp) + Math.abs(stones[n] - stones[n - 2]);
        }

        return dp[n] = Math.min(jump1, jump2);
    }
}
