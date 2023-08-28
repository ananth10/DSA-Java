package com.example.myapplication.codingminutes_levelup.priority_queue;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Running Median
 * --------------
 * You are given a running stream of integers, write an efficient algorithm to output median of numbers
 * read so far after every input.
 * INPUT:
 * 10 5 2 3 0 12 18 20 22 -1
 * OUTPUT:
 * 10, 7.5, 5, 4, 3, 4, 5, 7.5, 10
 */
@RequiresApi(api = Build.VERSION_CODES.N)
public class RunningMedian {

    public static void main(String[] args) {
        int[] stream = {10, 5, 2, 3, 0, 12, 18, 20, 22};
        runningMedian(stream);
    }


    private static void runningMedian(int[] stream) {
        PriorityQueue<Float> left = new PriorityQueue<>(Collections.reverseOrder()); //max
        PriorityQueue<Float> right = new PriorityQueue<>();//min heap

        float median = stream[0];
        left.add(median);
        System.out.println(median+", ");
        for (int i = 1; i < stream.length; i++) {
            int value = stream[i];
            if (left.size() > right.size()) {
                if (value < median) {
                    right.add(left.poll());
                    left.add((float) value);
                } else {
                    right.add((float) value);
                }
                median = (left.peek() + right.peek()) / 2;
            } else if (left.size() == right.size()) {
                if (value < median) {
                    left.add((float) value);
                    median = left.peek();
                } else {
                    right.add((float) value);
                    median = right.peek();
                }
            } else {
                if (value < median) {
                    left.add((float) value);
                } else {
                    left.add(right.poll());
                    right.add((float) value);
                }
                median = (left.peek() + right.peek()) / 2;
            }
            System.out.println(median+", ");
        }
    }
}
