package com.example.myapplication.codingminutes_levelup.dynamic_programming_2D;

import java.util.Arrays;

/**
 * Edit Distance
 * Given two strings str1 and str2 and below operations that can performed on str1. Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.
 * Insert
 * Remove
 * Replace
 * All of the above operations are of equal cost.
 * Input Format
 * Function contains two strings str1 and str2 as parameters.
 * Output Format
 * Return a single integer representing minimum number of operations required to convert str1 to str2
 * Constraints
 * 1 <= str1.length() <= 100
 * 1 <= str2.length() <= 100
 * Sample Testcases:
 * Input:   str1 = "geek", str2 = "gesek"
 * Output:  1
 * We can convert str1 into str2 by inserting a 's'.
 * <p>
 * Input:   str1 = "cat", str2 = "cut"
 * Output:  1
 * We can convert str1 into str2 by replacing 'a' with 'u'.
 * <p>
 * Input:   str1 = "sunday", str2 = "saturday"
 * Output:  3
 * Last three and first characters are same.  We basically
 * need to convert "un" to "atur".  This can be done using
 * below three operations.
 * Replace 'n' with 'r', insert t, insert a
 */
public class EditDistance {

    public static void main(String[] args) {
        String s1 = "cat";
        String s2 = "cut";
        int n1 = s1.length();
        int n2 = s2.length();

        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int operations = editOperation(s1, s2, n1, n2, dp);
        System.out.println("TEST:" + operations);
    }

    private static int editOperation(String s1, String s2, int n1, int n2, int[][] dp) {

        //base case
        if (n1 == 0) {
            return n2;
        }
        if (n2 == 0) {
            return n1;
        }

        if (dp[n1][n2] != -1) {
            return dp[n1][n2];
        }

        //recursive case
        if (s1.charAt(n1 - 1) == s2.charAt(n2 - 1)) {
            return dp[n1][n2] = editOperation(s1, s2, n1 - 1, n2 - 1, dp);
        } else {
            int op1 = editOperation(s1, s2, n1, n2 - 1, dp);//insert operation
            int op2 = editOperation(s1, s2, n1 - 1, n2, dp);//remove operation
            int op3 = editOperation(s1, s2, n1 - 1, n2 - 1, dp);//replace operation

            dp[n1][n2] = 1 + Math.min(op1, Math.min(op2, op3));
        }

        return dp[n1][n2];
    }
}
