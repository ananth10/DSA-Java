package com.example.myapplication.datastructures.array.codingminutes.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DFS {

    public static void main(String[] args) {
        Graph g = new Graph(7);
        g.addEdge(0, 1, true);
        g.addEdge(1, 2, true);
        g.addEdge(2, 3, true);
        g.addEdge(3, 5, true);
        g.addEdge(5, 6, true);
        g.addEdge(4, 5, true);
        g.addEdge(0, 4, true);
        g.addEdge(3, 4, true);
        g.dfs(1);

    }

    static class Graph {
        int V;
        ArrayList<Integer>[] list;

        public Graph(int v) {
            this.V = v;
            list = new ArrayList[v];
            for (int i = 0; i < v; i++) {
                list[i] = new ArrayList<>();
            }
        }

        void addEdge(int i, int j, boolean undirected) {
            list[i].add(j);
            if (undirected) {
                list[j].add(i);
            }
        }

        void dfs(int source) {
            Boolean[] visited = new Boolean[V];
            Arrays.fill(visited, false);
            dfsHelper(source, visited);
        }


        void dfsHelper(int source, Boolean[] visited) {
            visited[source] = true;
            System.out.print(source + ", ");
            for (int neighbor : list[source]) {
                if (!visited[neighbor]) {
                    dfsHelper(neighbor, visited);
                }
            }
        }

    }
}
