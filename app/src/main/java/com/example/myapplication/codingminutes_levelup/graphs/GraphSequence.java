package com.example.myapplication.codingminutes_levelup.graphs;


import com.example.myapplication.codingminutes_levelup.recursion.MaxCoinPicking;

import java.util.Arrays;

/**
 * Graph Sequence
 * --------------
 * <p>
 * Complete the following function which takes in an implicit graph (2D Matrix) and returns the length of longest increasing path sequence inside it.
 * A  path can start from any node (x,y), and is increasing if each of its elements is strictly greater than previous element.
 * (Assume - 4 way connectivity, each cell is connected with Top, Left, Up & Down)
 * <p>
 * Sample Input
 * [
 * [0,  2,  4,  3,  2],
 * [7,  6,  5,  5,  1],
 * [8,  9,  7, 18, 14],
 * [5, 10, 11, 12, 13],
 * ]
 * Sample output
 * 15
 * Explanation
 * Look at the following path that starts from 1 and ends at 18. It has 15 nodes.
 */
public class GraphSequence {

    public static void main(String[] args) {
        int[][] grid = {
                {0, 2, 4, 3, 2},
                {7, 6, 5, 5, 1},
                {8, 9, 7, 18, 14},
                {5, 10, 11, 12, 13}
        };

        int count = graphSequence(grid);
        System.out.println("Result: " + count);
    }

    private static int graphSequence(int[][] grid) {
        int rowSize = grid.length;
        int colSize = grid[0].length;
        boolean[][] visited = new boolean[rowSize][colSize];
        for (boolean[] row : visited) {
            Arrays.fill(row, false);
        }
        int[][] cache = new int[rowSize][colSize];

        int maxCount = 0;

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                dfs(grid, i, j, visited, cache, rowSize, colSize);
                maxCount = Math.max(cache[i][j], maxCount);
            }
        }

        return maxCount+1;
    }

    private static void dfs(int[][] grid, int i, int j, boolean[][] visited, int[][] cache, int rowSize, int colSize) {
        visited[i][j] = true;
        int count = 0;

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];
            int subCellCount = 0;
            //check boundary
            if (nx >= 0 && nx < rowSize && ny >= 0 && ny < colSize && grid[nx][ny] > grid[i][j]) {
                if (!visited[nx][ny]) {
                    dfs(grid, nx, ny, visited, cache, rowSize, colSize);
                }
                count = Math.max(count, 1 + cache[nx][ny]);
            }
        }
        cache[i][j] = count;
    }
}
