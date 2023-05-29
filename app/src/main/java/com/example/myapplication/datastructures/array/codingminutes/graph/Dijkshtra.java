package com.example.myapplication.datastructures.array.codingminutes.graph;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class Dijkshtra {

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0, 1, 1, true);
        g.addEdge(1, 2, 1, true);
        g.addEdge(0, 2, 4, true);
        g.addEdge(0, 3, 7, true);
        g.addEdge(3, 2, 2, true);
        g.addEdge(3, 4, 3, true);

        System.out.println(g.dijkstra(0, 4));
    }

    private static class Pair implements Comparable<Pair> {
        int distance;
        int node;

        public Pair(int dist, int node) {
            this.distance = dist;
            this.node = node;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.distance != o.distance) {
                return this.distance - o.distance;
            }
            return this.node - o.node;
        }
    }

    private static class Graph {
        int V;
        List<Pair>[] list;

        public Graph(int v) {
            V = v;
            list = new ArrayList[V];
            for (int i = 0; i < V; i++) {
                list[i] = new ArrayList<>();
            }
        }

        void addEdge(int u, int v, int weight, boolean undirected) {
            list[u].add(new Pair(weight,v));
            if (undirected) {
                list[v].add(new Pair(weight,u));
            }
        }

        void printAll() {
            for (int i = 0; i < V; i++) {
                System.out.print("Node " + i + " -->");
                for (Pair pair : list[i]) {
                    System.out.print(pair);
                }
                System.out.println();
            }
        }

        int dijkstra(int source, int destination) {
            //data structures
            int[] distance = new int[V];
            Arrays.fill(distance, Integer.MAX_VALUE);
            SortedSet<Pair> s = new TreeSet<>();

            distance[source]=0;
            //add source into set
            s.add(new Pair(0, source));

            while (!s.isEmpty()) {
                Pair front = s.first();
                int node = front.node;
                int distanceTillNow = front.distance;

                s.remove(front);

                //find neighbors and calculate distance from node
                for (Pair pair : list[node]) { //e.g node is 1
                    int nbr = pair.node; //node is 2 (node1--1--->node2)
                    int currentEdge = pair.distance; //distance is 1
                    if (distanceTillNow + currentEdge < distance[nbr]) {
                        //remove it already exist in the set .eg.(infinity,2)
                        s.remove(new Pair(distance[nbr], nbr));

                        //insert updated value with the new distance
                        distance[nbr] = distanceTillNow + currentEdge;
                        s.add(new Pair(distance[nbr], nbr));
                    }
                }
            }

            //Single source shortest distance to all other nodes
            for (int i = 0; i < V; i++) {
                System.out.println("Node i" + i + " Distance " + distance[i]);
            }

            return distance[destination];
        }
    }
}
