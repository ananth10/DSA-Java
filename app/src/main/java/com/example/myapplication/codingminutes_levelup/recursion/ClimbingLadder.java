package com.example.myapplication.codingminutes_levelup.recursion;

/**
 * Given a ladder containing N steps, you can take jump of 1,2, or 3 at each steps
 * find the number of ways to climb the ladder.
 *
 * Time = O(3N)
 */
public class ClimbingLadder {

    public static void main(String[] args) {
        int n = 4;
        int result = countWays(n);
        System.out.println("Result:" + result);
    }

    static int countWays(int n) {
        //base case
        if (n == 0) {
            return 1;
        }
        //handle negative case
        if (n < 0) {
            return 0;
        }

        //recursive case
        return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
    }
}
