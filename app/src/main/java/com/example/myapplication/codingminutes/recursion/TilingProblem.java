package com.example.myapplication.codingminutes.recursion;

public class TilingProblem {

    public static void main(String[] args){
     int n=4;
     int m=3;

     int result = tilesCount(n,m);
        System.out.println(result);
    }

    static int tilesCount(int n,int m){
        if(n<m){
            return 1;
        }
        int opt1 = tilesCount(n-1,m);
        int op2 = tilesCount(n-m,m);
        return opt1+op2;
    }
}
