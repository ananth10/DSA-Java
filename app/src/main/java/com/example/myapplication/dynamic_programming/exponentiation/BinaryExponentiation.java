package com.example.myapplication.dynamic_programming.exponentiation;

public class BinaryExponentiation {

    public static void main(String[] args) {
        int a = 2;
        int b = 10;

        int result = power(a, b);
        System.out.println("Result:" + result);
    }


    static int power(int a, int b) {
        int result = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                result *= a;
            }
            a *= a;
            b /= 2;
        }

        return result;
    }
}
