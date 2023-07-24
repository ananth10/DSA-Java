package com.example.myapplication.codingminutes_levelup.recursion;

/**
 * Subset Sum
 * ----------
 * <p>
 * Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum.
 * <p>
 * Input:
 * arr = {10,12,15,6,19,20}
 * sum = 16
 * <p>
 * output:
 * yes
 *
 * time = O(2^N) because there are 2 option, either include number or exclude
 */
public class SubSetSum {

    public static void main(String[] args) {
        int[] set = {1, 2, 3, 4, 5};
        int n = set.length;
        int sum = 6;

        int count = countSubSet(set, n, 0, sum);
        System.out.println("Result:" + count);
    }

    static int countSubSet(int[] set, int n, int i, int sum) {
        //base case
        if (i == n) {
            if (sum == 0) {
                return 1;//found 1 sub set
            }
            return 0;
        }

        //recursive case
        int include = countSubSet(set, n, i + 1, sum - set[i]);
        int exclude = countSubSet(set, n, i + 1, sum);
        return include + exclude;
    }
}
