package com.example.myapplication.codingminutes.recursion;

public class Power {
    
    public static void main(String[] args){
        int a = 3;
        int n=5;
        int result = power(a,n);
        System.out.println(result);
    }
    
    static int power(int a,int n)
    {
        //base case
        if(n==0){
            return 1;
        }
        return a*power(a,n-1);
    }
}
