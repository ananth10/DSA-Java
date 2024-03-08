package com.example.myapplication.dynamic_programming.bitmasks;

import kotlin.Pair;

public class ElevatorProblem {
    public static void main(String[] args) {
        int x = 10; //elevator capacity
        int[] weights = {2, 3, 3, 5, 6};
        int n = weights.length;

        int result = minRides(x, weights, n);

        System.out.println("Result: " + result);


    }

    static int minRides(int x, int[] weights, int n) {
        Pair<Integer, Integer>[] dp = new Pair[1 << n];
        //dp[mask].first - rides
        //dp[mask].second - weight

        dp[0] = new Pair<>(1, 0);// base case , when 0 person so lift can go for 1 ride and weight would be 0

        for (int mask = 1; mask < 1 << n; mask++) {
            dp[mask] = new Pair<>(n, 0); //set large as ride and set 0
            for (int y = 0; y < n; y++) {
                if (((mask >> y) & 1) == 1) {
                    int newMask = mask ^ (1 << y);
                    Pair<Integer, Integer> option = dp[newMask];
                    //include yth person
                    if (option.component2() + weights[y] <= x) {
                        option = new Pair<>(option.component1(), option.component2() + weights[y]);
                    } else {
                        //exclude yth person
                        //new ride with y
                        option = new Pair<>(option.component1() + 1, weights[y]);
                    }

                    if (option.component1() < dp[mask].component1()) {
                        dp[mask] = option;
                    }

                }
            }
        }

        return dp[(1 << n) - 1].getFirst();
    }
}
