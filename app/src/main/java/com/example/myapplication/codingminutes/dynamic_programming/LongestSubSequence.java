package com.example.myapplication.codingminutes.dynamic_programming;

import java.util.Arrays;

public class LongestSubSequence {

    public static void main(String[] args) {
        int[] input = {50, 4, 10, 8, 30, 100};
        int LCS = longestCommonSubSequence(input);
        System.out.println("LCS:" + LCS);
    }

    static int longestCommonSubSequence(int[] input) {
        int n = input.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);//initial length will be 1 for all element

        int len = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (input[i] > input[j]) { //current value should be greater than the previous value, so then only we can form sorted longest common subsequence
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                    len = Math.max(len, dp[i]);
                }
            }
        }
        return len;
    }
}
