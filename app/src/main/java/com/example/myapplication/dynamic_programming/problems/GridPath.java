package com.example.myapplication.dynamic_programming.problems;

import java.util.Arrays;

public class GridPath {

    static String[][] grid = {
            {".", ".", ".", "#"},
            {".", "#", ".", "."},
            {".", ".", ".", "."},
    };

    static int n = grid.length;
    static int m = grid[0].length;

    static int[][] dp = new int[n][m];

    static int mod = (int) (1e5 + 7);

    public static void main(String[] args) {

        int result = gridPath();
        System.out.println("Result:" + result);
    }

    static int gridPath() {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }

                if (grid[i][j].equals("#")) {
                    dp[i][j] = 0;
                }
                dp[i][j] %= mod;
            }
        }

        return dp[n - 1][m - 1];
    }
}
