package com.example.myapplication.dynamic_programming.recursion;

public class TileProblem {
    public static void main(String[] args){
        int n = 4;
        int a =4;
        int result = placeTiles(a,n);
        System.out.println("Result: "+result);
    }

    public static int placeTiles(int a, int n){
        //base case
        if(n<=3){
            return 1;
        }
        //recursive case
        return placeTiles(a,n-1) + placeTiles(a,n-4);
    }
}
