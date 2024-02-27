package com.example.myapplication.dynamic_programming.tree;

import java.util.ArrayList;

public class CompanyQueries {

    static Graph graph;
    static int N = 6;

    static int n = (int) (2e5 + 1);
    static int m = 20;

    static int[][] parent = new int[n][m];

    static int q = 3;
    static int k = 3;

    public static void main(String[] args) {
        graph = new Graph(N);
        graph.addEdges(1, 2, true);
        graph.addEdges(1, 3, true);
        graph.addEdges(3, 4, true);
        graph.addEdges(3, 5, true);

        dfs(1, 0);

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println(i + " " + (int) Math.pow(2, j) + " " + parent[i][j]);
            }
        }


        System.out.println(giveKthParent(1, 1));
        System.out.println(giveKthParent(3, 3));
    }

    static int giveKthParent(int x, int k) {
        int current = x;
        for (int j = 0; j < m; j++) {
            if (((1 << j) & 1) > 0) {
                current = parent[current][j];
            }
        }
        if (current == 0)
            current = -1;
        return current;
    }

    static void dfs(int current, int par) {

        //calculate and save parent level for each node
        parent[current][0] = par;
        for (int j = 1; j < m; j++) {
            parent[current][j] = parent[parent[current][j - 1]][j - 1];
        }

        for (int x : graph.list.get(current)) {
            if (x != par) {
                dfs(x, current);
            }
        }
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
