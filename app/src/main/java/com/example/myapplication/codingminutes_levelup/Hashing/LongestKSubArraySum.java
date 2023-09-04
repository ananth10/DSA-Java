package com.example.myapplication.codingminutes_levelup.Hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Longest K Sub array sum
 * -------------------------
 * we are given an array and we need to find out the length of longest subarray whose sum is equal to given integer K.
 * <p>
 * Sample Input
 * arr = { 0,-2,1,2,3,4,5,15,10,5 }
 * K = 15
 * Sample output
 * 5
 * <p>
 * Hint
 * Use prefix sums + unordered_map.
 */
public class LongestKSubArraySum {

    public static void main(String[] args) {
        int[] arr = {0, -2, 1, 2, 3, 4, 5, 15, 10, 5};
        int k = 15;
        int result = longestSubArraySum(arr, k);
        System.out.println("Result:"+result);
    }

    private static int longestSubArraySum(int[] arr, int k) {
        int len = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int preSum = 0;

        for (int i = 0; i < arr.length; i++) {
            preSum += arr[i];

            if (preSum == k) {
                len = Math.max(len, i + 1);
            }

            if (map.containsKey(preSum - k)) {
                len = Math.max(len, i - map.get(preSum - k));
            } else {
                map.put(preSum, i);
            }
        }

        return len;
    }

}
