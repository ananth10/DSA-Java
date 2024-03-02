package com.example.myapplication.dynamic_programming.strings;

import java.util.Arrays;

public class LongestCommonSubSequence {

    static String a = "abababab";
    static String b = "bcbb";

    public static void main(String[] args) {
        int[][] dp = new int[100][100];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int result = lcs(0, 0, dp);

        System.out.println("result topDown:" + result);

        int result1 = lcsBtm();
        System.out.println("result bottomUp:" + result1);
    }

    //TopDown
    static int lcs(int i, int j, int[][] dp) {
        //base case
        if (i == a.length() && j == b.length())
            return 0;
        if (i == a.length())
            return 0;
        if (j == b.length())
            return 0;

        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int ans;
        if (a.charAt(i) == b.charAt(j)) {
            ans = 1 + lcs(i + 1, j + 1, dp);
        } else {
            ans = Math.max(lcs(i + 1, j, dp), lcs(i, j + 1, dp));
        }

        return dp[i][j] = ans;
    }

    //lcs
    static int lcsBtm() {
        int[][] dp = new int[a.length() + 1][b.length() + 1];

        if (a.length() == 0 && b.length() == 0)
            return 0;

        for (int i = 0; i <= a.length(); i++) {
            for (int j = 0; j <= b.length(); j++) {

                //if a string is empty
                if (i == 0) {
                    dp[0][j] = 0;
                } else if (j == 0) { //if b string is empty
                    dp[i][0] = 0;
                } else if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[a.length()][b.length()];
    }
}
