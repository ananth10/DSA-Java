package com.example.myapplication.codingminutes.recursion;

public class Fibonacci {

    public static void main(String[] args){
      int ans = fibo(8);
        System.out.println(ans);
    }

    static int fibo(int n){
        //base case
        if(n==0 || n==1){
            return n;
        }
        int fib1 = fibo(n-1);
        int fib2 = fibo(n-2);
        int ans = fib1+fib2;
        return ans;
    }
}
