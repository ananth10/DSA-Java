package com.example.myapplication.codingminutes_levelup.sliding_window;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.HashMap;

@RequiresApi(api = Build.VERSION_CODES.N)
public class CountSubArraySum {

    public static void main(String[] args) {
        int[] a = {10, 2, -2, -20, 10};
        int k = -10;
        int count = countSubArraySum(a, k);
        System.out.println("Result:" + count);
    }

    static int countSubArraySum(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int currentSum = 0;
        int count = 0;
        map.put(0, 1);
        for (int i = 0; i < arr.length; i++) {
            //Add current element to sum so far
            currentSum += arr[i];

            //If current sum is equal to k then new sub array found, so increase the count
            if (currentSum == k) {
                count++;
            }
            // every currentSum encountered, we also determine the number of times the currentSum (currentSum−k) has occurred already,
            //since it will determine the number of times a subarray with sum k has occurred up to the current index
            //. We increment the countcountcount by the same amount
            if (map.containsKey(currentSum - k)) {
                count += map.get(currentSum - k);
            }
            map.put(currentSum, map.getOrDefault(arr[i], 0) + 1);//If the same sum occurs again. we increment the count corresponding to that sum in the hashmap.
        }
        return count;
    }
}
