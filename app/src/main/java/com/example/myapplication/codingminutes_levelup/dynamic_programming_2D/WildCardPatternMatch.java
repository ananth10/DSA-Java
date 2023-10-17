package com.example.myapplication.codingminutes_levelup.dynamic_programming_2D;

import java.util.Arrays;

/**
 * Wildcard Pattern Matching
 * ------------------------
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching algorithm that finds if wildcard pattern is matched with input string.
 * The wildcard pattern can include the characters ‘?’ and ‘*’ :
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 * For example,
 * Text = "baaabab",
 * Pattern = “**ba**ab", output : true
 * Pattern = "baaa?ab", output : true
 * Pattern = "ba*a?", output : true
 * Pattern = "a*ab", output : false
 * <p>
 * Input Format:
 * Two strings s and p.
 * Output Format:
 * Return TRUE if s matches with p otherwise FALSE.
 * Constraints
 * 1 <= s.length() <= 100
 * 1 <= p.length() <= 100
 * Constraints:
 * 1 <= s.length() <= 100
 * 1 <= p.length() <= 100
 */
public class WildCardPatternMatch {
    public static void main(String[] args) {
        String s = "baaabab";
        String p = "**ba**ab";

        int n = s.length();
        int m = p.length();

        int[][] dp = new int[n + 1][m + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int ans = patternMatch(s.toCharArray(), p.toCharArray(), n, m, dp);
        if (ans == 1) {
            System.out.println("Pattern matched");
        } else {
            System.out.println("Pattern not matched");
        }

        boolean ans1 = patternMatch(s, p);
        System.out.println("Bottom Up:" + ans1);
    }

    //Top Down Approach
    private static int patternMatch(char[] s, char[] p, int n, int m, int[][] dp) {
        //base case
        if (n == 0 && m == 0) {
            return 1;
        }
        if (m == 0) {
            return 0;
        }
        if (n == 0) {
            while (m > 0) {
                if (p[m - 1] != '*') {
                    return 0;
                }
                m--;
            }
            return 1;
        }

        if (dp[n][m] != -1) {
            return dp[n][m];
        }

        if (p[m - 1] == '*') {
            int op1 = patternMatch(s, p, n - 1, m, dp);
            int op2 = patternMatch(s, p, n, m - 1, dp);
            return dp[n][m] = Math.max(op1, op2);
        } else if (p[m - 1] == '?') {
            return dp[n][m] = patternMatch(s, p, n - 1, m - 1, dp);
        } else if (s[n - 1] == p[m - 1]) {
            return dp[n][m] = patternMatch(s, p, n - 1, m - 1, dp);
        } else {
            return dp[n][m] = 0;
        }
    }

    //Bottom Up approach

    private static boolean patternMatch(String s, String p) {
        char[] str = s.toCharArray();
        char[] ptr = p.toCharArray();

        //replace multiple * with one *
        //eg ab***nm -> ab*nm

        int index = 0;
        boolean isFirst = true;
        for (int i = 0; i < ptr.length; i++) {
            if (ptr[i] == '*') {
                if (isFirst) {
                    ptr[index++] = ptr[i];
                    isFirst = false;
                }
            } else {
                ptr[index++] = ptr[i];
                isFirst = true;
            }
        }

        boolean[][] dp = new boolean[str.length + 1][ptr.length + 1];
        if (index > 0 && ptr[0] == '*') {
            dp[0][1] = true;
        }
        dp[0][0] = true;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (ptr[j - 1] == '?' || str[i - 1] == ptr[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (ptr[j - 1] == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
        return dp[str.length][index];
    }
}
