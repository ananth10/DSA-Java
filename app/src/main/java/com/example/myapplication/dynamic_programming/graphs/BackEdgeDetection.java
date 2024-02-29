package com.example.myapplication.dynamic_programming.graphs;

import com.example.myapplication.dynamic_programming.tree.CompanyQueries;

import java.util.ArrayList;
import java.util.Arrays;

public class BackEdgeDetection {
    static Graph graph;
    static int N = 8;

    static boolean isCycle = false;
    static boolean[] visited = new boolean[N];
    static int[] vis = new int[N];

    public static void main(String[] args) {
        graph = new Graph(N);
        graph.addEdges(1, 3, true);
        graph.addEdges(1, 2, true);
        graph.addEdges(2, 3, true);
        graph.addEdges(2, 4, true);
        graph.addEdges(4, 5, true);
        graph.addEdges(5, 6, true);
        graph.addEdges(6, 7, true);
        graph.addEdges(7, 4, true);

        for (int i = 1; i < N; i++) {
            if (!visited[i]) {
                dfs_1(i, 0);
            }
        }

        if (isCycle) {
            System.out.println("Cycle is found in undirected graph");
        }

        isCycle = false;
        //directed
        for (int i = 1; i < N; i++) {
            if (vis[i] == 0) {
                dfs_2(i, 0);
            }
        }
        if (isCycle) {
            System.out.println("Cycle is found in directed graph");
        }
    }

    //detect cycle in undirected graph
    static void dfs_1(int current, int parent) {
        visited[current] = true;
        System.out.println(current);
        for (int x : graph.list.get(current)) {
            if (!visited[x]) {
                dfs_1(x, current);
            } else if (x != parent) {
                isCycle = true;
            }
        }
    }

    //detect cycle in udirected graph
    static void dfs_2(int current, int parent) {
        //added to the call stack
        vis[current] = 1;
        System.out.println(current);
        for (int x : graph.list.get(current)) {
            if (vis[x] == 0) {
                dfs_2(x, current);
            } else if (x != parent && vis[x] == 1) {
                isCycle = true;
            }
        }
        //removed from the call stack
        vis[current] = 2;
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
