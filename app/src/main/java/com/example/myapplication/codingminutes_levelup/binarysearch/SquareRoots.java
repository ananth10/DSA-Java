package com.example.myapplication.codingminutes_levelup.binarysearch;

/**
 * Given an integer N and an integer P, you need find the square root of number N
 * up to P places, do it without using a library function
 */
public class SquareRoots {
    public static void main(String[] args) {
        int n = 10;
        int p = 3;

        double result = squareRoots(n, p);
        System.out.println("Result:" + result);
    }

    static double squareRoots(int n, int p) {
        int s = 0;
        int e = n;
        double ans = 0;

        //binary search
        while (s <= e) {
            int mid = (s + e) / 2;
            if (mid * mid == n) {
                return mid;
            } else if (mid * mid < 10) {
                ans = mid;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }

        System.out.println("ANS:" + ans);
        //linear search
        double inc = 0.1;
        for (int place = 1; place <= p; place++) {
            while (ans * ans <= n) {
                ans += inc;
            }
            //we need to go back to previous ans because the found answer will be larger
            ans = ans - inc;
            inc = inc / 10.0; //move to next point, 0.1 to 0.01 then 0.001
            System.out.println("POINT:"+inc);
        }

        return ans;

    }
}
