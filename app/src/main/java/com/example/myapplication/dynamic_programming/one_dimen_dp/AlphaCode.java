package com.example.myapplication.dynamic_programming.one_dimen_dp;

import java.util.Arrays;


public class AlphaCode {
    static String input = "25114";

    public static void main(String[] arg) {
        int[] dp = new int[input.length()];
        Arrays.fill(dp, -1);
        int result = alphaCodeTopDown(0, dp);
        System.out.println("TopDown Result: " + result);
        System.out.println("BottomUp Result: " + alphaCodeBottomUp());
    }


    private static int alphaCodeTopDown(int index, int[] dp) {
        //base case
        if (index == input.length()) {
            return 1;
        }

        if (dp[index] != -1) {
            return dp[index];
        }
        //recursive case
        int ans = 0;
        if (input.charAt(index) >= '1' && input.charAt(index) <= '9') {
            ans += alphaCodeTopDown(index + 1, dp);
        }
        if (index + 1 < input.length() && input.charAt(index) == '1') {
            ans += alphaCodeTopDown(index + 2, dp);
        }
        if (index + 1 < input.length() && input.charAt(index) == '2' && input.charAt(index + 1) <= '6') {
            ans += alphaCodeTopDown(index + 2, dp);
        }

        return dp[index] = ans;
    }

    private static int alphaCodeBottomUp() {
        int[] dp = new int[input.length()+1];
        Arrays.fill(dp, -1);
        dp[input.length()] = 1;

        for (int i = input.length() - 1; i >= 0; i--) {
           int ans = 0;

            if (input.charAt(i) >= '1' && input.charAt(i) <= '9') {
                ans += dp[i+1];
            }
            if (i + 1 < input.length() && input.charAt(i) == '1') {
                ans += dp[i+2];
            }
            if (i + 1 < input.length() && input.charAt(i) == '2' && input.charAt(i + 1) <= '6') {
                ans += dp[i+2];
            }
            dp[i] = ans;
        }

        return dp[0];
    }
}
