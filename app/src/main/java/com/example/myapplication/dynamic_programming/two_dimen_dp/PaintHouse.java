package com.example.myapplication.dynamic_programming.two_dimen_dp;

public class PaintHouse {

    public static void main(String[] args) {
        int house = 3;
        int pColors = 3;

        int[][] cost = {
                {14, 11, 14},
                {2, 14, 3,},
                {11, 5, 10}
        };

        int result = minCostToPaintHouse(house, pColors, cost);
        System.out.println("Bottom Up Result:" + result);
    }

    private static int minCostToPaintHouse(int house, int pColors, int[][] cost) {
        int[][] dp = new int[house][pColors];
        //base case
        dp[0][0] = cost[0][0];
        dp[1][0] = cost[1][0];
        dp[2][0] = cost[2][0];

        //iterate over ith house
        for (int j = 1; j < house; j++) {
            dp[0][j] = dp[1][j] = dp[2][j] = Integer.MAX_VALUE;
            //iterate over paint
            for (int i = 0; i < pColors; i++) {

                //iterate over paint_dash

                for (int i_ = 0; i_ < pColors; i_++) {

                    if (i_ != i) { //i_ previous house color and j-1 previous house
                        dp[i][j] = Math.min(dp[i][j], dp[i_][j - 1] + cost[i][j]);
                    }
                }
            }
        }
        return Math.min(Math.min(dp[0][2], dp[1][2]), dp[2][2]);
    }
}
