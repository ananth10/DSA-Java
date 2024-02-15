package com.example.myapplication.dynamic_programming.subsequences;

import java.util.HashMap;

public class ConsecutiveSequence {

    public static void main(String[] args){
        int[] arr = {1,3,5,2,4,6};

        int result = findMaxConsecutiveSequence(arr);
        System.out.println("Result:"+result);
    }

    private static int findMaxConsecutiveSequence(int[] arr) {
        int n = arr.length;
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (map.get(arr[i]-1)!=null) {
                map.put(arr[i],map.get(arr[i]-1)+1);
            }else{
                map.put(arr[i],1);
            }
        }

        int maxLen = 0;
        for (int i = 0; i < map.size(); i++) {
            if (map.get(arr[i]-1)!=null) {
                maxLen = Math.max(maxLen,map.get(i));
            }
        }
        return maxLen;
    }
}
