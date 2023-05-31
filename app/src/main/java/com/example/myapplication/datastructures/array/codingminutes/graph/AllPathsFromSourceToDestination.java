package com.example.myapplication.datastructures.array.codingminutes.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllPathsFromSourceToDestination {
    public static void main(String[] args) {
        List<List<Integer>> graphs = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3),
                Arrays.asList(3),
                Arrays.asList()
        );

        List<List<Integer>> allPaths = allPathsFromSourceToDestination(graphs);
        System.out.println(allPaths);
    }

    static List<List<Integer>> allPathsFromSourceToDestination(List<List<Integer>> graphs) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPaths = new ArrayList<>();
        int node = graphs.size();
        if (node == 0)
            return allPaths;
        dfs(graphs, allPaths, currentPaths, 0, node - 1);
        return allPaths;
    }

    static void dfs(List<List<Integer>> graphs, List<List<Integer>> allPaths, List<Integer> currentPaths, int src, int dest) {
        currentPaths.add(src);
        //base case
        if (src == dest) {
            allPaths.add(new ArrayList<>(currentPaths));
            currentPaths.remove(currentPaths.size() - 1);
            return;
        }

        //recursive case
        for (int node : graphs.get(src)) {
            dfs(graphs, allPaths, currentPaths, node, dest);
        }
        currentPaths.remove(currentPaths.size() - 1);
    }
}
