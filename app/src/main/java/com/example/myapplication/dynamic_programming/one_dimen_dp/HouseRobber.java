package com.example.myapplication.dynamic_programming.one_dimen_dp;

import java.util.Arrays;

public class HouseRobber {
    public static void main(String[] args){
//        int[] cash = {1,2,3,1};
        int[] cash = {2,7,9,3,1};

        int[] dp = new int[cash.length];
        Arrays.fill(dp,-1);
        int result = houseRobbingTopDown(cash,0,dp);
        System.out.println("Topdown Result:"+result);

        System.out.println("BottomUp Result:"+houseRobBottomUp(cash));
    }

    private static int houseRobbingTopDown(int[] cash,int i,int[] dp){
        //base case
        if(i>= cash.length){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }

        int robHouse = houseRobbingTopDown(cash,i+2,dp) + cash[i];
        int notRobHouse = houseRobbingTopDown(cash,i+1,dp);

        return dp[i] = Math.max(robHouse,notRobHouse);
    }

    private static int houseRobBottomUp(int[] cash){
        if(cash.length==0){
            return 0;
        }
        //base case
        if(cash.length==1){
            return cash[0];
        }
        if(cash.length==2){
            return Math.max(cash[0], cash[1]);
        }

        int[] dp = new int[cash.length];
        Arrays.fill(dp,0);

        dp[0] = cash[0];
        dp[1] = Math.max(cash[0], cash[1]);

        for (int i = 2; i < cash.length; i++) {
            dp[i] = Math.max(dp[i-2]+cash[i],dp[i-1]);
        }

        return dp[cash.length-1];
    }
}
