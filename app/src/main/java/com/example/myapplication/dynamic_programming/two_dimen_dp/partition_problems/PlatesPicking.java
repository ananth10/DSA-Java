package com.example.myapplication.dynamic_programming.two_dimen_dp.partition_problems;

import java.util.Arrays;

public class PlatesPicking {

    public static void main(String[] args) {
        int[][] plates = {
                {10, 10, 100, 30},
                {80, 50, 10, 50}
        };
        int result = maxBeautyValues(plates);
        System.out.println("Result:" + result);
    }

    private static int maxBeautyValues(int[][] plates) {
        int n = plates.length; //total stack count
        int k = plates[0].length; //total plates in each stack
        int p = 5; //plates to pick

        int[][] prefix = new int[n + 1][p + 1];
        int[][] dp = new int[n + 1][p + 1];

        for (int[] row : dp) {
            Arrays.fill(row, 0);
        }
        for (int[] row : prefix) {
            Arrays.fill(row, 0);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                prefix[i][j] = prefix[i][j - 1] + plates[i - 1][j - 1];
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= p; j++) {
                //x no of plates taking for the current row
                for (int x = 0; x <= Math.min(k, j); x++) { //Math.min(k,j) means, plates I want to pick is j(4 plates) but there are 6 plates in the row, so i can pick min only
                        dp[i][j] = Math.max(dp[i][j], prefix[i][x] + dp[i - 1][j - x]); //dp[i][x] - picking x plates from the current row and dp[i-1][j-x] - picking remaining plates from the previous row
                }
            }
        }

        for (int[] row : dp) {
            System.out.println(Arrays.toString(row));
        }
        return dp[n][p];
    }
}
