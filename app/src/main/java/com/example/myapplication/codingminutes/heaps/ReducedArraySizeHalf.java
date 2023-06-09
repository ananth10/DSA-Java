package com.example.myapplication.codingminutes.heaps;

import android.annotation.SuppressLint;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReducedArraySizeHalf {

    public static void main(String[] args){
        int[] arr = {3,3,3,3,5,5,5,2,2,7};
        int result = minSetSize(arr);
        System.out.println(result);
    }

    @SuppressLint("NewApi")
    static int  minSetSize(int[] arr){
        int n  = arr.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        for(int val:arr){
            map.put(val, map.getOrDefault(val,0)+1);
        }

        for(Map.Entry<Integer,Integer> pair: map.entrySet()){
            queue.add(pair.getValue());
        }
        System.out.println(Arrays.toString(queue.toArray()));
        int sum = 0;
        int count = 0;

        while (n-sum>n/2){
            System.out.println("top:"+queue.peek());
            sum+= queue.poll();
            count++;
        }

        return count;
    }
}
