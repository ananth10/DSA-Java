package com.example.myapplication.dynamic_programming.problems;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Candies {

    static int n = 3;
    static int k = 4;

    static int[] a = {1, 2, 3};

    static int[][] dp = new int[n + 1][k + 1];


    public static void main(String[] args) {
        candies();
        candiesOptimised();

        System.out.println("Result:"+dp[n][k]);
    }


    //bruteforce approach
    static void candies() {

        dp[0][0] = 1; //one way possible

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {

                for (int kk = 0; kk <= Math.min(a[i - 1], j); kk++) {

                    dp[i][j] += dp[i - 1][j - kk];
                }
            }
        }

        for (int[] row : dp) {
            System.out.println(Arrays.toString(row));
        }
    }

    //optimised prefix sum approach

    static void candiesOptimised() {
        dp[0][0] = 1; //one way possible

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i - 1][j] += dp[i - 1][j - 1];
            }
            for (int j = 0; j <= k; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - a[i-1] > 0) {
                    dp[i][j] -= dp[i - 1][j - a[i-1] - 1];
                }
            }
        }

        System.out.println();
        for (int[] row : dp) {
            System.out.println(Arrays.toString(row));
        }
    }
}
