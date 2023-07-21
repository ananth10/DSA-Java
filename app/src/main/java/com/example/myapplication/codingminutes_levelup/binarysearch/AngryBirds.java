package com.example.myapplication.codingminutes_levelup.binarysearch;

import java.util.Arrays;

/**
 * There is a long wire along at straight line, which contains N bird nests at positive x1,x2...xn
 * There are B(B<=N) birds which become angry towards each other once put into a nest,
 * to put the birds from hurting each other you want to assign birds to nests such that minimum
 * distance between any two birds is as large as possible, what is the largest minimum distance?
 * <p>
 * input = 5 nests
 * birds = 3
 * nests = {1,2,4,8,9}
 */
public class AngryBirds {

    public static void main(String[] args) {
        int b = 3;
        int[] nests = {1, 2, 4, 8, 9};
        int result = angryBirdsNest(b, nests);
        System.out.println("Result: " + result);
    }

    static int angryBirdsNest(int b, int[] nests) {
        int n = nests.length;
        Arrays.sort(nests);
        int s = 0;
        int e = nests[n - 1] - nests[0];
        int ans = -1;
        while (s <= e) {
            int mid = (s + e) / 2;
            boolean canPlace = canPlaceBird(n, b, nests, mid);
            if (canPlace) {
                ans = mid;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return ans;
    }

    static boolean canPlaceBird(int n, int b, int[] nests, int separation) {
        int location = nests[0]; //last location where we place the bird, initially it is first
        int bird = 1;  //initially placed 1 bird
        for (int i = 1; i <= n - 1; i++) {
            int current_location = nests[i];
            if (current_location - location >= separation) {
                location = current_location;
                bird++;
                if (bird == b) {
                    return true;
                }
            }
        }
        return false;
    }
}
