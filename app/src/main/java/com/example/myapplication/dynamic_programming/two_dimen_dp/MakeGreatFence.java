package com.example.myapplication.dynamic_programming.two_dimen_dp;

import java.util.Arrays;

public class MakeGreatFence {

    public static void main(String[] args) {

        int[] boards = {2, 2, 3};
        int[] rubles = {4, 1, 5};

        int n = boards.length;
        int limit = 3;  // we can try upto 0(not adding rubles) 1(adding 1 ruble) and 2 (adding 2 ruble)

        int result = minRublesForGreatFence(boards, rubles, n, limit);
        System.out.println("Bottom Up Result:" + result);
    }

    private static int minRublesForGreatFence(int[] boards, int[] rubles, int n, int limit) {
        int[][] dp = new int[n][3];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        //initialize first board with rubles , taking 0,1,2 rubles
        //try 3 cases for the first board,
        dp[0][0] = 0;
        dp[0][1] = rubles[0];
        dp[0][2] = 2 * rubles[0];

        for (int i = 1; i < n; i++) { //iterate over boards
            for (int j = 0; j < 3; j++) { //iterate over rubles
                for (int k = 0; k < 3; k++) { //iterate over previous board
                    if (boards[i - 1] + j != boards[i] + k) { //we can make great fence by adjacent board height should not be same
                        dp[i][k] = Math.min(dp[i][k], dp[i - 1][j] + k * rubles[i]);
                    }
                }
            }
        }

        return Math.min(Math.min(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]);
    }
}
