package com.example.myapplication.dynamic_programming.combinotric;

public class OrderedSets {
    public static void main(String[] args) {
        int n = 5;

        int[] dp = new int[n + 1];
        int result = countNumOfWays(n, dp);
        System.out.println("TopDown Result: " + result);
        int result1 = countNumOfWays1(n);
        System.out.println("Bottom Result: " + result1);
    }

    //TopDown approach
    private static int countNumOfWays(int n, int[] dp) {
        //base case
        if (n == 0)
            return 1;
        if (dp[n] != 0) {
            return dp[n];
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += countNumOfWays(n - i, dp);
        }
        return ans;
    }

    //Bottom Up Approach
    private static int countNumOfWays1(int n) {
        int[] dp = new int[n + 1];

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = sum + 1;
            sum += dp[i];
        }
        return dp[n];
    }
}
