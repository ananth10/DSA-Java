package com.example.myapplication.codingminutes.recursion;

public class Factorial {

    public static void main(String[] arg){
        int ans = fact(5);
        System.out.println(ans);
    }

    static int fact(int n){
        //base case
        if(n==0){
            return 1;
        }
        int ans = n*fact(n-1); //recursive case
        return ans;
    }
}
