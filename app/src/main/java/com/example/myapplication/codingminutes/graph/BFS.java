package com.example.myapplication.codingminutes.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

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
        g.bfs(1);

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

        void bfs(int source) {
            Queue<Integer> queue = new LinkedList<>();
            Boolean[] visited = new Boolean[V];
            Arrays.fill(visited, false);

            queue.add(source);
            visited[source] = true;

            while (!queue.isEmpty()) {
                int front = queue.poll();
                System.out.println(front);

                //PUsh the nbrs of current node inside q if they are not already visited
                for (int neighbor : list[front]) {
                    if (!visited[neighbor]) {
                        queue.add(neighbor);
                        visited[neighbor] = true;
                    }
                }
            }
        }
    }
}
