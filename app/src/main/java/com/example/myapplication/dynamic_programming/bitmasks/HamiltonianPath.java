package com.example.myapplication.dynamic_programming.bitmasks;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import kotlin.Pair;

public class HamiltonianPath {
    static Graph graph;
    static HashMap<Pair<Integer, Set<Integer>>, Boolean> map = new HashMap<>();

    public static void main(String[] args) {
        int n = 4;

        graph = new Graph(n);
        graph.addEdges(0, 1, true);
        graph.addEdges(1, 2, true);
        graph.addEdges(1, 3, true);
        graph.addEdges(2, 3, true);

        boolean result = isHamiltonianPathExist(n);

        System.out.println("Result: " + result);

        boolean result1 = isHamiltonianPathExistMask(n);

        System.out.println("Result Using Mask: " + result1);


        boolean result2 = isHamiPathExist(n);
        System.out.println("Result Using BottomUp: " + result2);
    }

    static boolean isHamiltonianPathExist(int n) {
        boolean isPathExist = false;
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            set.add(i);
            isPathExist |= isPathExist(i, set);
        }

        return isPathExist;
    }

    static Pair<Integer, Set<Integer>> p;

    static boolean isPathExist(int current, Set<Integer> set) {
        //base case
        if (set.size() == graph.V) {
            return true;
        }

        p = new Pair<>(current, set);
        if (Boolean.TRUE.equals(map.get(p))) {
            return Boolean.TRUE.equals(map.get(p));
        }
        //recursive case
        boolean ans = false;
        for (int x : graph.list.get(current)) {
            if (!set.contains(x)) {
                Set<Integer> temp;
                temp = set;
                temp.add(x);
                ans |= isPathExist(x, temp);
            }
        }
        return Boolean.TRUE.equals(map.put(p, ans));
    }

    static boolean isHamiltonianPathExistMask(int n) {
        boolean isPathExist = false;
        int[][] dp = new int[n][1 << n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        for (int i = 0; i < n; i++) {
            isPathExist |= isPathExistUsingMask(i, 0, dp);
        }

        return isPathExist;
    }

    static boolean isPathExistUsingMask(int current, int mask, int[][] dp) {
        //base case
        if (mask == (1 << graph.V) - 1) {  // (1<<n)-1 means 2powN-1
            return true;
        }

        if (dp[current][mask] != -1) {
            return dp[current][mask] == 1;
        }
        //recursive case
        boolean ans = false;
        for (int x : graph.list.get(current)) {
            //xth bit of mask is set or not
            if (((mask >> x) & 1) == 0) {
                ans |= isPathExistUsingMask(x, mask | (1 << x), dp);
            }
        }
        dp[current][mask] = ans ? 1 : 0;
        return dp[current][mask] == 1;
    }

    //Bottom up
    static boolean isHamiPathExist(int n) {
        int[][] dp = new int[n][1 << n];
        for (int[] row : dp) {
            Arrays.fill(row, 0);
        }

        for (int i = 0; i < n; i++) {
            dp[i][1 << i] = 1; //for each node
        }
        for (int mask = 0; mask < (1 << n); mask++) {
            for (int current = 0; current < n; current++) {
                if (dp[current][mask] == 1) {
                    for (int x : graph.list.get(current)) {
                        if (((mask >> x) & 1) == 0) {//this should not be set bit
                            dp[x][mask | (1 << x)] = 1;
                        }
                    }
                }
            }
        }

        boolean ans = false;
        for (int i = 0; i < n; i++) {
            ans |= dp[i][(1 << n) - 1] == 1;
        }
        return ans;
    }

    private static class Graph {
        int V;
        ArrayList<ArrayList<Integer>> list;

        public Graph(int v) {
            this.V = v;
            list = new ArrayList<>();

            for (int i = 0; i < v; i++) {
                list.add(new ArrayList<>());
            }
        }

        void addEdges(int i, int j, boolean undirected) {
            list.get(i).add(j);
            if (undirected) {
                list.get(j).add(i);
            }
        }
    }
}
