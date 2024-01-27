package com.example.myapplication.dynamic_programming.two_dimen_dp;


import java.util.Arrays;

public class Knapsack {

    public static void main(String[] args) {
        int s = 4;
        int v = 5;

        int[] wts = {1, 2, 3, 2, 2};
        int[] values = {8, 4, 0, 5, 5};

        int maxValue = knapSackRecursion(s, v - 1, values, wts);
        System.out.println("Recursive Result:" + maxValue);

        int[][] dp = new int[s + 1][v + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int maxValues1 = knapSackTopdown(s, v - 1, values, wts, dp);
        System.out.println("TopDown Result:" + maxValues1);

        int maxValues2 = knapSackBottomUp(s, v, values, wts);
        System.out.println("BottomUp Result:" + maxValues2);

        int maxValues3 = knapSackBottomUpMemoryOpt(s, v, values, wts);
        System.out.println("BottomUp Memory Opt Result:" + maxValues3);
    }

    //recursive approach
    private static int knapSackRecursion(int s, int index, int[] values, int[] weights) {
        //base case
        if (index < 0) {
            return 0;
        }

        int include = Integer.MIN_VALUE;

        if (weights[index] <= s) {
            include = knapSackRecursion(s - weights[index], index - 1, values, weights) + values[index];
        }

        int exclude = knapSackRecursion(s, index - 1, values, weights);

        return Math.max(include, exclude);
    }

    //Top Down Approach
    private static int knapSackTopdown(int s, int index, int[] values, int[] weights, int[][] dp) {
        //base case
        if (index < 0) {
            return 0;
        }

        if (dp[s][index] != -1) {
            return dp[s][index];
        }

        int include = Integer.MIN_VALUE;

        if (weights[index] <= s) {
            include = knapSackRecursion(s - weights[index], index - 1, values, weights) + values[index];
        }

        int exclude = knapSackRecursion(s, index - 1, values, weights);

        return dp[s][index] = Math.max(include, exclude);
    }

    //Bottom Up Approach
    private static int knapSackBottomUp(int s, int index, int[] values, int[] weights) {
        int[][] dp = new int[s + 1][index + 1];
        for (int[] row : dp) {
            Arrays.fill(row, 0);
        }

        for (int w = 1; w <= s; w++) {

            for (int idx = 1; idx <= index; idx++) {

                int include = 0;
                if (weights[idx - 1] <= w) {
                    include = values[idx - 1] + dp[w - weights[idx - 1]][idx - 1];
                }
                int exclude = dp[w][idx - 1];

                dp[w][idx] = Math.max(include, exclude);
            }

        }

        return dp[s][index];
    }

    //Memory optimization using 2 rows

    private static int knapSackBottomUpMemoryOpt(int s, int index, int[] values, int[] weights) {
        int[][] dp = new int[2][s + 1];
        for (int[] row : dp) {
            Arrays.fill(row, 0);
        }


        for (int idx = 1; idx <= index; idx++) {

            for (int w = 1; w <= s; w++) {
                int include = 0;
                if (weights[idx - 1] <= w) {
                    include = values[idx - 1] + dp[0][w - weights[idx - 1]];
                }
                int exclude = dp[0][w];

                dp[1][w] = Math.max(include, exclude);
            }

            for (int i = 0; i <= s; i++) {
                dp[0][i] = dp[1][i];
            }

        }

        for (int[] row : dp) {
            System.out.println(Arrays.toString(row));
        }
        return dp[1][s];
    }

    //Memory optimization using 1 row

//    private static int knapSackBottomUpMemoryOptOneRow(int s, int index, int[] values, int[] weights) {
//        int[] dp = new int[s + 1];
//        Arrays.fill(dp, 0);
//
//
//        for (int idx = 1; idx <= index; idx++) {
//
//            for (int w = 1; w <= s; w++) {
//                int include = 0;
//                if (weights[idx - 1] <= w) {
//                    include = values[idx - 1] + dp[0][w - weights[idx - 1]];
//                }
//                int exclude = dp[0][w];
//
//                dp[1][w] = Math.max(include, exclude);
//            }
//
//            for (int i = 0; i <= s; i++) {
//                dp[0][i] = dp[1][i];
//            }
//
//        }
//
//        for (int[] row : dp) {
//            System.out.println(Arrays.toString(row));
//        }
//        return dp[1][s];
//    }
}
