package com.example.myapplication.codingminutes_levelup.recursion;

/**
 * Game of Coins
 * --------------
 * Oswald and Henry are playing the game of coins.
 * They have a row of 'n' coins [C1,C2,C3...Cn] with values [V1,V2,V3...Vn] where Ci coin has Vi value.
 * They take turns alternatively.
 * In one turn the player can pick either the first or the last coin of the row.
 * Given both Oswald and Henry are very smart players,
 * you need to find the maximum possible value Oswald can earn if he plays first.
 * <p>
 * Input Format:
 * In the function you are given an integer N i.e. the number of coins and a vector V which represents the values of each coin in the row respectively.
 * Output Format:
 * Return a single integer which is the maximum possible value as asked in the question.
 * <p>
 * Constraints:
 * 1<=N<=15
 * 1<=V[i]<=1000
 * <p>
 * Sample Testcase:
 * Input:
 * 4
 * 1 2 3 4
 * Output:
 * 6
 * Explanation:
 * Oswald will pick up coin with value 4,
 * Henry will pick coin with value 3, Oswald will pick 2 and Henry will pick 1. Hence 4+2=6.
 */

public class MaxCoinPicking {
    public static void main(String[] args) {

        int n = 4;
        int[] coins = {1, 2, 3, 4};
        int result = gameOfCoins(coins, 0, n - 1);
        System.out.println("Result:" + result);
    }

    static int gameOfCoins(int[] coins, int start, int end) {
        //base case
        if (start == end || start == end - 1) {
            return Math.max(coins[start], coins[end]);
        }

        //recursive case
        int option1 = coins[start] + Math.min(gameOfCoins(coins, start + 2, end), gameOfCoins(coins, start + 1, end - 1));
        int option2 = coins[end] + Math.min(gameOfCoins(coins, start + 1, end - 1), gameOfCoins(coins, start, end - 2));
        return Math.max(option1, option2);
    }
}
