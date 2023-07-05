package com.example.myapplication.codingminutes_levelup.bit_manipulation;

public class FastExponentiation {
    public static void main(String[] args){
        int a = 3;
        int n = 5;

        int result = fastExponentiation(a,n);
        System.out.println("Result: "+result);
    }

    static int fastExponentiation(int a,int n){
        int ans = 1;
        while (n>0){
            int lastBit = n & 1;
            if(lastBit==1){
                ans = ans*a;
            }
            a = a*a;
            n = n>>1; //removing the last bit
        }
        return ans;
    }
}
