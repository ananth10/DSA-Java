package com.example.myapplication.codingminutes_levelup.arrays_and_vectors;

public class MaximumSubArraySum {
    public static void main(String[] args) {
        int[] arr = {-1, 2, 3, 4, -2, 6, -8, 3};
        int result = maxSubArraySum(arr);
        System.out.println("Result:" + result);
    }

    static int maxSubArraySum(int[] arr) {
        int cs = 0;
        int ms = 0;

        for (int number : arr) {
            cs += number;
            ms = Math.max(cs, ms);
            if (cs < 0) {
                cs = 0;
            }
        }
        return ms;
    }
}
