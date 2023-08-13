package com.example.myapplication.codingminutes_levelup.stack_and_quick;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Max Subarray
 * --------------
 * Given an array and an integer k, find the maximum for each and every contiguous sub-array of size k
 * <p>
 * Input:
 * N = 9;
 * arr = {1,2,3,1,4,5,2,3,6,3}
 * k = 3
 */
public class MaxSubArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 4, 5, 2, 3, 6, 3};
        int n = arr.length;
        int k = 3;

        List<Integer> result = maxSubArray(arr, n, k);
        System.out.println("Result: " + result);
    }

    private static List<Integer> maxSubArray(int[] arr, int n, int k) {
        List<Integer> list = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();

        int i;
        //process the first k elements
        for (i = 0; i < k; i++) {

            while (!deque.isEmpty() && arr[i] > arr[deque.getLast()]) {
                deque.removeLast();
            }
            //always push back the current index
            deque.addLast(i);
        }

        //process the remaining k elements of array
        for (; i < n; i++) {
            //always add current max of deque to our output list
            list.add(arr[deque.getFirst()]);

            //if elements in the deque is not fall under current window then remove it
            while (!deque.isEmpty() && deque.getFirst() <= i - k) {
                deque.removeFirst();
            }
            //current element is higher then element present in the deque then remove it
            while (!deque.isEmpty() && arr[i] >= arr[deque.getLast()]) {
                deque.removeLast();
            }

            //always push back the current index
            deque.addLast(i);
        }

        return list;
    }


}
