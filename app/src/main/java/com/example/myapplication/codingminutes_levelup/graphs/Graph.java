package com.example.myapplication.codingminutes_levelup.graphs;

import java.util.ArrayList;
import java.util.List;

public class Graph {


    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1, true);
        graph.addEdge(0, 4, true);
        graph.addEdge(2, 1, true);
        graph.addEdge(3, 4, true);
        graph.addEdge(4, 5, true);
        graph.addEdge(2, 3, true);
        graph.addEdge(3, 5, true);
        printGraph();
    }

    static List<List<Integer>> list;
    int v;

    public Graph(int vertex) {
        this.v = vertex;
        list = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            list.add(new ArrayList<>());
        }

    }

    void addEdge(int i, int j, boolean isUnDirected) {
        list.get(i).add(j);
        if (isUnDirected) {
            list.get(j).add(i);
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
}
