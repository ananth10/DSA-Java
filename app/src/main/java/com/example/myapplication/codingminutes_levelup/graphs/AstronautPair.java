package com.example.myapplication.codingminutes_levelup.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import kotlin.Pair;

/**
 * Astronaut Pairs
 * ---------------
 * The member states of the UN are planning to send people to the moon.
 * They want them to be from different countries.
 * You will be given a list of pairs of astronaut ID's.
 * Each pair is made of astronauts from the same country.
 * Determine how many pairs of astronauts from different countries they can choose from.
 * <p>
 * Example
 * n = 4
 * astronauts = [1,2] [2,3]
 * There are 4 astronauts numbered 0 through 3.
 * Astonauts grouped by country are [0] and [1,2,3].
 * There are 3 pairs to choose from [0,1], [0,2] and [0,3].
 * <p>
 * Input
 * Input contains the number N : denoting number of astronauts and and list L denoting the pairs of astronauts from the same country.
 * N = 5
 * vector<pair<int,int> > astronauts = {{0,1}, {2,3} , {0,4}};
 * Output
 * 6
 * There are 6 ways to choose a pair (0,2) (0,3) (1,2) (1,3) (4,2) and (4,3) as astronauts (0,1,4) belong to country 1 and (2,3) belong to another.
 */
public class AstronautPair {

    public static void main(String[] args) {
        int n = 4;
        List<Pair<Integer, Integer>> pair = new ArrayList<>();
        pair.add(new Pair<>(1, 2));
        pair.add(new Pair<>(2, 3));
        int total = findAstronautPair(n, pair);
        System.out.println("Total:" + total);
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

        void addEdge(int u, int v) {
            list.get(u).add(v);
            list.get(v).add(u);
        }

        int dfs(int v, boolean[] visited) {
            //mark astro as selected
            visited[v] = true;
            int size = 1; //selected current astro

            //find the other astro in the same country
            for (int other : list.get(v)) {
                if (!visited[other]) {
                    size += dfs(other, visited);
                }
            }
            return size;
        }

        public int CountAstronauts() {

            boolean[] visited = new boolean[v];
            Arrays.fill(visited, false);

            //total number of ways to choose 2 astronauts from N astronauts
            int ans = v * (v - 1) / 2; //2 means we make one pair by using 2 astronauts and v-total astronaut and if we picked one astro then there v-1 astro remaining


            //Iterate through each astro
            for (int i = 0; i < v; i++) {
                if (!visited[i]) { //if astro is not selected, then select
                    int componentSize = dfs(i, visited); //total astro in same country
                    ans -= componentSize * (componentSize - 1) / 2; //total number of ways to choose 2 astronauts from same country, so remove it from total ans
                }
            }

            return ans;
        }
    }

    static int findAstronautPair(int n, List<Pair<Integer, Integer>> list) {

        Graph g = new Graph(n);
        for (int i = 0; i < list.size(); i++) {
            Pair<Integer, Integer> p = list.get(i);
            g.addEdge(p.getFirst(), p.getSecond());
        }

        return g.CountAstronauts();
    }
}
