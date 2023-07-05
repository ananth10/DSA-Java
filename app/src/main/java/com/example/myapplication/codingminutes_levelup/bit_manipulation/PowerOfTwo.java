package com.example.myapplication.codingminutes_levelup.bit_manipulation;

public class PowerOfTwo {
    public static void main(String[] args) {
        int n = 15;
        isPowerOfTwo(n);
    }

    static void isPowerOfTwo(int n) {
        int mask = n & (n - 1);
        if (mask == 0) {
            System.out.println("Power of 2");
        } else {
            System.out.println("Not power of 2");
        }
    }
}
