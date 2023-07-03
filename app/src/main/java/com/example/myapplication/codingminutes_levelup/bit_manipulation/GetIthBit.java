package com.example.myapplication.codingminutes_levelup.bit_manipulation;

public class GetIthBit {
    public static void main(String[] args){
        int number = 5;
        int i =1;
        int result = getIthBit(number,i);
        System.out.println("Result:"+result);
    }

    static int getIthBit(int num, int i){
        int mask = 1 << i;
        return  (num & mask) > 0 ?1:0;
    }
}
