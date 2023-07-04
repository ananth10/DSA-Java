package com.example.myapplication.codingminutes_levelup.bit_manipulation;

public class ReplaceBits {
    public static void main(String[] args){
        int n = 15;
        int m = 2;
        int i = 1;
        int j = 3;
        int result = replaceBits(n,i,j,m);
        System.out.println("Result:"+result);
    }
    static int clearBitsInRange(int n,int i,int j){
        int a = (~0)<<(j+1);
        int b = (1<<i)-1;
        int mask = a | b;
        n = n & mask;
        return n;
    }

    static int replaceBits(int n, int i, int j,int m){
        int k = clearBitsInRange(n,i,j);
        int mask = (m<<i);
        k = k | mask;
        return k;
    }
}
