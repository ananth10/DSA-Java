package com.example.myapplication.dynamic_programming.strings;

import java.util.Arrays;

public class LongestCommonSubString {
    static String a = "abcd";
    static String b = "abzd";

    static int ans = 0;

    public static void main(String[] args) {

        int[][] dp = new int[100][100];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int result = lcSubString(0, 0, dp);

        System.out.println("Result TopDown:" + result);

        int result1 = lcsubStringBtm();
        System.out.println("Result BottomUp:" + result1);
    }

    //TopDown
    static int lcSubString(int i, int j, int[][] dp) {
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

        int answer = 0;
        if (a.charAt(i) == b.charAt(j)) {
            answer = 1 + lcSubString(i + 1, j + 1, dp);
        }

        return dp[i][j] = Math.max(dp[i][j], answer);
    }


    //lcs bottom up
    static int lcsubStringBtm() {
        int ans = 0;
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
                    ans = Math.max(dp[i][j], ans);
                }
            }
        }

        return ans;
    }
}
