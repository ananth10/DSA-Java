package com.example.myapplication.codingminutes_levelup.dynamic_programming;

import java.util.Arrays;

/**
 * Counting Trees
 * --------------
 * Count number of binary search tree can be formed using N nodes, numbered from 1 to N.
 * See the two test cases.
 * Input:
 * 3
 * 4
 * Output
 * 5
 * 14
 * <p>
 * 1 2 3 ...i....8 9 10
 * f(N) = f(i-1)*f(n-i) //if ith node is root node then i-1 left bst can form and n-i right bst can form
 */
public class CountingTrees {

    public static void main(String[] args) {
        int n = 2;

        int[] dp = new int[n + 1];
        Arrays.fill(dp, 0);
        int count = countBstTopDown(n, dp);
        System.out.println("TopDown Result:" + count);
        int count1 = countTreeBottomUp(n);
        System.out.println("BottomUp Result:" + count1);
    }


    private static int countBstTopDown(int n, int dp[]) {
        //base case
        if (n == 0 || n == 1) {
            return 1;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            int x = countBstTopDown(i - 1, dp);
            int y = countBstTopDown(n - i, dp);
            ans += x * y;
        }

        return dp[n] = ans;
    }


    private static int countTreeBottomUp(int N) {
        int[] dp = new int[N + 1];
        Arrays.fill(dp, 0);

        dp[0] = 1;
        dp[1] = 1;

        int ans = 0;
        for (int n = 2; n <= N; n++) {
            for (int i = 1; i <= n; i++) {
                dp[i] += (dp[n - 1] * dp[n - i]);
            }
        }

        return dp[N];
    }
}
