package com.example.myapplication.datastructures.array.codingminutes.dynamic_programming;

public class MinimumPartitioning {

    public static void main(String[] args) {
        int[] arr = {1, 6, 11, 5};
        int result = minimumPartition(arr);
        System.out.println("RES:" + result);
    }

    static int minimumPartition(int[] arr) {
        int n = arr.length;
        int sum = 0;

        //find sum
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        //memoization
        boolean[][] dp = new boolean[n + 1][sum + 1];

        //Initialize column 0 with True, because sum 0 can be made using any elements in the array
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        //Initialize first row, exception  column, fill with false because we cannot make sum when array is empty
        for (int i = 1; i < sum; i++) {
            dp[0][i] = false;
        }

        //fill the partition table with bottom up manner
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                //if ith element is excluded
                dp[i][j] = dp[i - 1][j]; //why i-1? because we already calculated and filled when we dont have current element.

                //if ith element included
                if (arr[i - 1] <= j) //current picked element from array should be less than our sum value
                {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]]; //we need to check previous row because we included this element and column should be sum-current element
                }
            }
        }

        //initialize different of two sums.
        int diff = Integer.MAX_VALUE;

        //Find the largest j such that dp[n][j]
        //is true where j loops from sum/2 to 0

        for (int j = sum / 2; j >= 0; j--) {
            if (dp[n][j] == true) {
                diff = sum - 2 * j;
                break;
            }
        }

        return diff;
    }
}
