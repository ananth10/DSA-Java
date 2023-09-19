package com.example.myapplication.codingminutes_levelup.graphs;

import java.util.ArrayList;
import java.util.List;

public class CycleDetection {

    public static void main(String[] args) {
        Graph g = new Graph(3);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 0);

        boolean result = containsCyclic(0, 3, g);
        System.out.println("Is graph contains cyclic:" + result);
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
            list.get(u).add(v);
        }

        boolean dfs(int src, boolean[] visited, int parent) {
            visited[src] = true;
            for (int nbr : list.get(src)) {
                if (!visited[nbr]) {
                    boolean nbrContainsCyclic = dfs(nbr, visited, src);
                    if (nbrContainsCyclic) {
                        return true;
                    }
                } else if (nbr != parent) {
                    return true;
                }
            }
            return false;
        }
    }


    static boolean containsCyclic(int src, int v, Graph g) {
        boolean[] visited = new boolean[v];
        return g.dfs(src, visited, -1);
    }
}
