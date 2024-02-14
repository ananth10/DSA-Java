package com.example.myapplication.dynamic_programming.combinotric;

import java.util.Arrays;

public class UnOrderedSets {
    public static void main(String[] args) {
        int n = 4;

        int[] dp = new int[n + 1];
        int result = countNumOfWays(1, n, dp);
        System.out.println("Result: " + result);

        int[][] dp1 = new int[n+1][n+1];
        for(int[] row : dp1){
            Arrays.fill(row,-1);
        }
        int result1 = countNumOfWays1(1,n,dp1);
        System.out.println("Result1: " + result1);

    }

    //Top Down Approach
    private static int countNumOfWays(int min, int n, int[] dp) {
        //base case
        if (n == 0)
            return 1;
        if (dp[n] != 0) {
            return dp[n];
        }
        int ans = 0;
        for (int i = min; i <= n; i++) {
            ans += countNumOfWays(i, n - i, dp);
        }
        return dp[n] = ans;
    }

    //another approach
    //f(min,n) = f(min,n-min) + f(min+1,n)
    private static int countNumOfWays1(int i, int j, int[][] dp) {
        //base case
        if (j == 0)
            return 1;
        if (i > j)
            return 0;
        if (i == j)
            return 1;

        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int includeMin = countNumOfWays1(i, j - i, dp);
        int excludeMin = countNumOfWays1(i + 1, j, dp);
        return includeMin + excludeMin;
    }
}
