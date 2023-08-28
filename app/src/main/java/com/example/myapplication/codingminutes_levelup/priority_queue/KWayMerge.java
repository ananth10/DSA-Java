package com.example.myapplication.codingminutes_levelup.priority_queue;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * K-Way Merge
 * -----------
 * Given k-sorted arrays of different sizes, produce a single sorted array.
 * INPUT:
 * K = 3;
 * A1 = {1,3,15}
 * A2 = {2,4,6}
 * A3 = {0,9,10,11}
 * <p>
 * OUTPUT:
 * 0,1,2,3,4,6,9,10,11,15
 */
public class KWayMerge {
    public static void main(String[] args) {
        int k = 3;
        int[][] arr = {
                {1, 3, 15},
                {2, 4, 6},
                {0, 9, 10, 11}
        };

        List<Integer> result = kWayMerge(k, arr);
        System.out.println("Result:" + result);
    }

    private static class Node implements Comparable<Node>{
        int data;
        int index;
        int arrayIndex;

        public Node(int data, int index, int arrayIndex) {
            this.data = data;
            this.index = index;
            this.arrayIndex = arrayIndex;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(data,o.data);
        }
    }

    private static List<Integer> kWayMerge(int k, int[][] arr) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Node> pq = new PriorityQueue<>();
        //initially push first k elements
        for (int i = 0; i < arr.length; i++) {
            int element = arr[i][0]; //first element in each row.
            Node node = new Node(element, 0, i);
            pq.add(node);
        }

        while (!pq.isEmpty()) {
            Node top = pq.poll();
            result.add(top.data);
            int index = top.index;
            int arrayIndex = top.arrayIndex;
            if (index + 1 < arr[arrayIndex].length) {
                int nextElement = arr[arrayIndex][index + 1];
                Node node = new Node(nextElement, index + 1, arrayIndex);
                pq.add(node);
            }
        }

        return result;
    }
}
