package com.example.myapplication.dynamic_programming.problems;

import java.util.Arrays;

public class LCS {
    static String s1 = "axyb";
    static int n = s1.length();
    static String s2 = "abyxb";
    static int m = s2.length();

    static int[][] dp = new int[n + 1][m + 1];

    public static void main(String[] args) {

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int result = lcsTopDown(0, 0);
        System.out.println("result TopDown: " + result);

        traceBack(0, 0);

        int result1 = lcsBottomUp();
        System.out.println("result BottomUp: " + result1);
    }

    static int lcsTopDown(int i, int j) {
        //base case
        if (i == n || j == m)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];
        //recursive case
        int ans = 0;
        if (s1.charAt(i) == s2.charAt(j)) {
            ans = lcsTopDown(i + 1, j + 1) + 1;
        } else {
            ans = Math.max(lcsTopDown(i + 1, j), lcsTopDown(i, j + 1));
        }

        return dp[i][j] = ans;

    }

    static void traceBack(int i, int j) {
        //base case
        if (i == n || j == m)
            return;
        if (s1.charAt(i) == s2.charAt(j)) {
            System.out.print(s1.charAt(i) + " ");
            traceBack(i + 1, j + 1);
        } else {
            if (lcsTopDown(i + 1, j) == lcsTopDown(i, j)) {
                traceBack(i + 1, j);
            } else {
                traceBack(i, j + 1);
            }
        }
    }

    static int lcsBottomUp() {
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0)
                    dp[i][j] = 0;
                if (j == 0)
                    dp[i][j] = 0;

                if (i > 0 && j > 0) {
                    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
        }

        return dp[n][m];
    }
}
