package com.example.myapplication.dynamic_programming.two_dimen_dp;

import java.util.Arrays;

public class SubSetSum {

    public static void main(String[] args) {
        int sum = 22;
        int[] num = {2, 7, 4, 5, 19};
        int n = num.length;

        int[][] dp = new int[100][100];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
//        int result = isSubSetSumPossible(num, n - 1, sum, dp);
        int result = isSubSetSumPossibleUsingRepeatedElements(num, n - 1, sum, dp);
        System.out.println("Recursive Result: " + result);
    }

    //recursive up approach
    private static int isSubSetSumPossible(int[] num, int index, int sum, int[][] dp) {

        //base case
        if (index == -1){
            if(sum==0){
                return 1;
            }else{
                return 0;
            }
        }

        if (dp[index][sum] != -1)
            return dp[index][sum];

        int ans = 0; //initially assume is not possible
        //include the current index value
        if (sum >= num[index]) {
            ans += isSubSetSumPossible(num, index - 1, sum - num[index], dp);
        }
        //exclude the current index value
        ans += isSubSetSumPossible(num, index - 1, sum, dp);

        return dp[index][sum] = ans;
    }


// idea here is , we can use array elements n times
    private static int isSubSetSumPossibleUsingRepeatedElements(int[] num, int index, int sum, int[][] dp) {

        //base case
        if (index == -1){
            if(sum==0){
                return 1;
            }else{
                return 0;
            }
        }

        if (dp[index][sum] != -1)
            return dp[index][sum];

        int ans = 0; //initially assume is not possible
        //include the current index value, and use same index again
        if (sum >= num[index]) {
            ans |= isSubSetSumPossibleUsingRepeatedElements(num, index, sum - num[index], dp);
        }
        //exclude the current index value
        ans |= isSubSetSumPossibleUsingRepeatedElements(num, index - 1, sum, dp);

        return dp[index][sum] = ans;
    }

}
