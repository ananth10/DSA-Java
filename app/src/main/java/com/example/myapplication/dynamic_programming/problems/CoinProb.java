package com.example.myapplication.dynamic_programming.problems;

public class CoinProb {
    static int n = 3;
    static double[] pi = {0.30,0,60,0,80};

    public static void main(String[] args) {

        long result = coinProb();

        System.out.println("Result:" + result);
    }

    static long coinProb() {

        long ans = 0;

        for (int i = (n / 2 + 1); i <= n; i++) {
            ans += helper(0, i, n - i);
        }

        return ans;
    }

    static int helper(int i, int h, int t) {
        if (i == n) return (int) 1.00;
        int ans = 0;
        if (h!=0) {
            ans += helper(i + 1, h - 1, t) * pi[i];
        }
        if (t!=0) {
            ans += helper(i + 1, h, t - 1) * (1.00 - pi[i]);
        }

        return ans;
    }
}
