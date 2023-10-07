package com.example.myapplication.codingminutes_levelup.dynamic_programming_2D;

import java.util.Arrays;

/**
 * Count SubSequence
 * ----------------
 * <p>
 * Given 2 strings, find the number of times the second string occurs as subsequence in the first string
 * INPUT:
 * s1 = "ABCDCE"
 * s2 = "ABC"
 */
public class CountSubSequence {
    public static void main(String[] args) {
        String s1 = "ABCDCE";
        String s2 = "ABC";
        int i = s1.length() - 1;
        int j = s2.length() - 1;

        int count = countSubRecursion(s1, s2, i, j);
        System.out.println("Recursion Result:" + count);

        int[][] dp = new int[i + 1][j + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int count1 = countTopDown(s1, s2, i, j, dp);
        System.out.println("TopDown Result:" + count1);

        int count2 = countBottomUp(s1, s2);
        System.out.println("BottomUp Result:" + count2);

    }

    private static int countSubRecursion(String s1, String s2, int i, int j) {

        //base case
        if ((i == -1 && j == -1) || j == -1) {
            return 1;
        }
        if (i == -1) {
            return 0;
        }

        //recursive case
        if (s1.charAt(i) == s2.charAt(j)) {
            return countSubRecursion(s1, s2, i - 1, j - 1) + countSubRecursion(s1, s2, i - 1, j);
        }

        return countSubRecursion(s1, s2, i - 1, j);
    }

    //TopDown approach
    private static int countTopDown(String s1, String s2, int i, int j, int[][] dp) {
        //base case
        if ((i == -1 && j == -1) || j == -1) {
            return 1;
        }
        if (i == -1) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        //recursive case
        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = countSubRecursion(s1, s2, i - 1, j - 1) + countSubRecursion(s1, s2, i - 1, j);
        }
        return dp[i][j] = countSubRecursion(s1, s2, i - 1, j);
    }

    //BottomUp

    private static int countBottomUp(String s1, String s2) {
        int i = s1.length() - 1;
        int j = s2.length() - 1;

        int[][] dp = new int[i + 1][j + 1];
        for (int[] row : dp) {
            Arrays.fill(row, 0);
        }
        //fill the first column when the s2 is empty
        for (int k = 0; k <= i; k++) {
            dp[k][0] = 1;
        }

        for (int row = 1; row <= i; row++) {
            for (int col = 1; col <= j; col++) {
                if (s1.charAt(row - 1) == s2.charAt(col)) {
                    dp[row][col] = dp[row - 1][col - 1] + dp[row - 1][col];
                } else {
                    dp[row][col] = dp[row - 1][col];
                }
            }
        }

        //print dp
        for (int k = 0; k <= i; k++) {
            for (int l = 0; l <= j; l++) {
                System.out.print(dp[k][l] + " ");
            }
            System.out.println();
        }

        return dp[i][j];
    }
}
