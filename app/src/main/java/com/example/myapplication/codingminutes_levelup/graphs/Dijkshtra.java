package com.example.myapplication.codingminutes_levelup.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class Dijkshtra {

    public static void main(String[] args) {

        Graph g = new Graph(5);
        g.addEdge(0, 1, 1, true);
        g.addEdge(0, 4, 2, true);
        g.addEdge(0, 7, 3, true);
        g.addEdge(1, 1, 2, true);
        g.addEdge(2, 2, 3, true);
        g.addEdge(3, 3, 4, true);

        int result = dijkshtra(0, 4, g);
        System.out.println("Result:" + result);
    }

    static class Pair implements Comparable<Pair> {
        int distance;
        int node;

        public Pair(int d, int n) {
            this.distance = d;
            this.node = n;
        }

        @Override
        public int compareTo(Pair pair) {
            if (this.distance != pair.distance) {
                return this.distance - pair.distance;
            }
            return this.node - pair.node;
        }
    }

    static class Graph {
        int v;

        List<List<Pair>> list;

        public Graph(int v) {
            this.v = v;
            list = new ArrayList<>();
            for (int i = 0; i < v; i++) {
                list.add(new ArrayList<>());
            }
        }

        void addEdge(int v, int weight, int u, boolean undirected) {
            list.get(v).add(new Pair(weight, u));
            if (undirected) {
                list.get(u).add(new Pair(weight, v));
            }
        }
    }

    static int dijkshtra(int src, int des, Graph graph) {
        int[] distance = new int[graph.v];
        Arrays.fill(distance, Integer.MAX_VALUE);
        SortedSet<Pair> set = new TreeSet<>();

        distance[src] = 0;
        set.add(new Pair(distance[src], src));

        while (!set.isEmpty()) {
            Pair pair = set.first();//pull first sorted pair from set
            int node = pair.node;
            int distanceTillNow = pair.distance;
            set.remove(pair);// remove once we finalized bcoz this is the very low distance so far.
            for (Pair p : graph.list.get(node)) { //iterate over through neighbours of current node
                int currentEdge = p.distance;
                int nbr = p.node;
                if (distanceTillNow + currentEdge < distance[nbr]) {
                    //remove existing pair e.g(Integer.MAX_VALUE,1) initially later will be eg(3,1)
                    set.remove(new Pair(distance[nbr], nbr));

                    distance[nbr] = distanceTillNow + currentEdge;
                    Pair p2 = new Pair(distance[nbr], nbr);
                    //update new distance of node in set
                    set.add(p2);
                }
            }
        }

        for (int i = 0; i < graph.v; i++) {
            System.out.println("distance of " + i + "from " + src + " is " + distance[i]);
        }

        return distance[des];
    }
}
