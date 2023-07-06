package com.example.myapplication.codingminutes_levelup.bit_manipulation;

public class DecimalToBinary {
    public static void main(String[] args) {
        int n = 10;
        decimalToBinary(n);
    }

    static void decimalToBinary(int n) {
        int ans = 0;
        int[] reminder = new int[40];
        int i = 0;
        while (n > 0) {
            reminder[i] = n % 2;
            n = n / 2;
            i++;
        }
        for (int j = i - 1; j >= 0; j--) {
            System.out.print(reminder[j]);
        }
    }
}
