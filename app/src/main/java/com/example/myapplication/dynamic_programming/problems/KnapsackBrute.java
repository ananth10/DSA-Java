package com.example.myapplication.dynamic_programming.problems;

public class KnapsackBrute {
    static int w = 8;
    static int[] values = {30, 50, 60};
    static int[] wts = {3, 4, 5};

    static int n = values.length;

    public static void main(String[] args) {

        int result = knapsackBrute(0, 0);
        System.out.println("Result:" + result);
    }

   private static int knapsackBrute(int i, int wt) {

        //base case
        if (i >= n)
            return 0;

        int take = 0;
        if (wt + wts[i] <= w) {
            take = values[i] + knapsackBrute(i + 1, wt + wts[i]);
        }
        int notTake = knapsackBrute(i + 1, wt);

        return Math.max(take, notTake);
    }
}
