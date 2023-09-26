package com.example.myapplication.codingminutes_levelup.dynamic_programming;


import java.util.Arrays;

/**
 * Given a ladder of size N, and in integer k, write a function to be compute number of ways to climb the ladder if you can take a jump of atmost K at every step
 * <p>
 * Input:
 * N = 4
 * K = 3
 * Output
 * 7
 */
public class Ladder {

    public static void main(String[] args) {
        int n = 4;
        int k = 3;

        int[] dp = new int[n + 1];
        Arrays.fill(dp, 0);
        int result = ladderTopDown(n, k, dp);
        int result1 = ladderRecursion(n, k);
        int result2 = ladderBottomUp(n, k);
        int result3 = ladderOptimized(n, k);
        System.out.println("Topdown Result:" + result);
        System.out.println("Recursion Result:" + result1);
        System.out.println("Bottomup Result:" + result2);
        System.out.println("Optimised Result:" + result3);
    }


    //recursion - O(k^n)

    private static int ladderRecursion(int n, int k) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }

        int ans = 0;

        for (int i = 1; i <= k; i++) {
            ans += ladderRecursion(n - i, k);
        }

        return ans;
    }

    //topdown approach - O(n*k)
    private static int ladderTopDown(int n, int k, int[] dp) {
        //base case
        if (n == 0 || n == 1) {
            return 1;
        }

        if (n < 0) {
            return 0;
        }

        if (dp[n] != 0) {
            return dp[n];
        }

        int ans = 0;

        for (int jump = 1; jump <= k; jump++) {
            ans += ladderRecursion(n - jump, k);
        }

        return dp[n] = ans;
    }

    //bottomUp approach - O(n*k)
    private static int ladderBottomUp(int n, int k) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 0);

        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int jump = 1; jump <= k; jump++) {
                if (i - jump >= 0) {
                    dp[i] += dp[i - jump];
                }
            }
        }

        return dp[n];
    }

    //BottomUp - Optimized Approach - O(n+k)
    private static int ladderOptimized(int n, int k) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 0);

        dp[0] = 1;
        dp[1] = 1;

        //dp[i] = 2dp[i-1]
        for (int i = 2; i <= k; i++) { //iterate till k steps from the initial value, because dp[i-k-1] index will not be exist
            dp[i] = 2 * dp[i - 1];
        }
        //dp[i] = 2dp[i-1] - dp[i-k-1]
        for (int j = k + 1; j <= n; j++) { //iterate from k step to till n steps
            dp[j] = 2 * dp[j - 1] - dp[j - k - 1];
        }

        return dp[n];
    }
}
