package com.example.myapplication.dynamic_programming.problems;

import java.util.Arrays;

public class Deque {

    static int[] a = {10, 80, 90, 30};

    static int n = a.length;
    static int sum = 0;

    static int[][][] dp = new int[n][n][2];

    static int[][] dp1 = new int[n][n];

    public static void main(String[] args) {
        for (int x : a) {
            sum += x;
        }
        setDefault();

        int result = deque(0, n - 1, 0);
        System.out.println("Result:" + result);
        for (int[] row : dp1) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        int result1 = deq(0, n - 1);
        System.out.println("Result1:" + result1);
    }

    static void setDefault() {
        for (int[][] x : dp) {
            for (int[] row : x) {
                Arrays.fill(row, Integer.MAX_VALUE);
            }
        }
    }

    static int deque(int i, int j, int turn) {
        //base case
        if (i > j)
            return 0;

        //recursive case
        if (dp[i][j][turn] != Integer.MAX_VALUE) {
            return dp[i][j][turn];
        }
        int ans = 0;
        if (turn == 0) { //taro's turn
            ans += Math.max(a[i] + deque(i + 1, j, 1 - turn), a[j] + deque(i, j - 1, 1 - turn));
        } else {
            ans += Math.min(deque(i + 1, j, 1 - turn), deque(i, j - 1, 1 - turn));
        }

        return dp[i][j][turn] = ans;
    }

    static int deq(int i, int j) {
        //base case
        if (i == 0)
            return a[i];
        if (dp1[i][j] != Integer.MIN_VALUE) {
            return dp1[i][j];
        }
        return dp1[i][j] = Math.max(a[i] - deq(i + 1, j), a[j] - deq(i, j - 1));
    }
}
