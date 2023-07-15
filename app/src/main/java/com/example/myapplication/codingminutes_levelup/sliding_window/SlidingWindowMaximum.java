package com.example.myapplication.codingminutes_levelup.sliding_window;


import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import kotlin.Pair;

public class SlidingWindowMaximum {
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int k = 3;
        List<Integer> result = slidingWindowMaximum(a, k);
        System.out.println("Result:" + result);
        List<Integer> result1 = maxSlidingWindow(a, k);
        System.out.println("Result1:" + result1);

        List<Integer> result2 = maxSlidingWindow1(a, k);
        System.out.println("Result2:" + result2);

    }

    //naive approach
    static List<Integer> slidingWindowMaximum(int[] a, int k) {
        int n = a.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= n - k; i++) {
            int max = a[i];
            int j = i;
            while (j <= i + 2) {
                max = Math.max(max, a[j]);
                j++;
            }
            list.add(max);
        }
        return list;
    }

    //using heap approach

    @RequiresApi(api = Build.VERSION_CODES.N)
    static List<Integer> maxSlidingWindow(int[] arr, int k) {
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getFirst() - a.getFirst()); //it m
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            while (!pq.isEmpty() && pq.peek().getSecond() <= i - k) { //pop root, if its out of window.
                pq.remove();
            }
            pq.add(new Pair<>(arr[i], i)); //add current value and index to max heap
            if (i >= k - 1) //check current window is valid or not
                ans.add(pq.peek().getFirst());
        }
        return ans;
    }


    //using dequeue approach
    static List<Integer> maxSlidingWindow1(int[] arr, int k) {
        Deque<Pair<Integer, Integer>> dq = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (!dq.isEmpty() && dq.peek().getSecond() <= i - k) { //remove front element if it goes out of window.
                dq.remove();
            }
            while (!dq.isEmpty() && dq.peek().getFirst() < arr[i]) { //maintain element in the descending order.
                dq.remove();
            }
            dq.add(new Pair<>(arr[i], i));
            if (i >= k - 1) //check current window is valid or not
                ans.add(dq.peek().getFirst());
        }
        return ans;
    }
}
