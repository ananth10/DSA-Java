package com.example.myapplication.dynamic_programming.tree;

import java.util.ArrayList;

public class TreeDistance {
    static Graph graph;
    static int N = 6;
    static int[] g = new int[N];
    static int[] f = new int[N];

    public static void main(String[] args) {
        graph = new Graph(N);
        graph.addEdges(1, 2, true);
        graph.addEdges(1, 3, true);
        graph.addEdges(3, 4, true);
        graph.addEdges(3, 5, true);

        dfs_g(1, -1);
        dfs_f(1, -1, 0);

        for (int i = 1; i < N; i++) {
            System.out.print(f[i] + ", ");
        }
    }

    //f[current] = max(g[x]+1,distance_parent+1)

    //calculate g[x] value

    static void dfs_g(int current, int parent) {
        for (int x : graph.list.get(current)) {
            if (x != parent) {
                dfs_g(x, current);
                g[current] = Math.max(g[current], g[x] + 1);
            }
        }
    }

    static void dfs_f(int current, int parent, int dis_parent) {

        int max_1 = -1;
        int max_2 = -1;
        for (int x : graph.list.get(current)) {
            if (x != parent) {
                if (g[x] > max_1) {
                    max_2 = max_1;
                    max_1 = g[x];
                } else if (g[x] > max_2) {
                    max_2 = g[x];
                }
            }
        }

        for (int x : graph.list.get(current)) {
            if (x != parent) {
                int newDistanceParent = dis_parent;

//                for(int y : graph.list.get(current)){
//                    if(y!=parent && y!=x){
//                        newDistanceParent = Math.max(g[y],newDistanceParent);
//                    }
//                }
                if (g[x] == max_1) {
                    newDistanceParent = Math.max(newDistanceParent, max_2);
                } else {
                    newDistanceParent = Math.max(newDistanceParent, max_1);
                }

                dfs_f(x, current, newDistanceParent + 1);

                //for any node in the sub-tree
                f[current] = Math.max(f[current], g[x] + 1);


            }
        }
        //for any node in the super-tree
        f[current] = Math.max(f[current], dis_parent + 1);
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
