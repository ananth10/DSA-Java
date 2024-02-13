package com.example.myapplication.dynamic_programming.combinotric;

public class PlaceTiles {

    public static void main(String[] args) {
        int n = 10;

        int result = noOfWayToPlaceTiles(n);
        System.out.println("Result: " + result);

        int n1 = 8;
        int result1 = noOfWayToPlaceTiles1(n1);
        System.out.println("Result1: " + result1);
    }

    //1*2 tile placing
    private static int noOfWayToPlaceTiles(int n) {
        int[] f = new int[n + 1];
        int[] g = new int[n + 1];
        //base case
        f[0] = g[0] = 0;
        f[1] = g[1] = 1;
        f[2] = g[2] = 2;

        for (int i = 3; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2] + 2 * g[i - 2];
            g[i] = g[i - 1] + f[i - 1];
        }

        return f[n];
    }

    //1*3 tile placing
    private static int noOfWayToPlaceTiles1(int n) {
        int[] f = new int[n + 1];
        int[] g = new int[n + 1];
        //base case
        f[0] = g[0] = 1;
        f[1] = g[1] = 0;

        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 2] + 2 * g[i - 2];
            g[i] = g[i - 2] + f[i];
        }

        return f[n];
    }
}
