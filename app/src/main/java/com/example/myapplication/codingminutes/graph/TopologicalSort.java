package com.example.myapplication.codingminutes.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSort {

    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdges(0, 2, false);
        g.addEdges(1, 2, false);
        g.addEdges(1, 4, false);
        g.addEdges(4, 5, false);
        g.addEdges(3, 5, false);
        g.addEdges(2, 3, false);
        g.topologicalSort();
    }

    private static class Graph {
        int V;
        ArrayList<Integer>[] list;

        public Graph(int v) {
            V = v;
            list = new ArrayList[V];
            for (int i = 0; i < V; i++) {
                list[i] = new ArrayList<>();
            }
        }

        private void addEdges(int x, int y, boolean undirected) {
            list[x].add(y);
            if (undirected) {
                list[y].add(x);
            }
        }

        private void printAll() {
            for (int i = 0; i < list.length; i++) {
                System.out.print(list[i] + "-->");
                for (int j = 0; j < list[i].size(); j++) {
                    System.out.print(list[i].get(j) + ", ");
                }
                System.out.println();
            }
        }

        void topologicalSort() {
            int[] indegree = new int[V];
            //step 1: calculate indegree for nodes
            for (int i = 0; i < V; i++) {
                for (int nbr : list[i]) {
                    indegree[nbr]++;
                }
            }
            Queue<Integer> queue = new LinkedList<>();
            //step 2: add 0 indegree nodes to queue
            for (int i = 0; i < V; i++) {
                if (indegree[i] == 0) {
                    queue.add(i);
                }
            }
            //step 3: popup out node from queue and reduce indegree for popup out nodes and add it to queue if it has 0 degree
            while (!queue.isEmpty()) {
                int front = queue.poll();
                System.out.print(front + ", ");
                for (int nbr : list[front]) {
                    indegree[nbr]--;
                    if (indegree[nbr] == 0) {
                        queue.add(nbr);
                    }
                }
            }
        }
    }


}
