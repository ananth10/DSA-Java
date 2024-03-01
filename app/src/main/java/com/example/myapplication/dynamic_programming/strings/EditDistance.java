package com.example.myapplication.dynamic_programming.strings;

import java.util.Arrays;

public class EditDistance {
    static String a = "food";
    static String b = "monkey";

    public static void main(String[] args) {


        int[][] dp = new int[2000][2000];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int minOperations = editDistance(0, 0, dp);

        System.out.println("Result TopDown: " + minOperations);

        int minOpe = editDis();

        System.out.println("Result BottomUp: " + minOpe);
    }

    //TopDown
    private static int editDistance(int i, int j, int[][] dp) {
        //base cases
        if (i == a.length() && j == b.length())
            return 0;
        if (i == a.length())
            return b.length() - j;
        if (j == b.length())
            return a.length() - i;

        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int ans;
        if (a.charAt(i) != b.charAt(j)) {
            ans = 1 + Math.min(Math.min(editDistance(i + 1, j, dp), editDistance(i, j + 1, dp)), editDistance(i + 1, j + 1, dp));
        } else {
            ans = editDistance(i + 1, j + 1, dp);
        }
        return dp[i][j] = ans;
    }

    //BottomUp
    private static int editDis() {
        int[][] dp = new int[a.length() + 1][b.length() + 1];


        if (0 == a.length() && 0 == b.length())
            return 0;

        for (int i = 0; i <= a.length(); i++) {
            for (int j = 0; j <= b.length(); j++) {

                //insert all chars from second string, if first string is empty
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) { //insert all chars from first string, if second string is empty
                    dp[i][j] = i;
                } else if (a.charAt(i - 1) != b.charAt(j - 1)) {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }

        for (int[] row : dp) {
            System.out.println(Arrays.toString(row));
        }

        return dp[a.length()][b.length()];
    }
}
