package com.example.myapplication.codingminutes_levelup.bit_manipulation;

public class UpdateIthBit {
    public static void main(String[] args){
        int n = 13;
        int i = 2;
        int val = 1;
        int result = updateIthBit(n,i,val);
        System.out.println("Result: "+result);
    }

    static int  updateIthBit(int n, int i, int val){
        clearIth(n,i);
        int mask = (val << i);
        n = n | mask;
        return n;
    }

    static int clearIth(int n,int i){
        int mask = ~(1<<i);
        n = n & mask;
        return n;
    }
}
