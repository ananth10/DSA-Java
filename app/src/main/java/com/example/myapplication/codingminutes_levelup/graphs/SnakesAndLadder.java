package com.example.myapplication.codingminutes_levelup.graphs;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import kotlin.Pair;

public class SnakesAndLadder {


    public static void main(String[] args) {
        int n = 36;
        List<Pair<Integer, Integer>> snakes = new ArrayList<>();
        snakes.add(new Pair<>(12, 34));
        snakes.add(new Pair<>(16, 24));
        snakes.add(new Pair<>(30, 32));
        snakes.add(new Pair<>(6, 20));
        snakes.add(new Pair<>(4, 17));

        List<Pair<Integer, Integer>> ladders = new ArrayList<>();
        ladders.add(new Pair<>(2, 15));
        ladders.add(new Pair<>(5, 7));
        ladders.add(new Pair<>(9, 27));
        ladders.add(new Pair<>(18, 29));
        ladders.add(new Pair<>(25, 35));

        int turns = minDiceThrows(n, snakes, ladders);
        System.out.println("Minimum dice :" + turns);
    }

    static class Graph {
        static int v;
        static List<List<Integer>> list;

        public Graph(int v) {
            this.v = v;
            list = new ArrayList<>();

            for (int i = 0; i < v; i++) {
                list.add(new ArrayList<>());
            }
        }

        void addEdge(int u, int v) {
            list.get(u).add(v);
        }

        static int shortestPath(int src, int dest) {
            Queue<Integer> q = new LinkedList<>();
            boolean[] visited = new boolean[v];
            int[] distance = new int[v];

            //add src to queue
            q.add(src);
            visited[src] = true;
            distance[src] = 0;

            while (!q.isEmpty()) {
                int top = q.poll();
                List<Integer> nbrs = list.get(top);

                for (int nbr : nbrs) {
                    if (!visited[nbr]) {
                        visited[nbr] = true;
                        q.add(nbr);
                        distance[nbr] = distance[top] + 1;
                    }
                }
            }

            return distance[dest];
        }
    }

    static int minDiceThrows(int n, List<Pair<Integer, Integer>> snakes, List<Pair<Integer, Integer>> ladders) {
        List<Integer> boards = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            boards.add(0);
        }
        //board to graph conversation
        for (Pair<Integer, Integer> snake : snakes) {
            int start = snake.getFirst();
            int end = snake.getSecond();
            boards.add(end - start);
        }
        for (Pair<Integer, Integer> ladder : ladders) {
            int start = ladder.getFirst();
            int end = ladder.getSecond();
            boards.add(end - start);
        }

        //Graph
        Graph graph = new Graph(n + 1);
        for (int u = 1; u < n; u++) {
            for (int dice = 1; dice <= 6; dice++) {
                int v = u + dice;
                v += boards.get(v);
                if (v <= n) {
                    graph.addEdge(u, v);
                }
            }
        }

        return Graph.shortestPath(1, n);
    }
}
