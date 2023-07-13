package com.example.myapplication.codingminutes_levelup.sliding_window;

import java.util.ArrayList;
import java.util.List;

public class SlidingWindowMaximum {
    public static void main(String[] args){
        int[] a = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int k = 3;
        List<Integer> result = slidingWindowMaximum(a,k);
        System.out.println("Result:"+result);
    }

    //naive approach
    static List<Integer> slidingWindowMaximum(int[] a,int k){
        int n = a.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i<=n-k;i++){
            int max = a[i];
            int j = i;
            while (j<=i+2){
                max = Math.max(max,a[j]);
                j++;
            }
            list.add(max);
        }
        return list;
    }
}
