package com.example.myapplication.dynamic_programming.problems;

public class Stone {

    static int n = 4; //no of stones
    static int[] k = {2, 3}; //no of moves

    static int[] dp = new int[n + 1];

    public static void main(String[] args) {

        int result = stone();

        if (result == 1) {
            System.out.println("First");
        } else {
            System.out.println("Second");
        }
    }

    private static int stone() {
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            dp[i] = 0;
            for (int j = 0; j < k.length; j++) {
                if (i - k[j] >= 0 && dp[i - k[j]] == 0) {
                    dp[i] = 1;
                    break;
                }
            }
        }

        return dp[n];

    }
}
