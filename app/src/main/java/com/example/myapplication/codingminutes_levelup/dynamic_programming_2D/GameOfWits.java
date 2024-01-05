package com.example.myapplication.codingminutes_levelup.dynamic_programming_2D;

import java.util.Arrays;

/**
 * Game of Wits
 * Oswald and Henry are playing a game with alternating turns. Oswald plays first. The game starts with all game cards arranged in a single row.
 * The cards are of two types 'O' and 'H'.
 * During Oswald's turns, he must choose and remove an 'O' card that is either the leftmost or rightmost card remaining.
 * During Henry's turns, he must choose and remove an 'H' card that is either the leftmost or rightmost card remaining.
 * If at any point one of the players does not have a legal move (possibly because there are no cards remaining),
 * that player loses the game, and the other player is awarded 1 point plus 1 additional point for each card that remains on the board.
 * For example, initial row was OHOHHHOO.
 * On his first turn, Oswald can choose to remove either the leftmost or rightmost cards, as both are type 'O'. Suppose he chooses the leftmost (this may not be smart move). Then, the board would become HOHHHOO. Then, Henry would have no choice but to remove the new leftmost card, as the rightmost card is not H, leaving OHHHOO. Oswald can choose again, and this time he chooses the rightmost piece, leaving OHHHO for Henry's turn. At this point, Henry has no valid move, so Oswald won. Since there are 5 pieces remaining, Oswald wins 1+5=6 points in total.
 * Each player plays optimally trying to win and to maximize their own score. A player that cannot guarantee a win plays to minimize the opponent's score. Given the starting board, can you find out who wins and what is their score?
 * Input Format:
 * In the function, you are given a string S representing the initial row of cards.
 * Output Format:
 * You are supposed to return a pair of character and integer, where character represents the winner ('O' for Oswald and 'H' for Henry) and integer represents his score.
 * Constraints:
 * 2<=S.length()<=100
 * Sample Testcase:
 * Input:
 * HOOOOHHO
 * Output:
 * H 7
 * Explanation:
 * First turn: Oswald has only one option, picks up the rightmost O. Remaining row: HOOOOHH.
 * Second turn: Henry plays smartly, picks the right most H instead of leftmost. Remaining row: HOOOOH.
 * Third turn: Oswald has no option. Henry wins with 6+1=7 score.
 */
public class GameOfWits {
    public static void main(String[] args) {
        String s = "HOOOOHHO";
        int n = s.length();

        int[][] dp = new int[n + 1][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, 0);
        }
        int ans = gameOfWits(s, 0, n - 1, dp);
        if (ans > 0) {
            System.out.println("O:" + Math.abs(ans));
        } else {
            System.out.println("H:" + Math.abs(ans));
        }
    }

    private static int gameOfWits(String s, int i, int j, int[][] dp) {
        //base case
        if (i + 1 == j) {
            if (s.charAt(i) == 'O' && s.charAt(j) == 'O') {
                return 2;
            } else if (s.charAt(i) == 'H' && s.charAt(j) == 'H') {
                return -3;
            } else {
                return -1;
            }
        }

        if (i == j) {
            if (s.charAt(i) == 'O') {
                return 1;
            } else {
                return -2;
            }
        }

        //recursive case
        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        if (s.charAt(i) == 'H' && s.charAt(j) == 'H') {
            return dp[i][j] = -1 * (j - i + 1) - 1;
        } else if (s.charAt(i) == 'H' && s.charAt(j) == 'O') {

            int op1 = Integer.MAX_VALUE;
            if (s.charAt(j - 1) == 'H') {
                op1 = gameOfWits(s, i, j - 2, dp);
            }
            int op2 = gameOfWits(s, i + 1, j - 1, dp);
            return dp[i][j] = Math.min(op1, op2);
        } else if (s.charAt(i) == 'O' && s.charAt(j) == 'H') {

            int op1 = Integer.MAX_VALUE;
            if (s.charAt(i + 1) == 'H') {
                op1 = gameOfWits(s, i + 2, j, dp);
            }
            int op2 = gameOfWits(s, i + 1, j - 1, dp);
            return dp[i][j] = Math.min(op1, op2);
        } else {

            if (s.charAt(i + 1) == 'O' || s.charAt(j - 1) == 'O') {
                return j - i + 1;
            } else {
                int op1 = gameOfWits(s, i + 2, j, dp);
                int op2 = gameOfWits(s, i, j - 2, dp);
                return dp[i][j] = Math.min(op1, op2);
            }
        }

    }
}
