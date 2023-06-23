package com.example.myapplication.codingminutes_levelup.arrays_and_vectors;

import java.util.Arrays;

public class ArrayProduct {

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5};
        int[] result = arrayProduct(input);
        int[] result1 = arrayProduct1(input);
        System.out.println("Result: " + Arrays.toString(result));
        System.out.println("Result1: " + Arrays.toString(result1));
    }

    //Approach 1 - Brute Force - o(n)
    static int[] arrayProduct(int[] input) {
        int n = input.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int product = 1;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    product *= input[j];
                }
            }
            result[i] = product;
        }

        return result;
    }

    //Approach 2 - O(n)

    static int[] arrayProduct1(int[] input) {
        int n = input.length;
        if (n == 1) {
            return new int[]{0};
        }
        int[] result = new int[n];
        int i, temp = 1;

        // In this loop, temp variable contains product of
        // elements on left side excluding arr[i]
        for (i = 0; i < n; i++) {
            result[i] = temp;
            temp *= input[i];
        }
        temp = 1;
        System.out.println(Arrays.toString(result));
        //In this loop, temp variable contains product of
        //elements on right side excluding arr[i]
        for (i = n - 1; i >= 0; i--) {
            result[i] *= temp;
            temp *= input[i];
        }
        return result;
    }
}
