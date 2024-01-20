package com.example.myapplication.dynamic_programming.two_dimen_dp;

import java.util.Arrays;

public class SubSetSum {

    public static void main(String[] args) {
        int sum = 12;
        int[] num = {2, 7, 4, 5, 19};
        int n = num.length;

        int[][] dp = new int[100][100];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int result2 = isSubSetSumPossibleWithDp(num, n - 1, sum, dp);
        System.out.println("Recursive Result: " + result2);

        int result = isSubSetSumPossibleUsingRepeatedElements(num, n - 1, sum, dp);
        System.out.println("Recursive Repeated Result: " + result);

        boolean result1 = isSubSetSumPossibleBottomUp(num, sum);
        System.out.println("BottomUp Result:" + result1);

        boolean result3 = isSubSetSumPossibleBottomUpMemoryOpt(num, sum);
        System.out.println("BottomUp Memory Opt Result:" + result3);

        boolean result4 = isSubSetSumPossibleBottomUpMemoryOptOneRow(num, sum);
        System.out.println("BottomUp Memory Opt With 1 Row Result:" + result4);

        //back track the path
        printSubSetSumPath(n-1,num,sum);
    }


    private static int isSubSetSumPossible(int[] num, int index, int sum) {

        //base case
        if (index == -1) {
            if (sum == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        int ans = 0; //initially assume is not possible
        //include the current index value
        if (sum >= num[index]) {
            ans += isSubSetSumPossible(num, index - 1, sum - num[index]);
        }
        //exclude the current index value
        ans += isSubSetSumPossible(num, index - 1, sum);

        return ans;
    }

    //recursive up approach
    private static int isSubSetSumPossibleWithDp(int[] num, int index, int sum, int[][] dp) {

        //base case
        if (index == -1) {
            if (sum == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        if (dp[index][sum] != -1)
            return dp[index][sum];

        int ans = 0; //initially assume is not possible
        //include the current index value
        if (sum >= num[index]) {
            ans += isSubSetSumPossibleWithDp(num, index - 1, sum - num[index], dp);
        }
        //exclude the current index value
        ans += isSubSetSumPossibleWithDp(num, index - 1, sum, dp);

        return dp[index][sum] = ans;
    }


    // idea here is , we can use array elements n times
    private static int isSubSetSumPossibleUsingRepeatedElements(int[] num, int index, int sum, int[][] dp) {

        //base case
        if (index == -1) {
            if (sum == 0) {
                return 1;
            } else {
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


    //bottom up approach

    private static boolean isSubSetSumPossibleBottomUp(int[] arr, int sum) {
        int n = arr.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];

        dp[0][0] = true;

        //fill the 1st row all columns
        for (int col = 1; col <= sum; col++) {
            dp[0][col] = false;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= sum; j++) {
                //exclude
                dp[i][j] = dp[i - 1][j];
                //include
                if (j - arr[i] >= 0) {
                    dp[i][j] |= dp[i - 1][j - arr[i]];
                }
            }
        }

//        for (boolean[] row : dp) {
//            for (boolean value : row) {
//                System.out.print(value + ", ");
//            }
//            System.out.println();
//        }
        return dp[n][sum];
    }


    //memory optimization using only 2 rows
    private static boolean isSubSetSumPossibleBottomUpMemoryOpt(int[] arr, int sum) {
        int n = arr.length;
        boolean[][] dp = new boolean[2][sum + 1];

        dp[0][0] = true;

        //fill the 1st row all columns
        for (int col = 1; col <= sum; col++) {
            dp[0][col] = false;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= sum; j++) {
                //exclude
                dp[1][j] = dp[0][j];
                //include
                if (j - arr[i] >= 0) {
                    dp[1][j] |= dp[0][j - arr[i]];
                }
            }

            //overwrite 0th row with 1st row
            for (int j = 0; j <= sum; j++) {
                dp[0][j] = dp[1][j];
            }
        }
        return dp[1][sum];
    }

    //memory optimization using only 1 row
    private static boolean isSubSetSumPossibleBottomUpMemoryOptOneRow(int[] arr, int sum) {
        int n = arr.length;
        boolean[] dp = new boolean[sum + 1];

        //memory = O(sum)
        dp[0] = true;

        //fill the 1st row all columns
        for (int col = 1; col <= sum; col++) {
            dp[col] = false;
        }

        //time = O(n*sum)
        for (int i = 1; i <n; i++) {
            for (int j = sum; j >= 0; j--) { //coming from last index, so the previous col values will not disturbed
                if (j - arr[i] >= 0) {
                    dp[j] |= dp[j - arr[i]];
                }
            }
        }
        return dp[sum];
    }

    //trace back the path
    private static void printSubSetSumPath(int n,int[] arr,int sum){

        if(n==-1)
            return;

        if(isSubSetSumPossible(arr,n-1,sum-arr[n])==1){
            System.out.println(arr[n]);
            printSubSetSumPath(n-1,arr,sum-arr[n]);
        }
        else if(isSubSetSumPossible(arr,n-1,sum)==1){
            printSubSetSumPath(n-1,arr,sum);
        }


    }
}
