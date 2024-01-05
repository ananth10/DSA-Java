package com.example.myapplication.dynamic_programming.backtracking;


import java.util.ArrayList;
import java.util.List;

/**
 * HamiltonianPath is a path in a directed or undirected graph that visits
 * each vertex exactly once, The problem to check whether a graph(directed or undirected)
 * contains a Hamiltonian path is NP-complete, so is the problem of finding all the
 * Hamiltonian Paths in graph.
 * */
public class HamiltonianPath {

    int count = 0;
    static int n = 4;
    static boolean hamiltanionPath = false;
    static boolean[] visited = new boolean[n];
    public static void main(String[] args){
        Graph g = new Graph(n);
        g.addEdge(0, 1, true);
        g.addEdge(1, 2, true);
        g.addEdge(2, 3, true);
        g.addEdge(1, 3, true);
        for (int i =0;i<n;i++){
            hamiltonianPath(i,1,g);
        }
        System.out.println("Result: "+ hamiltanionPath);
    }

     static void hamiltonianPath(int node, int count,Graph graph){
        if(count==n){
            hamiltanionPath = true;
        }
        visited[node]=true;

         for (int nbr:graph.list.get(node)) {
             if(!visited[nbr]){
                 hamiltonianPath(nbr,count+1,graph);
             }
         }

        visited[node] = false;
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

        void addEdge(int v, int u, boolean undirected) {
            list.get(v).add(u);
            if (undirected) {
                list.get(u).add(v);
            }
        }
    }

}
