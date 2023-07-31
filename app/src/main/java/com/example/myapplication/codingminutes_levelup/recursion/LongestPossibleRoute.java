package com.example.myapplication.codingminutes_levelup.recursion;

import java.util.Arrays;

/**
 * Longest Possible Route
 * -------------------------
 * <p>
 * Given an M x N matrix, with a few hurdles arbitrarily placed,
 * calculate the length of longest possible route possible from top left position (0,0) to bottom right position (m,n)  within the matrix.
 * We are allowed to move to only adjacent cells which are not hurdles.
 * The route cannot contains any diagonal moves and a location once visited in a particular path cannot be visited again.
 * <p>
 * Input Format:
 * <p>
 * In the function you are given number of rows M, number of columns N and 2D vector (M X N) consisting of 0s and 1s where 0s represents the hurdles.
 * <p>
 * Output Format:
 * <p>
 * A single integer representing the length of longest path.
 * <p>
 * Constraints:
 * <p>
 * 1<=M,N<=10
 * <p>
 * Sample Testcase:
 * <p>
 * Input:
 * <p>
 * 3 3
 * <p>
 * 1 1 1
 * <p>
 * 1 1 1
 * <p>
 * 0 0 1
 * <p>
 * Output:
 * 6
 */
public class LongestPossibleRoute {
    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        int[][] matrix = {
                {1, 1, 1},
                {0, 1, 1},
                {0, 0, 1}
        };
        boolean[][] visited = new boolean[m][n];

        // Fill each row with 10.
        for (boolean[] row : visited) {
            Arrays.fill(row, false);
        }
        visited[0][0] = true;
        int result = longestPossibleRoute(matrix, visited, m - 1, n - 1, 0, 0, Integer.MIN_VALUE, 0);
        System.out.println("Result:" + result);
    }

    static int longestPossibleRoute(int[][] matrix, boolean[][] visited, int m, int n, int row, int col, int longestPath, int currentLength) {
        //base case
        if (row == m && col == n) {
            return Math.max(longestPath, currentLength);
        }
        //recursive case

        //move top
        if (row > 0 && !visited[row - 1][col] && matrix[row - 1][col] == 1) {
            currentLength += 1;
            visited[row - 1][col] = true;
            longestPath = longestPossibleRoute(matrix, visited, m, n, row - 1, col, longestPath, currentLength);
        }
        //move bottom
        if (row < m && !visited[row + 1][col] && matrix[row + 1][col] == 1) {
            currentLength += 1;
            visited[row + 1][col] = true;
            longestPath = longestPossibleRoute(matrix, visited, m, n, row + 1, col, longestPath, currentLength);
        }
        //move left
        if (col > 0 && !visited[row][col - 1] && matrix[row][col - 1] == 1) {
            currentLength += 1;
            visited[row][col - 1] = true;
            longestPath = longestPossibleRoute(matrix, visited, m, n, row, col - 1, longestPath, currentLength);
        }
        //move right
        if (col < n && !visited[row][col + 1] && matrix[row][col + 1] == 1) {
            currentLength += 1;
            visited[row][col + 1] = true;
            longestPath = longestPossibleRoute(matrix, visited, m, n, row, col + 1, longestPath, currentLength);
        }
        return longestPath;
    }
}
