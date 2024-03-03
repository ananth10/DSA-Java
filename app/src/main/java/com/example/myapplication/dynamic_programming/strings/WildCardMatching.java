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


        int result1 = wildMatchBtmUp();
        System.out.println("Result BottomUp :" + (result1 == 1));
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

    //bottom up
    static int wildMatchBtmUp() {
        int[][] dp = new int[s.length() + 1][p.length() + 1];

        boolean makeAll = false;
        //base case
        dp[0][0] = 1; //both string and pattern are empty

        //if pattern is empty
        for (int i = 1; i <= s.length(); i++) {
            dp[i][0] = 0;
        }
        //if string is empty
        for (int k = 1; k < p.length(); k++) {
            if (k == 1 && p.charAt(0) == '*') {
                dp[0][k] = 1;
                makeAll = true;
            } else {
                if (makeAll)
                    dp[0][k] = 1;

            }
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {

                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] | dp[i - 1][j];
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
