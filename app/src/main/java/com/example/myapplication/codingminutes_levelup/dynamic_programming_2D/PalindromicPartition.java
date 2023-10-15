package com.example.myapplication.codingminutes_levelup.dynamic_programming_2D;

import java.util.Arrays;

/**
 * Palindromic Partitioning
 * Given a string s, your task is to partition s such that every substring of the partition is a palindrome.
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * Examples :
 * Input : str = “geek”
 * Output : 2
 * We need to make minimum 2 cuts, i.e., “g | ee | k”
 * <p>
 * Input : str = “aaaa”
 * Output : 0
 * The string is already a palindrome.
 * <p>
 * Input : str = “abcde”
 * Output : We need to make 4 cuts, i.e., “a | b | c | d | e”
 * <p>
 * Input : str = “abbac”
 * Output : 1 i.e., “abba | c”
 * <p>
 * Input Format
 * Function contains a string str as a parameter.
 * Output Format
 * Return a single integer representing minimum number of cuts needed for a palindrome partitioning of str.
 * Constraints
 * 1 <= str.length() <= 100
 */
public class PalindromicPartition {

    public static void main(String[] args) {
        String s = "geek";
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int result = minPartition(s, 0, n - 1, dp);
        System.out.println("Result:" + result);

        for (int[] row : dp) {
            System.out.println(Arrays.toString(row));
        }

    }

    private static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    //TopDown Approach
    private static int minPartition(String s, int i, int j, int[][] dp) {
        //base case
        if (i >= j || isPalindrome(s, i, j)) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int ans = Integer.MAX_VALUE;
        for (int k = i; k <j; k++) {
            int left = minPartition(s, i, k, dp);
            int right = minPartition(s, k + 1, j, dp);
            int partiInSub = 1 + left + right;
            ans = Math.min(ans, partiInSub);
        }
        return dp[i][j] = ans;
    }

    //Bottom up approach

}

