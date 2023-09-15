package com.example.myapplication.codingminutes_levelup.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import kotlin.Pair;

public class AdjacencyListGraph {


    public static void main(String[] args) {
        AdjacencyListGraph adjacencyListGraph = new AdjacencyListGraph(6);
        adjacencyListGraph.addEdge(0, 1, true);
        adjacencyListGraph.addEdge(0, 4, true);
        adjacencyListGraph.addEdge(2, 1, true);
        adjacencyListGraph.addEdge(3, 4, true);
        adjacencyListGraph.addEdge(4, 5, true);
        adjacencyListGraph.addEdge(2, 3, true);
        adjacencyListGraph.addEdge(3, 5, true);
        printGraph();

        adjacencyListGraph.addEdgeWithWeight(0, 1, 1, false);
        adjacencyListGraph.addEdgeWithWeight(0, 2, 4, false);
        adjacencyListGraph.addEdgeWithWeight(0, 3, 7, false);
        adjacencyListGraph.addEdgeWithWeight(3, 2, 2, false);
        adjacencyListGraph.addEdgeWithWeight(3, 4, 3, false);
//        printWeightGraph();

        bfs(1);
    }

    static List<List<Integer>> list;
    static List<List<Pair<Integer, Integer>>> weightList;
    static int v;

    public AdjacencyListGraph(int vertex) {
        this.v = vertex;
        list = new ArrayList<>();
        weightList = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            list.add(new ArrayList<>());
            weightList.add(new ArrayList<>());
        }

    }


    void addEdge(int i, int j, boolean isUnDirected) {
        list.get(i).add(j);
        if (isUnDirected) {
            list.get(j).add(i);
        }
    }

    void addEdgeWithWeight(int i, int j, int wts, boolean isUnDirected) {
        weightList.get(i).add(new Pair<>(j, wts));
        if (isUnDirected) {
            weightList.get(j).add(new Pair<>(i, wts));
        }
    }

    static void printGraph() {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(i + "--->");
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j) + ", ");
            }
            System.out.println();
        }
    }

    static void printWeightGraph() {
        for (int i = 0; i < weightList.size(); i++) {
            System.out.print(i + "--->");
            for (int j = 0; j < weightList.get(i).size(); j++) {
                System.out.print(weightList.get(i).get(j) + ", ");
            }
            System.out.println();
        }
    }

    static void bfs(int source) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[v];
        Arrays.fill(visited, false);

        q.add(source);
        visited[source] = true;

        while (!q.isEmpty()) {
            int top = q.poll();
            System.out.println(top);
            List<Integer> nbrs = list.get(top);
            for (int nbr : nbrs) {
                if (!visited[nbr]) {
                    q.add(nbr);
                    visited[nbr] = true;
                }
            }

        }
    }
}
