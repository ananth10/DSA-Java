package com.example.myapplication.dynamic_programming.problems;

public class Vacations {

    static int[][] cost = {{10, 40, 70}, {20, 50, 80}, {30, 60, 90}};
    static int n = cost.length;
    static int k = cost[0].length;

    static int[][] dp = new int[n][k];


    public static void main(String[] args) {

        int result = maxHappiness();
        System.out.println("Result: " + result);
    }


    static int maxHappiness() {
        //first day can do any activity
        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];

        for (int i = 1; i < n; i++) { //days
            for (int j = 0; j < k; j++) { //activity
                for (int jj = 0; jj < k; jj++) { //previous day activity
                    if (j != jj) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][jj] + cost[i][j]);
                    }
                }
            }
        }

        return Math.max(Math.max(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]);
    }

}
