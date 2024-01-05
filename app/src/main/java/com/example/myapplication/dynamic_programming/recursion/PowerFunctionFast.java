package com.example.myapplication.dynamic_programming.recursion;

public class PowerFunctionFast {

    public static void main(String[] args) {
        int a = 2;
        int n = 5;
        int result = powerFunctionFast(a, n);
        System.out.println("Result:" + result);
        System.out.println("Result:" + normalPower(a,n));
    }

    public static int powerFunctionFast(int a, int n) {
        //base case
        if (n == 0) {
            return 1;
        }
        //recursive case
        int subProb = powerFunctionFast(a, n / 2);
        int subProbSq = subProb * subProb;
        if (n % 2 == 0) {
            return subProbSq;
        }
        return a * subProbSq;
    }

    public static int normalPower(int a, int n){
        if(n==0){
            return 1;
        }
        return a*normalPower(a,n-1);
    }
}
