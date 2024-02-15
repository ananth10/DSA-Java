package com.example.myapplication.dynamic_programming.subsequences;

import java.util.ArrayList;
import java.util.Arrays;

public class GoodSequence {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 6, 7, 8, 9, 10};

        int result = bestEnding(arr);
        System.out.println("Result:"+result);
    }

    private static ArrayList<Integer> findPrimeDivisor(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                list.add(i);
            }
            while (n % i == 0) {
                n /= i;
            }
        }
        if (n > 1)
            list.add(n);
        return list;
    }

    private static int bestEnding(int[] arr) {
        int n = arr.length;
        double N = 1e5+1;
        int[] prime_dp = new int[(int) N];
        Arrays.fill(prime_dp,0);

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> primeList = findPrimeDivisor(i);

            int bestEndings = 0;
            for(int x : primeList){
                bestEndings = Math.max(bestEndings,prime_dp[x]);
            }

            //update best ending max len to other prime numbers
            for (int x : primeList){
                prime_dp[x] = bestEndings+1;//include the current element
            }
        }

        int maxLen = 1;
        for (int i = 0; i < prime_dp.length; i++) {
            maxLen = Math.max(maxLen, prime_dp[i]);
        }

        return maxLen;
    }
}
