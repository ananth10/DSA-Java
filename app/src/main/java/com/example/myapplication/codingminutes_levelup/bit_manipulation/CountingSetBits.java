package com.example.myapplication.codingminutes_levelup.bit_manipulation;

public class CountingSetBits {
    public static void main(String[] args){
        int n = 9;
        int result = countSetBits(n);
        System.out.println("Result:"+result);
        System.out.println("Result 1: "+countSetBitsHack(n));
    }

    static int countSetBits(int n){
        int count =0;
        while (n>0){
            int lastBit = n & 1;// setting the last bit
            count+=lastBit;
            n = n>>1;
        }
        return count;
    }

    //Counting set bits - Hack (Faster method)
    static int countSetBitsHack(int n){
        int count =0;
        while (n>0){
          n = n & (n-1);
          count++;
        }
        return count;
    }
}
