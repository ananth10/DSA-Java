package com.example.myapplication.codingminutes_levelup.Hashing;

import android.annotation.SuppressLint;

import java.util.HashMap;
import java.util.Map;

/**
 * Triplets in GP
 * --------------
 * You are given an array and you need to count number of triplets with indices(i,j,k) such that the elements at
 * those indices are in geometric progression for a given common ratio r and i (i<j<k)
 * INPUT:
 * arr = {1,16,4,16,64,16}
 * r = 4
 * <p>
 * OUTPUT:
 * 3
 */
public class CountTriplets {
    public static void main(String[] args) {
        int[] arr = {1, 16, 4, 16, 64, 16};
        int r = 4;
        int count = countTriplets(arr, r);
        System.out.println("Result:" + count);
    }

    @SuppressLint("NewApi")
    private static int countTriplets(int[] arr, int r) {
        Map<Long, Long> left = new HashMap<>();
        Map<Long, Long> right = new HashMap<>();
        int count = 0;
        for (long val : arr) {
            if (right.containsKey(val)) {
                right.put(val, right.get(val) + 1);
            } else {
                right.put(val, 1L);
            }
            left.put(val, 0L);
        }
        for (int i = 0; i < arr.length; i++) {
            long val = Long.valueOf(arr[i]);
            right.put(val, right.get(val) - 1);

            if (val % r == 0) {
                long a = val / r;
                long c = val * r;

                count += (left.containsKey(a) ? left.get(a) : 0) * (right.containsKey(c) ? right.get(c) : 0);
            }
            left.put(val, left.get(val) + 1);
        }


        return count;
    }
}
