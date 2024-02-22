package com.example.myapplication.dynamic_programming.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class VertexCover {
    static Graph graph;
    static int[][] dp;

    static int root;

    public static void main(String[] args) {
        int n = 8;

        graph = new Graph(n);
        graph.addEdges(1, 2, true);
        graph.addEdges(1, 3, true);
        graph.addEdges(1, 4, true);
        graph.addEdges(2, 5, true);
        graph.addEdges(3, 6, true);
        graph.addEdges(4, 7, true);
        dp = new int[n][2];
        int result = Math.min(vertexCover(1, true, -1), vertexCover(1, false, -1));

        System.out.println("Result: " + result);

        dp = new int[n][2];
        dfs(1, 0);
        int result1 = Math.min(dp[1][0], dp[1][1]);
        System.out.println("DFS Result1: " + result1);

        dp = new int[n][2];
        int result2 = bfs();
        System.out.println("BFS Result1: " + result2);
    }

    static int vertexCover(int current, boolean take, int parent) {
        int _take = take ? 1 : 0;
        dp[current][_take] = take ? 1 : 0;
        for (int x : graph.list.get(current)) {
            if (x != parent) {
                if (take) {
                    dp[current][_take] += Math.min(vertexCover(x, true, current), vertexCover(x, false, current));
                } else {
                    dp[current][_take] += vertexCover(x, true, current);
                }
            }
        }
        return dp[current][_take];
    }


    static void dfs(int current, int parent) {
        dp[current][0] = 0;
        dp[current][1] = 1;

        for (int x : graph.list.get(current)) {
            if (x != parent) {
                dfs(x, current);

                dp[current][0] += dp[x][1];
                dp[current][1] += Math.min(dp[x][0], dp[x][1]);
            }
        }
    }


    static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.list.size()];
        for (int i = 0; i < graph.list.size(); i++) {
            if (graph.list.get(i).size() == 1) {
                queue.add(i);
            }
        }
        for (int j : queue) {
            System.out.println("EL:" + j);
        }
        while (!queue.isEmpty()) {
            int current = queue.poll();
            visited[current] = true;
            root = current;
            dp[current][0] = 0;
            dp[current][1] = 1;

            for (int x : graph.list.get(current)) {
                if (visited[x]) {
                    dp[current][0] += dp[x][1];
                    dp[current][1] += Math.min(dp[x][0], dp[x][1]);
                } else {
                    queue.add(x);
                }
            }

        }

        return Math.min(dp[root][0], dp[root][1]);
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


