package com.example.myapplication.dynamic_programming.problems;

public class FragJump {
    static int k = 4;
    static int[] cost = {40, 10, 20, 70, 80, 10, 20, 70, 80, 60};

    static int n = cost.length;
    static int[] dp = new int[n];

    public static void main(String[] args) {


        int result = minCost(k, cost);
        System.out.println("Result:" + result);
        printPath(n-1);
    }

    static int minCost(int k, int[] cost) {
        dp[0] = 0;
        dp[1] = dp[0] + Math.abs(cost[1] - cost[0]);

        for (int i = 2; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int kk = 0; kk <= k && (i - kk) >= 0; kk++) {
                dp[i] = Math.min(dp[i], dp[i - kk] + Math.abs(cost[i] - cost[i - kk]));
            }
        }
        return dp[n - 1];
    }

    static void printPath(int i){
        System.out.print("index: "+i + " Cost: "+cost[i] +"->");
        for (int kk = 1; kk <= k && (i - kk) >= 0; kk++) {
            if(dp[i] == dp[i - kk] + Math.abs(cost[i] - cost[i - kk])){
                printPath(i - kk);
                return;
            }
        }
    }
}
