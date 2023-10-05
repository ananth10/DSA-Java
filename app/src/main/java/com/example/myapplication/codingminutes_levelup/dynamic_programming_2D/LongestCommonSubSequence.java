package com.example.myapplication.codingminutes_levelup.dynamic_programming_2D;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * LCS
 * ----
 * Given two sequence, find the length of longest subsequence which is common to both of them
 * INPUT:
 * s1 = "ABCD"
 * s2 = "ABEDG"
 * OUTPUT:
 * 3 - (ABD)
 */
public class LongestCommonSubSequence {

    public static void main(String[] args) {
        String s1 = "ABCD";
        String s2 = "ABEDG";
        int i = 0;
        int j = 0;

        int result = lcsRecursion(s1, s2, i, j);
        System.out.println("Recursion Result:" + result);

        int[][] dp = new int[s1.length()][s2.length()];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int result1 = lcsTopDown(s1, s2, 0, 0, dp);
        System.out.println("TopDown Result:" + result1);


        int result3 = lcsBottomUp(s1, s2);
        System.out.println("BottomUp:" + result3);

    }

    //recursion
    private static int lcsRecursion(String s1, String s2, int i, int j) {
        //base case
        if (i == s1.length() || j == s2.length()) {
            return 0;
        }
        //recursive case
        if (s1.charAt(i) == s2.charAt(j)) {
            return 1 + lcsRecursion(s1, s2, i + 1, j + 1);
        }

        int op1 = lcsRecursion(s1, s2, i + 1, j);
        int op2 = lcsRecursion(s1, s2, i, j + 1);

        return Math.max(op1, op2);
    }

    //TopDown

    private static int lcsTopDown(String s1, String s2, int i, int j, int[][] dp) {
        //base case
        if (i == s1.length() || j == s2.length()) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = 1 + lcsTopDown(s1, s2, i + 1, j + 1, dp);
        }
        int op1 = lcsTopDown(s1, s2, i + 1, j, dp);
        int op2 = lcsTopDown(s1, s2, i, j + 1, dp);
        return dp[i][j] = Math.max(op1, op2);
    }

    //BottomUp
    private static int lcsBottomUp(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int[] row : dp) {
            Arrays.fill(row, 0);
        }

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    int op1 = dp[i - 1][j];
                    int op2 = dp[i][j - 1];
                    dp[i][j] = Math.max(op1, op2);
                }
            }
        }

        int i = n1;
        int j = n2;
        List<Character> result = new ArrayList<>();
        while (i != 0 && j != 0) {
            if (dp[i][j] == dp[i - 1][j]) {
                i--;
            } else if (dp[i][j] == dp[i][j - 1]) {
                j--;
            } else {
                result.add(s1.charAt(i - 1));
                i--;
                j--;
            }
        }

        Collections.reverse(result);
        System.out.println("LCS:" + result);
        return dp[n1][n2];
    }
}
