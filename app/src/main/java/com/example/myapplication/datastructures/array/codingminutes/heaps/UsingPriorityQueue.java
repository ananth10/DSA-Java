package com.example.myapplication.datastructures.array.codingminutes.heaps;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Comparator;
import java.util.PriorityQueue;

public class UsingPriorityQueue {

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main(String[] args){
        int[] arr = {10,15,20,40,6,12,90};
        PriorityQueue priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i =0;i< arr.length;i++){
            priorityQueue.add(arr[i]);
        }

        while (!priorityQueue.isEmpty()){
            System.out.println(priorityQueue.poll());
        }
    }
}
