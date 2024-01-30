package com.example.myapplication.dynamic_programming.two_dimen_dp;

import com.google.gson.Gson;

import java.util.ArrayList;

public class ColorfulKnapSack {
    public static void main(String[] args) {
        int n = 8; //stones
        int m = 3; //colors
        int w = 13; //knap sack weight
        int[] wts = {2, 3, 4, 2, 4, 5, 2, 3};
        int[] colors = {1, 1, 1, 2, 2, 2, 3, 3};

        int minUnusedCapacity = isColorfulKanpSackPossible(n, m, w, wts, colors);
        System.out.println("Bottom Up Result:" + minUnusedCapacity);

    }

    private static int isColorfulKanpSackPossible(int n, int m, int w, int[] wts, int[] colors) {
        int ans = 0;
        boolean[][] dp = new boolean[m + 1][w + 1];
        dp[0][0] = true;
        ArrayList<ArrayList<Integer>> colorWts = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            colorWts.add(new ArrayList<>());
        }
        //group by stone colors, so different weighted stones are combined by colors
        for (int i = 0; i < n; i++) {
            System.out.println("I:" + colors[i]);
            ArrayList<Integer> stones = colorWts.get(colors[i]-1);
            stones.add(wts[i]);
            colorWts.set(colors[i]-1,stones);
        }

        //iterate over colors from 1..m
        for (int i = 1; i <=m; i++) {
            boolean exists = false;
            //iterate over weights from 1..w
            for (int j = 0; j <=w; j++) {
                //traverse through all weights of ith color
                for (int wt : colorWts.get(i-1)) {
                    if (j - wt >= 0) {
                        dp[i][j] |= dp[i - 1][j - wt];
                    }
                }

                if (dp[i][j]) {
                    exists = true;
                }
            }

            //we cannot use ith color, thus there is no way to fill the knapsack with exactly m colors with total weight <=w
            if (!exists) {
                return -1;
            }
        }

        for (int i = w; i > 0; i--) {
            if (dp[m][i]) {
                return w - i;
            }
        }

        return ans;
    }
}
