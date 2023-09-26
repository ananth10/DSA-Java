package com.example.myapplication.codingminutes_levelup.dynamic_programming;

import java.util.Arrays;

public class Fibonacci {

    public static void main(String[] args) {
        int n = 5;

        int[] dp = new int[n + 1];
        Arrays.fill(dp, 0);

        int result = fiboTopDown(n, dp);
        System.out.println("Fibonacci of" + n + " is " + result);

        int result1 = fiboBottomUp(n);
        System.out.println("Fibonacci of" + n + " is " + result1);
    }

    //top-down approach
    static int fiboTopDown(int n, int[] dp) {
        //base case
        if (n == 0 || n == 1) {
            return n;
        }
        //recursive
        if (dp[n] != 0) {
            return dp[n];
        }
        return fiboTopDown(n - 1, dp) + fiboTopDown(n - 2, dp);
    }

    //bottom up approach
    static int fiboBottomUp(int n) {
        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
