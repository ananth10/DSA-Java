package com.example.myapplication.codingminutes.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BackEdgedGraph {

    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(0, 5);
        g.addEdge(5, 4);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 0);

        boolean result = isGraphContainsCycle(g);
        System.out.println("is graph contains cycle:"+result);
    }

    static class Graph {
        int v;

        List<List<Integer>> list;

        public Graph(int v) {
            this.v = v;
            list = new ArrayList<>();

            for (int i = 0; i < v; i++) {
                list.add(new ArrayList<>());
            }
        }

        void addEdge(int v, int u) {
            list.get(v).add(u);
        }


        boolean dfs(int src, boolean[] visited, boolean[] stack) {
            visited[src] = true;
            stack[src] = true;

            for (int nbr : list.get(src)) {
                if (stack[nbr]) {
                    return true;
                } else if (!visited[nbr]) {
                    boolean isNbrContainsCycle = dfs(nbr, visited, stack);
                    if (isNbrContainsCycle) {
                        return true;
                    }
                }
            }
            stack[src] = false;

            return false;
        }
    }

    static boolean isGraphContainsCycle(Graph graph) {
        boolean[] visited = new boolean[graph.v];
        boolean[] stack = new boolean[graph.v];

        for (int i = 0; i < graph.v; i++) {
            if (!visited[i]) {
                if (graph.dfs(i, visited, stack)) {
                    return true;
                }
            }
        }
        return false;
    }
}
