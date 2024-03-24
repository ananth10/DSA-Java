package com.example.myapplication.dynamic_programming.problems;

import java.util.Arrays;

public class Slimes {

    static int[] a = {10, 20, 30, 40};
    static int n = a.length;

    static int[] preSum = new int[n];

    static int[][] dp = new int[n][n];

    public static void main(String[] args) {
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        setPrefSum();
        int result = minCostOfSlimes(0, n - 1);

        System.out.println("Result:" + result);
    }

    static void setPrefSum() {
        preSum[0] = a[0];
        for (int i = 1; i < n; i++) {
            preSum[i] += preSum[i - 1] + a[i];
        }
    }

    static int minCostOfSlimes(int l, int r) {
        if (l == r) return 0;
        if (dp[l][r] != Integer.MAX_VALUE) {
            return dp[l][r];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = l; i < r; i++) {
            ans = Math.min(ans, (minCostOfSlimes(l, i) + minCostOfSlimes(i + 1, r)));
        }
        ans += sum(l, r);
        return dp[l][r] = ans;
    }

    static int sum(int l, int r) {
        return preSum[r] - (l == 0 ? 0 : preSum[l - 1]);
    }
}
