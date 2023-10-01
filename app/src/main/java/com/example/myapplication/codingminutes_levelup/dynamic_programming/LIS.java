package com.example.myapplication.codingminutes_levelup.dynamic_programming;

import java.util.Arrays;

/**
 * Longest Increasing SubSequence
 * ------------------------------
 * Given a array sequence, find the length of the longest subsequence of such
 * that all elements of the subsequence are sorted in increasing order
 * <p>
 * INPUT:
 * arr{50,4,10,8,30,100}
 * <p>
 * OUTPUT:
 * 4
 */
public class LIS {

    public static void main(String[] args) {
        int[] arr = {50, 4, 10, 8, 30, 100};
        int n = arr.length;

        int length = lis(arr, n);
        System.out.println("Result: " + length);

        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int len = lisTopDown(arr,n,n-1,dp);
        System.out.println(Arrays.toString(dp));
        System.out.println("TopDown Result:"+len);
    }

    //BottomUp approach
    private static int lis(int[] arr, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int len = 1;
        if (n == 1) {
            return 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                    len = Math.max(len, dp[i]);
                }
            }
        }
        System.out.println(Arrays.toString(dp));

        return len;
    }

    //TopDown Approach

    private static int lisTopDown(int[] arr, int n, int i, int[] dp) {
        //base case
        if (i == 0) {
            return dp[i];
        }

        int ans = Integer.MIN_VALUE;
        for (int j = 0; j < i; j++) {
            if (arr[i] > arr[j]) {
                ans = Math.max(lisTopDown(arr, n, i - 1, dp), 1 + dp[j]);
            }
        }
        return dp[i] = Math.max(dp[i], ans);
    }
}
