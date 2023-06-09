package com.example.myapplication.codingminutes.backtracking;

import java.util.Arrays;

public class Permutation {

    public static void main(String[] args){
      char[] arr = {'a','b','c'};
      int start = 0;
      int n = arr.length;
      permutations(arr,n,start);
    }

    static void permutations(char[] arr, int n,int start){
        //base case
        if(start==n){
            System.out.println(Arrays.toString(arr));
            return;
        }
        //recursive case
        for(int i=start;i<n;i++){
            swap(arr,start,i);
            permutations(arr,n,start+1);
            swap(arr,start,i);
        }
    }

    static void swap(char[] arr,int i,int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
