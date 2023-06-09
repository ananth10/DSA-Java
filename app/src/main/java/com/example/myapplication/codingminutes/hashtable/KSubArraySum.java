package com.example.myapplication.codingminutes.hashtable;

import java.util.HashMap;

public class KSubArraySum {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 1, 1, 1, 1};
        int k = 3;
        int length = longestKSubArraySum(array, k);
        System.out.println("Length:" + length);
    }

    static int longestKSubArraySum(int[] arr, int k) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = 0;
        int pref = 0;

        for (int i = 0; i < n; i++) {
            pref += arr[i];

            if (pref == k) {
                len = Math.max(len, i + 1);
            }

            if (map.containsKey(pref - k)) {
                len = Math.max(len, i - map.get(pref - k));
            } else {
                map.put(pref, i);
            }

        }

        System.out.println(map);
        return len;
    }
}
