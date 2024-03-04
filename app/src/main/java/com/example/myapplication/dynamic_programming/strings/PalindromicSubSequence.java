package com.example.myapplication.dynamic_programming.strings;

import java.util.Arrays;

public class PalindromicSubSequence {

    static String s = "bbbab";

    public static void main(String[] args) {


        int[][] dp = new int[s.length() + 1][s.length() + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int result = isPali(0, s.length() - 1, dp);
        System.out.println("Result: " + result);
    }

    static int isPali(int i, int j, int[][] dp) {
        //base case
        if (i == j)
            return 1;
        if (i == j - 1 && s.charAt(i) == s.charAt(j))
            return 2;

        if (dp[i][j] != -1)
            return dp[i][j];
        //recursive case
        if (s.charAt(i) == s.charAt(j)) {
            return dp[i][j] = 2 + isPali(i + 1, j - 1, dp);
        }
        return dp[i][j] = Math.max(isPali(i + 1, j, dp), isPali(i, j - 1, dp));
    }
}
