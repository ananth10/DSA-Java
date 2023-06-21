package com.example.myapplication.codingminutes_levelup.arrays_and_vectors;

import java.util.HashSet;

public class LargestBand {

    public static void main(String[] args){
        int[] arr = {1,9,3,0,18,5,2,4,10,7,12,6};
        int result = largestBand(arr);
        System.out.println("Result: "+result);
    }

    static int largestBand(int[] arr){
        HashSet<Integer> set = new HashSet<>();
        int largestBand = 0;

        for(int element:arr){
            set.add(element);
        }

        for(int element:arr){
            int parent = element-1;

            if(!set.contains(parent)){ //if no parent found then consider current element as parent then generate next consecutive element
                int nextNo = element+1;
                int count = 1;

                while (set.contains(nextNo)){
                    nextNo++;
                    count++;
                }

                if(count>largestBand){
                    largestBand = count;
                }
            }
        }
        return largestBand;
    }
}
