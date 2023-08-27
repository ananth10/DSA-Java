package com.example.myapplication.codingminutes_levelup.priority_queue;

import java.util.PriorityQueue;

/**
 * Merging Ropes
 * -------------
 * Given N ropes each having a different size,
 * you task is join the ropes together. The cost of joining 2 ropes of
 * different sizes X and Y is (X+Y). Find the minimum cost to join all the ropes together.
 *
 * INPUT:
 * N=4
 * Ropes = {4,3,2,6}
 * Output:
 * 29
 * */
public class MergingRopes {
    public static void main(String[] args){
     int[] ropes = {4,3,2,6};
     int minCost = findMinCost(ropes);
        System.out.println("Min Cost:"+ minCost);
    }

    private static int findMinCost(int[] ropes) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int minCost = 0;
        //add all elements in the pq
        for (int rope:ropes){
            pq.add(rope);
        }
        //pick the smallest pair of ropes, join them and add their cost
        while (!pq.isEmpty() && pq.size()>1){
            int a = pq.poll();
            int b = pq.poll();
            int c = a+b;
            minCost+=c;
            //add the new rope in the heap
            pq.add(c);
        }

        return minCost;
    }
}
