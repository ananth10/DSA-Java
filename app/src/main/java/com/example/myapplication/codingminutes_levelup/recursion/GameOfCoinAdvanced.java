package com.example.myapplication.codingminutes_levelup.recursion;


/**
 * Game of coins - Advanced
 * Oswald and Henry are again playing the game of coins. They have a row of 'n' coins [C1,C2,C3...Cn] with values [V1,V2,V3...Vn] where Ci coin has Vi value. They take turns alternatively. In one turn the player can pick either the first or the last coin of the row and he is supposed to do it 'k' times in a turn. Given both Oswald and Henry are very smart players, you need to find the maximum possible value Oswald can earn if he plays first.
 * Input Format:
 * <p>
 * In the function you are given an integer N i.e. the number of coins, an integer K which is number of pickups in one turn and a vector V which represents the values of each coin in the row respectively.
 * <p>
 * Output Format:
 * <p>
 * Return a single integer which is the maximum possible value as asked in the question.
 * <p>
 * Constraints:
 * <p>
 * 1<=N<=15
 * <p>
 * 1<=K<=N
 * <p>
 * 1<=V[i]<=1000
 * <p>
 * Sample Testcase:
 * <p>
 * Input:
 * <p>
 * 6 2
 * <p>
 * 10 15 20 9 2 5
 * <p>
 * Output:
 * <p>
 * 32
 * <p>
 * Explanation:
 * <p>
 * Lets say, Oswald has initially picked 10 and 15.
 * <p>
 * The value of coins which the user has is 25 and
 * <p>
 * {20, 9, 2, 5} are remaining in the array.
 * <p>
 * In the second round, the Henry picks 20 and 9 making his value 29.
 * <p>
 * In the third round, the Oswald picks 2 and 5 which makes his total value as 32.
 */
public class GameOfCoinAdvanced {

    public static void main(String[] args) {
        int[] coins = {10, 15, 20, 9, 2, 5};
        int end = coins.length - 1;
        int k = 2;
        int result = gameOfCoin(coins, 0, end, k);
        System.out.println("Result :" + result);

    }

    static int gameOfCoin(int[] coins, int start, int end, int k) {
        //base case
        if (end - start + 1 < 0) {
            return 0;
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i <= k; i++) {
            int ans = sum(coins, start, start + i) + sum(coins, end - k + i + 1, end + 1);
            int opt = Integer.MAX_VALUE;
            //recursion part going to solve the sub problem
            for (int j = 0; j <= k; j++) {
                opt = Math.min(opt, gameOfCoin(coins, start + i + j, end - k + i - k + j, k));
            }
            res = Math.max(res, ans + opt);
        }

        return res;
    }

    static int sum(int[] coins, int i, int j) { //i, j are ranges
        int res = 0;
        for (int k = i; k < j; k++) {
            System.out.println("SUM:"+coins[k]);
            res += coins[k];
        }

        return res;
    }
}
