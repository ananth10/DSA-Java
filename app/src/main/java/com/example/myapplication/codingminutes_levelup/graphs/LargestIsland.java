package com.example.myapplication.codingminutes_levelup.graphs;


import java.util.Arrays;

/**
 * Largest Island
 * --------------
 * You are given a two dimensional grid, containing only 0 s and 1s.
 * Each 1 represents land, and 0 represents water.
 * The adjacent 1s form an island. Each land piece (x,y) is connected to its 4 neighbours (Left, Right, Up and Down).
 * Your task is to find the size of largest island - size of island is given by number of 1s in that island.
 * Your code should return 0 is no island is present.
 * <p>
 * Sample Input
 * grid = [
 * [1, 0, 0, 1, 0],
 * [1, 0, 1, 0, 0],
 * [0, 0, 1, 0, 1],
 * [1, 0, 1, 1, 1],
 * [1, 0, 1, 1, 0]
 * ]
 * Sample Output
 * 8
 * Explanation
 * There are 4 islands (connected components) of sizes 2,1,8,2 out of which 8 is largest.
 */
public class LargestIsland {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 0, 0, 1, 0},
                {1, 0, 1, 0, 0},
                {0, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 0, 1, 1, 0},
        };

        int largest = largestIsland(grid);
        System.out.println("Largest island size is :" + largest);
    }

    private static int largestIsland(int[][] grid) {
        int rowSize = grid.length;
        int colSize = grid[0].length;
        boolean[][] visited = new boolean[rowSize][colSize];
        for (boolean[] row : visited) {
            Arrays.fill(row, false);
        }
        int largest = 0;
        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                if (grid[row][col] == 1 && !visited[row][col]) {
                    int islandCount = dfs(grid, row, col, rowSize, colSize, visited);
                    largest = Math.max(islandCount, largest);

                }
            }
        }

        return largest;
    }

    private static int dfs(int[][] grid, int i, int j, int rowSize, int colSize, boolean[][] visited) {
        visited[i][j] = true;

        int currentCount = 1;

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];

            //check boundary
            if (x >= 0 && x < rowSize && y >= 0 && y < colSize && grid[x][y] == 1 && !visited[x][y]) {
                int subIslandCount = dfs(grid, x, y, rowSize, colSize, visited);
                currentCount += subIslandCount;
            }
        }

        return currentCount;
    }
}
