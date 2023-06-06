package com.example.myapplication.datastructures.array.codingminutes.dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Vacation {

    public static void main(String[] args){
        int[] a = {10,20,30};
        int[] b = {40,50,60};
        int[] c = {70,80,90};

        int maxHappiness = vacation(a,b,c);
        System.out.println("Max Happiness:"+maxHappiness);
    }

    static int vacation(int[] a,int[] b, int[] c){
        int days = a.length;
        ArrayList<int[]> list = new ArrayList<>();

        for (int i = 0; i < days; i++) {
            list.add(new int[]{a[i],b[i],c[i]});
        }

        int[][] dp = new int[days][4];

        for(int[] value:dp){
            Arrays.fill(value,-1);
        }

        System.out.println(Arrays.toString(list.get(0)));
        System.out.println(Arrays.toString(list.get(1)));
        System.out.println(Arrays.toString(list.get(2)));
      int result = topDown(list,days,0,dp,0);
      printDp(dp);
      return result;
    }

    static int topDown(List<int[]> list,int totalDays,int currentDay,int[][]dp,int prevActivity){
        //base case
        if(currentDay==totalDays){
            return 0;
        }

        if(dp[currentDay][prevActivity]!=-1){
            return dp[currentDay][prevActivity];
        }

        int op1 = Integer.MIN_VALUE;
        int op2 = Integer.MIN_VALUE;
        int op3 = Integer.MIN_VALUE;

        if(prevActivity!=1){ // previously not done swim, then you can swim in this day
            op1 = (list.get(currentDay)[0]) + topDown(list,totalDays,currentDay+1,dp,1);
        }
        if(prevActivity!=2){ //previously not done catch bugs, then you can catch bugs in this day
            op2 = (list.get(currentDay)[1]) + topDown(list, totalDays, currentDay+1, dp, 2);
        }
        if(prevActivity!=3){ //previously not done homework, then you can do home work in this day.
            op3 = (list.get(currentDay)[2]) + topDown(list, totalDays, currentDay+1, dp, 3);
        }
        return dp[currentDay][prevActivity] = Math.max(op1,Math.max(op2,op3));
    }

    private static void printDp(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            System.out.println();
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
        }
        System.out.println();
    }
}
