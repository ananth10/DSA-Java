package com.example.myapplication.dynamic_programming.tree;

import java.util.ArrayList;

public class TreeDiameter {
    static Graph graph;
    static int N = 8;
    static int[] f = new int[N];
    static int[] g = new int[N];

    public static void main(String[] args) {
        graph = new Graph(N);
        graph.addEdges(1, 2, true);
        graph.addEdges(1, 3, true);
        graph.addEdges(1, 4, true);
        graph.addEdges(2, 5, true);
        graph.addEdges(3, 6, true);
        graph.addEdges(4, 7, true);

        dfs(1, -1);
        System.out.println(" Result: " + f[1]);
    }

    static void dfs(int current, int parent) {
        int max_one = 0, max_two = 0;
        for (int x : graph.list.get(current)) { //current node children
            if (x != parent) {
                dfs(x, current);
                g[current] = Math.max(g[x] + 1, g[current]);
                f[current] = Math.max(f[x],f[current]);
                if (g[x] + 1 > max_one) {
                    max_two = max_one;
                    max_one = g[x] + 1;
                } else if (g[x] + 1 > max_two) {
                    max_two = g[x]+1;
                }
            }
        }
        f[current] = Math.max(f[current],max_one + max_two);
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
