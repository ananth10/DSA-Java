package com.example.myapplication.dynamic_programming.problems;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestPath {

    static Graph graph;
    static int n = 4;
    static int e = 5;

    static int[] dp = new int[e];

    public static void main(String[] args) {
        graph = new Graph(e);
        graph.addEdges(1, 2, false);
        graph.addEdges(1, 3, false);
        graph.addEdges(3, 2, false);
        graph.addEdges(2, 4, false);
        graph.addEdges(3, 4, false);

        int result = longestPath();
        System.out.println("Result:" + result);
    }

    static int helper(int i) {
        int ans = 0;
        if (dp[i] != -1) {
            return dp[i];
        }
        for (int x : graph.list.get(i)) {
            ans = Math.max(ans, helper(x) + 1);
        }
        return dp[i] = ans;
    }

    static int longestPath() {
        Arrays.fill(dp, -1);
        int ans = 0;

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, helper(i));
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
