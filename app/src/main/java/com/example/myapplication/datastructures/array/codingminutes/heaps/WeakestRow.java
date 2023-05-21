package com.example.myapplication.datastructures.array.codingminutes.heaps;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class WeakestRow {

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main(String[] args) {
        int[][] mat = {
                {1, 0, 0, 0},
                {1, 1, 1, 1},
                {1, 0, 0, 0},
                {1, 0, 0, 0},
        };
        int k = 2; //k weakest row , need to find

        List<Integer> weakRows = weakestRow(mat, k);
        System.out.println(weakRows);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    static List<Integer> weakestRow(int[][] mat, int k) {
        PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (int row = 0; row < mat.length; row++) {
            int count = 0;
            for (int col = 0; col < mat[row].length; col++) {
                if (mat[row][col] == 1) {
                    count++;
                }
            }
            queue.add(new Pair(row, count));
        }
        ArrayList<Integer> weakRowsList = new ArrayList<>();
        System.out.println(Arrays.toString(queue.toArray()));
        while (k > 0) {
            Pair temp = queue.peek();
            weakRowsList.add(temp.key);
            queue.poll();
            k--;
        }
        return weakRowsList;
    }

    static class Pair {
        int key;
        int val;

        public Pair(int key, int val) {
            this.key = key;
            this.val = val;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "key=" + key +
                    ", val=" + val +
                    '}';
        }
    }
}
