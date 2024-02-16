package com.example.myapplication.dynamic_programming.digit_dp;

import java.util.Arrays;

public class SumOfDigits {
    public static void main(String[] args) {
        String n = "10";

        int[][][] dp = new int[10][2][90];
        for (int[][] row : dp) {
            for (int[] row1 : row) {
                Arrays.fill(row1, -1);
            }
        }
        int sum = sumOfDigits(n, 0, true, 0, dp);
        System.out.println("Result: " + sum);

    }

    private static int sumOfDigits(String n, int index, boolean isLast, int sum, int[][][] dp) {
        //base case
        if (index == n.length()) {
            return sum;
        }
        int last = isLast ? 1 : 0;
        if (dp[index][last][sum] != -1) {
            return dp[index][last][sum];
        }

        int till = isLast ? (n.charAt(index) - '0') : 9;

        int ans = 0;
        for (int i = 0; i <= till; i++) {
            ans += sumOfDigits(n, index + 1, (isLast && i == till), sum + i, dp);
        }

        return dp[index][last][sum] = ans;
    }
}
