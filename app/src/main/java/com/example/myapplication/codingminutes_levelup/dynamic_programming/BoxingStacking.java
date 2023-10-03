package com.example.myapplication.codingminutes_levelup.dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Box Stacking
 * -------------
 * We are given an array of boxes. Each boxes is represented using 3 integers
 * denoting height, width, depth of the box. our goal is stack up the boxes and
 * maximise the total height of the stack
 * <p>
 * You cannot rotate any box, ie integers in each box must represented
 * [width,depth,height] at all times,
 * <p>
 * A box must have strictly smaller width, depth, and height than any other box below it.
 * <p>
 * INPUT:
 * boxes = {
 * {2,1,2},
 * {3,2,3},
 * {2,2,8},
 * {2,3,4},
 * {2,2,1},
 * {4,4,5},
 * }
 * <p>
 * OUTPUT:
 * 10
 * Explanation: we can stack 3 boxes to get height 10
 * [2,1,2]
 * [3,2,3]
 * [4,4,5]
 */
public class BoxingStacking {
    public static void main(String[] args) {
        int[][] arr = {
                {2, 1, 2},
                {3, 2, 3},
                {2, 2, 8},
                {2, 3, 4},
                {2, 2, 1},
                {4, 4, 5},
        };
        int height = boxStack(arr);
        System.out.println("Height:" + height);
    }

    static class HeightComparator implements Comparator<int[]> {

        @Override
        public int compare(int[] t1, int[] t2) {
            return Integer.compare(t1[2], t2[2]);
        }
    }

    //Bottom Up
    private static int boxStack(int[][] arr) {
        int n = arr.length;
        //1. sorting
        Arrays.sort(arr, new HeightComparator());
        //2. DP
        int[] dp = new int[arr.length];
        for (int i = 0; i < n; i++) {
            dp[i] = arr[i][2]; //initially  fill dp array with given height
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (canPlace(arr, i, j)) {
                    int current_height = arr[i][2];
                    if (dp[j] + current_height > dp[i]) {
                        dp[i] = dp[j] + current_height;
                    }
                }
            }
        }

        int maxHeight = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            maxHeight = Math.max(maxHeight, dp[i]);
        }
        System.out.println(Arrays.toString(dp));
        return maxHeight;
    }

    private static boolean canPlace(int[][] arr, int i, int j) {
        return arr[i][0] > arr[j][0] && arr[i][1] > arr[j][1] && arr[i][2] > arr[j][2];
    }

}
