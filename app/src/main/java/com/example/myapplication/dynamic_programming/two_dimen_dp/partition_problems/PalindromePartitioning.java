package com.example.myapplication.dynamic_programming.two_dimen_dp.partition_problems;

import java.util.Arrays;

public class PalindromePartitioning {

    public static void main(String[] args) {

        String s = "aab";
        int n = s.length();

        int[][] dp = new int[n + 1][n + 1];
        int[] minDp = new int[n+1];
        Arrays.fill(minDp,-1);
        int result = minCut(0, s, dp,minDp);
        System.out.println("Result:" + (result - 1));
    }

    private static boolean isPalindrome(int i, int j, String s, int[][] dp) {
        if (i == j)
            return true;
        if (i == j - 1)
            return s.charAt(i) == s.charAt(j);
        if (dp[i][j] != -1) {
            return dp[i][j] == 1;
        }
        boolean result = isPalindrome(i + 1, j - 1, s, dp) && s.charAt(i) == s.charAt(j);
        dp[i][j] = result ? 1 : 0;
        return result;
    }

    private static int minCut(int i, String s, int[][] dp,int[]minDp) {

        if (i == s.length()) {
            return 0;
        }
        if(minDp[i]!=-1){
            return minDp[i];
        }
        int ans = Integer.MAX_VALUE;
        for (int j = i; j < s.length(); j++) {
            if (isPalindrome(i, j, s, dp)) {
                ans = Math.min(ans, minCut(j + 1, s, dp,minDp));
            }
            System.out.println("I:"+i + "J:"+j);
        }
        ans += 1;
        return minDp[i] = ans;
    }

}
