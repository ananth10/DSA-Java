package com.example.myapplication.codingminutes_levelup.graphs;


import java.util.Arrays;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Shortest Grid Path
 * -------------------
 * Given a two dimensional grid,each cell of which contains integer cost which represents a cost to traverse through that cell,
 * we need to find a path from top left cell to bottom right cell by which total cost incurred is minimum.
 * <p>
 * Note:It is assumed that negative cost cycles do not exist in input matrix
 * <p>
 * Input
 * <p>
 * Grid as shown above(input given as vector<vector<int>>grid).
 * Hint:Use grid.size()to get rows and grid[0].size()to get columns.
 * <p>
 * 31 100 64 12 18
 * 10 13 47 157 6
 * 100 113 174 11 33
 * 88 124 41 20 140
 * 99 32 111 41 20
 * Output
 * <p>
 * An integer denoting the minimum cost.
 * <p>
 * 327
 * Explanation
 * <p>
 * Cells in green are the cells which are visited to complete this route
 * 327(=31+10+13+47+65+12+18+
 * 6+33+11+20+41+20)
 */


public class ShortestGridPath {

    public static void main(String[] args) {
        int[][] path = {
                {31, 100, 65, 12},
                {10, 13, 4, 157},
                {20, 30, 40, 50},
        };

        int minCost = shortestGridPath(path);
        System.out.println("MinCost: " + minCost);
    }

    static class Node implements Comparable<Node> {
        int x;
        int y;

        int distance;

        public Node(int i, int j, int dist) {
            this.x = i;
            this.y = j;
            this.distance = dist;
        }

        @Override
        public int compareTo(Node node) {
            return Integer.compare(this.distance, node.distance);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    ", distance=" + distance +
                    '}';
        }
    }

    private static int shortestGridPath(int[][] path) {
        int row = path.length;
        int col = path[0].length;
        int[][] distance = new int[row][col];
        for (int[] row1 : distance) {
            Arrays.fill(row1, Integer.MAX_VALUE);
        }
        SortedSet<Node> set = new TreeSet<>();
        //first cell
        distance[0][0] = path[0][0];
        set.add(new Node(0, 0, distance[0][0]));

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        while (!set.isEmpty()) {
            Node top = set.first();
            int currentCellX = top.x;
            int currentCellY = top.y;
            int currentCellDistance = top.distance;
            set.remove(top);

            //update nbr nodes
            for (int k = 0; k < 4; k++) {
                int mx = currentCellX + dx[k];
                int my = currentCellY + dy[k];

                //new mx and my position should be inside the boundary for grid
                if (mx >= 0 && mx < row && my >= 0 && my < col && currentCellDistance + path[mx][my] < distance[mx][my]) {
                    //remove existing node from the set
                    Node temp = new Node(mx, my, distance[mx][my]);
                    if (set.contains(temp)) {
                        set.remove(temp);
                    }

                    //add new node with updated distance
                    int newDistance = currentCellDistance + path[mx][my];
                    distance[mx][my] = newDistance;
                    set.add(new Node(mx, my, newDistance));
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.println(distance[i][j] + " ");
            }
            System.out.println();
        }
        return distance[row - 1][col - 1];
    }
}
