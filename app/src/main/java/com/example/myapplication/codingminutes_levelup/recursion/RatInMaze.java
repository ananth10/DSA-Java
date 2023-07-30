package com.example.myapplication.codingminutes_levelup.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Rat in a Maze
 * <p>
 * You are given a an integer N and a grid of size NxN.
 * The cells of the grid are numbered row wise from 1 to N^2.
 * Rat wants to travel from cell number 1 to cell number N^2,
 * and it can move in only right direction or down direction from a particular cell.
 * There is exactly one path from source to destination as some cells are blocked.
 * Help the rat to find the path.
 * <p>
 * Input Format:
 * <p>
 * In the function an integer N is given,
 * and a 2D vector consisting of only 'O's And 'X's is given where 'X' represents blocked cell
 * <p>
 * Output Format:
 * <p>
 * Return a vector of cell numbers of cells in path (in sequence).
 * <p>
 * Sample Testcase:
 * <p>
 * Input:
 * <p>
 * 4
 * <p>
 * O O X O
 * <p>
 * O X O O
 * <p>
 * O O O X
 * <p>
 * X  X O O
 * <p>
 * Output:
 * <p>
 * 1  5  9  10  11  15  16
 */
public class RatInMaze {

    public static void main(String[] args) {
        int n = 4;
        char[][] matrix = {
                {'0', '0', 'X', '0'},
                {'0', 'X', '0', '0'},
                {'0', '0', '0', 'X'},
                {'X', 'X', '0', '0'}
        };
        List<Integer> result = new ArrayList<>();
        result.add(1);
        ratInMaze(matrix, result, n - 1, 0, 0);
        Collections.sort(result);
        System.out.println("Result: " + result);
    }

    static boolean ratInMaze(char[][] grid, List<Integer> result, int n, int row, int col) {
        //base case
        if (row == n && col == n)
            return true;
        if (row == n + 1 || col == n + 1) {
            return false;
        }

        //recursive case

        //move right
        if (col != n && grid[row][col + 1] != 'X') {
            if (ratInMaze(grid, result, n, row, col + 1)) {
                result.add(row * (n + 1) + col + 2);
                return true;
            }
        }

        //move down
        if (row != n && grid[row + 1][col] != 'X') {
            if (ratInMaze(grid, result, n, row + 1, col)) {
                result.add((row + 1) * (n + 1) + col + 1);
                return true;
            }
        }
        return false;
    }
}
