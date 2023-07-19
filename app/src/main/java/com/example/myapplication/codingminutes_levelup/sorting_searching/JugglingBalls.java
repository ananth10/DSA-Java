package com.example.myapplication.codingminutes_levelup.sorting_searching;

import java.util.Arrays;

/**
 * Given an array containing balls of Red, Blue and Green Color in a random order.
 * Your goal is to arrange these balls in sorted order - Red Balls,
 * followed by Blue and then Green Balls.
 * Red balls are denoted using number 0, Blue using 1 and Green using 2.
 * */
public class JugglingBalls {
    public static void main(String[] args) {
        int[] balls = {0, 0, 1, 2, 0, 1, 2, 0};
        juggleBalls(balls);
        System.out.println("Result:" + Arrays.toString(balls));
    }

    static void juggleBalls(int[] arr) {
        int n = arr.length;
        int s = 0;
        int e = n - 1;
        int mid = 0;

        while (mid <= e) {
            if (arr[mid] == 0) {
                swap(arr, s++, mid++);
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                swap(arr, mid, e--);
            }
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
