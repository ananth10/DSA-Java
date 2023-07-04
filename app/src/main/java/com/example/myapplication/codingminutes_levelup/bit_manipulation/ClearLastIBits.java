package com.example.myapplication.codingminutes_levelup.bit_manipulation;

public class ClearLastIBits {
    public static void main(String[] args){
        int n =15;
        int i =2;
        int result = clearLastIBits(n,i);
        System.out.println("Result:"+ result);
    }

    static int clearLastIBits(int n,int i){
        int mask = (-1 << i);
        n = n & mask;
        return n;
    }
}
