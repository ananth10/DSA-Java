package com.example.myapplication.dynamic_programming.strings;

import java.util.Arrays;

public class PalindromicSubString {

    static String s = "abbaeae";

    public static void main(String[] args) {

        int result = palindromicSubString();

        System.out.println("Result TopDown: " + result);
    }


    static int palindromicSubString() {
        int n = s.length();
        int count = 0;
        int[][] dp = new int[s.length()][s.length()];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isPalindromic(i, j, dp) == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    static int isPalindromic(int i, int j, int[][] dp) {
        //base case
        if (i > j)
            return 1;

        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (s.charAt(i) != s.charAt(j)) {
            return dp[i][j] = 0;
        }
        return dp[i][j] = isPalindromic(i + 1, j - 1, dp);
    }
}
