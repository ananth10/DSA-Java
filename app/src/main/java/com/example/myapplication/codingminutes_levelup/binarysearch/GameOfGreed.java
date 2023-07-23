package com.example.myapplication.codingminutes_levelup.binarysearch;

/**
 * You are playing a game with your 'k' friends. You have an array of N coins, at each index i you have a coin of value a[i].
 * Your task is to divide the coins, among a group of K friends by doing consecutive segments (k-subarrays) of the array.
 * Each friend will get a total sum of the coins in that subarray.
 * Since all your friends are greedy, and they will pick the largest k-1 segments and you will get the smallest segment.
 * Find out the maximum value you can make by making an optimal partition.
 * <p>
 * INPUT:
 * K = 3
 * coins = {1,2,3,4};
 * <p>
 * OUTPUT:
 * 3- coin
 */
public class GameOfGreed {
    public static void main(String[] args) {
        int[] coins = {1, 2, 3, 4};
        int k = 3; //friends

        int result = maxOfCoins(coins, k);
        System.out.println("Result:" + result);
    }

    static int maxOfCoins(int[] coins, int k) {
        int n = coins.length;
        int s = 0;
        int e = 0;
        int ans = 0;
        //find total sum
        for (int coin : coins) {
            e += coin;
        }
        while (s <= e) {
            int mid = (s + e) / 2;
            boolean isPossible = isRightCoins(coins, n, k, mid);//will it possible to get max num coins if we use coins[mid] coin among k friends
            if (isPossible) { //its possible then maximize the coins
                s = mid + 1;
                ans = mid;
            } else {
                e = mid - 1;
            }
        }

        return ans;
    }

    private static boolean isRightCoins(int[] coins, int n, int k, int minCoins) {
        int partition = 0;
        int currentFriendSum = 0;

        for (int i = 0; i < n; i++) {
            if (currentFriendSum + coins[i] >= minCoins) {
                partition += 1;
                currentFriendSum = 0;
            } else {
                currentFriendSum += coins[i];
            }
        }

        return partition >= k; //return true if every partition gets atleast limit no of coins
    }
}
