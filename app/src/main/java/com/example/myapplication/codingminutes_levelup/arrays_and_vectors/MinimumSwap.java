package com.example.myapplication.codingminutes_levelup.arrays_and_vectors;


import java.util.Arrays;

public class MinimumSwap {

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        int result = minSwapNeeded(arr);
        System.out.println("Result:" + result);
    }

    private static class Pair implements Comparable<Pair> {
        int value;
        int index;

        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(this.value, o.value);
        }
    }

    static int minSwapNeeded(int[] arr) {
        int ans = 0;
        Pair[] ap = new Pair[arr.length];
        //create pair of array value and array index
        for (int i = 0; i < arr.length; i++) {
            ap[i] = new Pair(arr[i], i);
        }
        //sorting the pair array
        Arrays.sort(ap);

        boolean[] visited = new boolean[arr.length];

        for (int i = 0; i < arr.length; i++) {
            //if index visited or index at the right position
            if (visited[i] || ap[i].index == i) {
                continue;
            }

            int node = i;
            int cycle = 0;

            while (!visited[node]) {
                visited[node] = true;
                node = ap[node].index;
                cycle += 1;
            }
            ans += cycle - 1;
        }
        return ans;
    }
}
