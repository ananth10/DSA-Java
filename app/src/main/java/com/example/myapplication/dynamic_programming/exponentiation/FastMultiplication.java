package com.example.myapplication.dynamic_programming.exponentiation;

public class FastMultiplication {

    public static void main(String[] args) {
        int a = 20;
        int b = 20;
        double c = 1e9 + 7;

        int result = power(a, b, c);
        System.out.println("Result:" + result);
    }

    static int power(int a, int b, double c) {
        int result = 0;
        while (b > 0) {
            if ((b & 1) == 1) {
                result += a;
                result %= c;
            }
            a += a;
            a %= c;
            b /= 2;
        }

        return result;
    }

}
