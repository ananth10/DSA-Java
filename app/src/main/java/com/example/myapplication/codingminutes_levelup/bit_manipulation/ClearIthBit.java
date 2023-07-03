package com.example.myapplication.codingminutes_levelup.bit_manipulation;

public class ClearIthBit {

    public static void main(String[] args){
        int n = 13;
        int i = 2;
        int result = clearIth(n,i);
        System.out.println("Result:"+result);
    }

    static int clearIth(int n,int i){
      int mask = ~(1<<i);
      n = n & mask;
      return n;
    }
}
