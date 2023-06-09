package com.example.myapplication.codingminutes.heaps;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class RelativeRanks {

    public static void main(String[] args) {
        int[] scores = {4, 3, 6, 8, 1, 9};
        String[] ranks = relativeRanks(scores);
        System.out.println(Arrays.toString(ranks));
    }

    static String[] relativeRanks(int[] scores) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        for (int score : scores) {
            queue.add(score);
        }
        int position = 1;
        String[] ranks = new String[scores.length];
        String[] medals = {"Gold Medal", "Silver Medal", "Bronze Medal"};
        while (!queue.isEmpty()) {
            if (position <= 3) {
                ranks[position - 1] = medals[position - 1];
            } else {
                ranks[position - 1] = String.valueOf(position);
            }
            queue.poll();
            position++;
        }
        return ranks;
    }
}
