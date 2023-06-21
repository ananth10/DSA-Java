package com.example.myapplication.codingminutes_levelup.arrays_and_vectors;

import java.util.Arrays;

public class RainsWaterTrap {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int result = trappedWater(arr);
        System.out.println("Result:" + result);
    }

    static int trappedWater(int[] heights) {
        int n = heights.length;
        if (n <= 2) {
            return 0;
        }
        int[] left = new int[heights.length];
        Arrays.fill(left, 0);
        int[] right = new int[heights.length];
        Arrays.fill(right, 0);
        left[0] = heights[0]; //first value is always max value initially (left to right)
        right[n - 1] = heights[n - 1]; //last value is always max value initially(from right to left)

        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], heights[i]);
            right[n - i - 1] = Math.max(right[n - i], heights[n - i - 1]);
        }
        int water = 0;
        for (int i = 0; i < n; i++) {
            water += Math.min(left[i], right[i]) - heights[i]; //deduct current bar height because water filled above bar.
        }

        return water;
    }
}
