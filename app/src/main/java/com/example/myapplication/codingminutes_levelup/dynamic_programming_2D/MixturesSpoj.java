package com.example.myapplication.codingminutes_levelup.dynamic_programming_2D;

import java.util.Arrays;

/**
 * Mixtures-SPOJ
 * Harry Potter has n mixtures in front of him, arranged in a row.
 * Each mixture has one of 100 different colors (colors have numbers from 0 to 99).
 * He wants to mix all these mixtures together. At each step,
 * he is going to take two mixtures that stand next to each other and mix them together,
 * and put the resulting mixture in their place.
 * When mixing two mixtures of colors a and b,
 * the resulting mixture will have the color (a+b) mod 100. Also,
 * there will be some smoke in the process.
 * The amount of smoke generated when mixing two mixtures of colors a and b is a*b.
 * Find out what is the minimum amount of smoke that Harry can get when mixing all the mixtures together.
 * Input Format:
 * Function contains vector containing integers between 0 and 99 - the initial colors of the mixtures.
 * Output Format:
 * Output the minimum amount of smoke.
 * Constraints:
 * 1 <= n <= 100
 * Sample Testcase 1:
 * Input:
 * 18 19
 * Output:
 * 342
 * Sample Testcase 2:
 * Input:
 * 40 60 20
 * Output:
 * 2400
 * Explanation:
 * In the second test case, there are two possibilities:
 * first mix 40 and 60 (smoke: 2400), getting 0, then mix 0 and 20 (smoke: 0); total amount of smoke is 2400
 * first mix 60 and 20 (smoke: 1200), getting 80, then mix 40 and 80 (smoke: 3200); total amount of smoke is 4400
 */
public class MixturesSpoj {

    public static void main(String[] args) {
        int[] arr = {40, 60, 20};
        int n = arr.length;

        long[][] dp = new long[n + 1][n + 1];
        for (long[] row : dp) {
            Arrays.fill(row, 0);
        }

        long minSmoke = mixture(arr, 0, n - 1, dp);
        System.out.println("Result:" + minSmoke);
    }

    private static long mixture(int[] arr, int l, int r, long[][] dp) {
        //base case
        if (l >= r) {
            return 0;
        }
        if (dp[l][r] != 0) {
            return dp[l][r];
        }
        dp[l][r] = Integer.MAX_VALUE;
        for (int k = l; k <= r; k++) {
            dp[l][r] = Math.min(dp[l][r], mixture(arr, l, k, dp) + mixture(arr, k + 1, r, dp) + sum(arr, l, k) * sum(arr, k + 1, r));
        }
        return dp[l][r];
    }

    private static long sum(int[] arr, int s, int e) {
        long ans = 0;
        for (int i = s; i <= e; i++) {
            ans += arr[i];
            ans %= 100;
        }
        return ans;
    }
}
