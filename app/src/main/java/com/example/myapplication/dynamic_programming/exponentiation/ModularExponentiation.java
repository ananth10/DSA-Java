package com.example.myapplication.dynamic_programming.exponentiation;

public class ModularExponentiation {

    public static void main(String[] args) {
        int a = 2;
        int b = 200;

        int result = modularExpo(a, b);
        System.out.println("Result:" + result);
    }

    static int modularExpo(int a, int b) {
        double mod = 1e9 + 7;
        double result = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                result *= a;
                result %= mod;
            }
            a *= a;
            a %= mod;
            b /= 2;
        }

        return (int) result;
    }
}
