package com.example.myapplication.datastructures.array.codingminutes.recursion;

public class increasingNumber {

    public static void main(String [] args){
        increasingNumber(8);
    }

    static void   increasingNumber(int n){
        if(n==0){
            return;
        }
        increasingNumber(n-1);
        System.out.println(n);
    }
}
