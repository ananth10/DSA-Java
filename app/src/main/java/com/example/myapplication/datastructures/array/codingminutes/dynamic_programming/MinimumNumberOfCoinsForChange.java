package com.example.myapplication.datastructures.array.codingminutes.dynamic_programming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumNumberOfCoinsForChange {
    public static void main(String[] args) {
        int[] denoms = {1, 5, 7, 10};
        int m = 8;

        int result = minNumberOfCoins(denoms, m);
        System.out.println("Bottom Up:" + result);

        int result1 = minimumCoinsTopDown(m, denoms, new HashMap<>());
        System.out.println("TOP DOWN:" + result1);
    }

    //bottom up dp
    static int minNumberOfCoins(int[] denoms, int m) {
        int[] dp = new int[m + 1];
        Arrays.fill(dp, 0);
        dp[0] = 0;

        for (int i = 1; i <= m; i++) {
            dp[i] = Integer.MAX_VALUE;

            for (int coin : denoms) {
                if ((i - coin) >= 0 && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i - coin], dp[i]) + 1;
                }
            }
        }

        return dp[m] == Integer.MAX_VALUE ? -1 : dp[m];
    }

    //top down
    static int minimumCoinsTopDown(int total, int[] coins, Map<Integer, Integer> map) {
        //base case
        if (total == 0) {
            return 0;
        }

        //if we already calculated minimum coins need to for total then get it from map
        if (map.containsKey(total)) {
            return map.get(total);
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            //if current coin is greater than our total then we move to next coin
            if (coins[0] > total) {
                continue;
            }

            int val = minimumCoinsTopDown(total - coins[i], coins, map);

            //if val we get from picking coins[i] as first coin for current total is less than value found so far make it minimum
            if (val < min) {
                min = val;
            }
        }
        min = (min == Integer.MAX_VALUE) ? min : min + 1;
        return min;
    }
}
