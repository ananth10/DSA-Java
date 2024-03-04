package com.example.myapplication.dynamic_programming.strings;

import java.util.Arrays;

public class InterleavingString {
    static String s1 = "aabcc";
    static String s2 = "dbbda";
    static String s3 = "aadbbcbcda";

    public static void main(String[] args) {

        int result = interLeaveTopDown();

        System.out.println("Result TopDown: " + (result == 1));
    }


    static int interLeaveTopDown() {
        if (s1.length() + s2.length() != s3.length())
            return 0;

        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return interLeave(0, 0, dp);
    }

    static int interLeave(int i, int j, int[][] dp) {
        int k = i + j;
        //base case
        if (k == s3.length())
            return 1;


        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        //recursive case
        int ans = 0;

        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            ans |= interLeave(i + 1, j,dp);
        }
        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            ans |= interLeave(i, j + 1,dp);
        }

        return dp[i][j] = ans;
    }
}
