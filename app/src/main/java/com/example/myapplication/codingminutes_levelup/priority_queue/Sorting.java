package com.example.myapplication.codingminutes_levelup.priority_queue;

import java.util.PriorityQueue;

public class Sorting {

    public static void main(String[] args){
        int[] arr = {50,23,3,5,90,60};
        sort(arr);
    }

    static void sort(int[] arr){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int a :arr){
            pq.add(a);
        }

        while (!pq.isEmpty()){
            System.out.print(pq.poll()+", ");
        }
    }
}
