package com.example.myapplication.datastructures.array.codingminutes.dynamic_programming;

import java.util.Arrays;

public class Fibonacci {

    public static void main(String[] args) {
        int n = 7;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 0);
        int result = fibTopDownDp(n, dp);
        System.out.println("Fib Top Down:" + result);

        int result1 = fibBottomUpDp(n);
        System.out.println("Fib Bottom Up:" + result1);
    }

    //top down dynamic programming
    static int fibTopDownDp(int n, int[] dp) {
        //base case
        if (n == 0 || n == 1) {
            return n;
        }
        if (dp[n] != 0) {
            return dp[n];
        }

        return dp[n] = fibTopDownDp(n - 1, dp) + fibTopDownDp(n - 2, dp);
    }

    //bottom up dp
    static int fibBottomUpDp(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp,0);
        //base case
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <=n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
