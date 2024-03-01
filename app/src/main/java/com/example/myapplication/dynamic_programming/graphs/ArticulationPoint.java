package com.example.myapplication.dynamic_programming.graphs;

import android.icu.text.Edits;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import kotlin.Pair;

public class ArticulationPoint {

    static Graph graph;
    static int N = 6;

    static boolean[] visited = new boolean[N];
    static int[] low = new int[N];
    static int[] disc = new int[N];

    static int time = 1;


    static HashSet<Pair<Integer, Integer>> bridges = new HashSet<>();
    static HashSet<Integer> articulations = new HashSet<>();


    public static void main(String[] args) {
        graph = new Graph(N);
        graph.addEdges(1, 2, true);
        graph.addEdges(2, 3, true);
        graph.addEdges(2, 4, true);
        graph.addEdges(3, 4, true);
        graph.addEdges(4, 5, true);

        dfs(1, 0);
        Iterator<Integer> iter = articulations.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        Iterator<Pair<Integer, Integer>> bridgeIter = bridges.iterator();
        while (bridgeIter.hasNext()) {
            System.out.println(bridgeIter.next());
        }
    }


    static void dfs(int current, int parent) {
        visited[current] = true;
        low[current] = disc[current] = time++;
        int child = 0;
        for (int x : graph.list.get(current)) {
            if (!visited[x]) {
                dfs(x, current);
                child++;
                //we know low x and disc x
                low[current] = Math.min(low[x], low[current]);

                //bridges
                if (low[x] > disc[current]) {
                    bridges.add(new Pair<>(current, x));
                }
                //articulation points
                if (parent != 0 && low[x] >= disc[current]) {
                    articulations.add(current);
                }
            } else if (x != parent) {
                //backedge
                low[current] = Math.min(low[current], disc[x]);
            }
        }


        //root is an articulation or not
        if (parent == 0 && child > 1) {
            articulations.add(current);
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
