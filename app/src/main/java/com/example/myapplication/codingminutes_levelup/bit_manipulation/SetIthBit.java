package com.example.myapplication.codingminutes_levelup.bit_manipulation;

public class SetIthBit {

    public static void main(String[] args){
        int n = 5;
        int i = 1;

        int result = setIthBit(n,i);
        System.out.println("Result: "+result);
    }

    static int setIthBit(int n,int i){
        int mask = (1 << i);
        n = (n | mask);
        return n;
    }
}
