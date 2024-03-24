package com.example.myapplication.dynamic_programming.problems;

import com.example.myapplication.dynamic_programming.tree.TreeDistance;

import java.util.ArrayList;
import java.util.Arrays;

public class IndependentSet {

    static Graph graph;

    static int N = 4;

    static int[][] dp = new int[N][2];

    public static void main(String[] args) {
        graph = new Graph(N);
        graph.addEdges(1, 2, true);
        graph.addEdges(2, 3, true);

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int result = independentSet(1, 1, 0) + independentSet(1, 0, 0);
        System.out.println("Result:" + result);
    }

    static int independentSet(int current, int paint, int parent) {
        int ans = 1;

        if (dp[current][paint] != -1)
            return dp[current][paint];
        //0 -black 1- white
        for (int x : graph.list.get(current)) {
            if (x != parent) {
                if (paint == 1) {
                    ans *= independentSet(x, 0, current) + independentSet(x, 1, current);
                } else {
                    ans *= independentSet(x, 1, current);
                }
            }

        }

        return dp[current][paint] = ans;
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
