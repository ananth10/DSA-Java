package com.example.myapplication.dynamic_programming.strings;

import java.util.Arrays;

public class WildCardMatching {
    static String s = "abcdef";
    static String p = "ab*e?";

    public static void main(String[] args) {

        int[][] dp = new int[s.length()][p.length()];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int result = wildMatch(0, 0, dp);

        System.out.println("Result TopDown :" + (result == 1));
    }

    //TopDown approach
    static int wildMatch(int i, int j, int[][] dp) {
        //base case
        if (i == s.length() && j == p.length())
            return 1;
        if (j == p.length())
            return 0;
        if (i == s.length()) {
            for (int k = 0; k < p.length(); k++) {
                if (p.charAt(k) != '*') {
                    return 0;
                }
            }
            return 1;
        }

        if (dp[i][j] != -1)
            return dp[i][j];

        //recursive case
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            return dp[i][j] = wildMatch(i + 1, j + 1, dp);
        }
        if (p.charAt(j) == '*') {
            return dp[i][j] = wildMatch(i, j + 1, dp) | wildMatch(i + 1, j, dp);
        }

        return dp[i][j] = 0;
    }
}
