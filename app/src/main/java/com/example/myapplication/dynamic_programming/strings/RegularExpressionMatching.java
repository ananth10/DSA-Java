package com.example.myapplication.dynamic_programming.strings;

import java.util.Arrays;

public class RegularExpressionMatching {
    static String s = "aa";
    static String r = ".*..a*";

    public static void main(String[] args) {

        int[][] dp = new int[s.length() + 1][r.length() + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int result = regulaExprMatch(0, 0, dp);
        System.out.println("Result TopDown: " + (result == 1));

        for (int[] row : dp) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("*******************");
        int result1 = regularExprMatchBottomUp();
        System.out.println("Result BottomUp: " + (result1 == 1));
    }


    static int regulaExprMatch(int i, int j, int[][] dp) {
        //base case
        if (i == s.length() && j == r.length())
            return 1;
        if (j == r.length())
            return 0;

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        //recursive case
        int ans = 0;
        if (j + 1 < r.length() && r.charAt(j + 1) == '*') {
            //case 1
            //char matches
            if (i < s.length() && (s.charAt(i) == r.charAt(j) || r.charAt(j) == '.')) {
                ans |= regulaExprMatch(i + 1, j, dp);
            }
            //no char matches
            ans |= regulaExprMatch(i, j + 2, dp);
        } else {
            if (i < s.length() && (s.charAt(i) == r.charAt(j) || r.charAt(j) == '.')) {
                ans |= regulaExprMatch(i + 1, j + 1, dp);
            }
        }
        return dp[i][j] = ans;
    }

    //BottomUp
    static int regularExprMatchBottomUp() {
        int[][] dp = new int[s.length() + 1][r.length() + 1];

        //base case
        dp[0][0] = 1; //both string and expr are empty

        //expression is empty
        for (int i = 1; i <= s.length(); i++) {
            dp[i][0] = 0;
        }

        //if String is empty
        for (int i = 2; i <= r.length(); i++) {
            if (r.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }

        //recursive case
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= r.length(); j++) {
                if (j > 1 && r.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2];
                    //case 1
                    //char matches
                    if (s.charAt(i - 1) == r.charAt(j - 2) || r.charAt(j - 2) == '.') {
                        dp[i][j] |= dp[i - 1][j];
                    }
                } else {
                    if (s.charAt(i - 1) == r.charAt(j - 1) || r.charAt(j - 1) == '.') {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }

        for (int[] row : dp) {
            System.out.println(Arrays.toString(row));
        }
        return dp[s.length()][r.length()];
    }
}
