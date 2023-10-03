package com.example.myapplication.codingminutes_levelup.dynamic_programming;

import java.util.Arrays;

/**
 * Array Jumps
 * -----------
 * Given an array of positive integers where each element represents
 * the max number of steps you can jump forward in the array.
 * find the minimum jumps can jump forward in the array.
 * INPUT:
 * arr = {3,4,2,1,2,3,7,1,1,1,2,5}
 */
public class MinArrayJump {

    public static void main(String[] args) {
        int[] arr = {2,3,1,1,4};
        int n = arr.length;

        int[] dp = new int[n - 1];
        Arrays.fill(dp, 0);
        int jumps = minJumpsTopDown(arr, n, dp, 0);
        System.out.println("TopDown Result:" + jumps);

        int jumps1 = minJumpBottomUp(arr, n);
        System.out.println("BottomUp Result:" + jumps1);
    }

    //TopDown approach

    private static int minJumpsTopDown(int[] arr, int n, int[] dp, int i) {
        //base case
        if (i == n - 1) {
            return 0;
        }
        if (i >= n) {
            return Integer.MAX_VALUE;
        }
        if (dp[i] != 0) {
            return dp[i];
        }

        int minSteps = Integer.MAX_VALUE;
        int maxJump = arr[i];
        for (int j = 1; j <= maxJump; j++) {
            int nextStep = i + j; //jump from current position
            int subProbMinSteps = minJumpsTopDown(arr, n, dp, nextStep);
            if (subProbMinSteps != Integer.MAX_VALUE) {
                minSteps = Math.min(minSteps, subProbMinSteps + 1); //1 means add the current position in the min step count
            }
        }
        return dp[i] = minSteps;
    }

    //BottomUp Approach

    private static int minJumpBottomUp(int[] arr, int n) {

        if (n == 0 || arr[0] == 0) {
            return -1;
        }
        int[] dp = new int[n]; //this array used to store minimum jump from took to reach end at every index.
        Arrays.fill(dp, 0);

        dp[0] = 0; //there is no need to jump when single element in the array.

        for (int i = 1; i < n; i++) {
            dp[i] = Integer.MAX_VALUE; //assume to reach ith index it need max jump
            for (int j = 0; j < i; j++) { //need to find min jump between 0 to current ith index
                if (i <= j + arr[j] && dp[j] != Integer.MAX_VALUE) { //if able to reach current index from any previous index and if we stored min of for previous index then
                    dp[i] = Math.min(dp[i], dp[j] + 1); //check min jump between currently saved count with every index + current index
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(dp));
        return dp[n - 1];
    }
}
