package com.example.myapplication.dynamic_programming.tree;

import com.example.myapplication.codingminutes.graph.AdjacencyList01;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


public class VertexCover {
    static Graph graph;
    static int[][] dp;

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


