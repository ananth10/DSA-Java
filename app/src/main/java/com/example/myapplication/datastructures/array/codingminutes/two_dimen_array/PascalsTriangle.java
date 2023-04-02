package com.example.myapplication.datastructures.array.codingminutes.two_dimen_array;

public class PascalsTriangle {

    public static void main(String[] args) {
        pascalTriangle(2);
    }

    static void pascalTriangle(int n) {
        int number;
        for (int i = 0; i <= n; i++) {
            number = 1;
            int j = 0;
            while (j <= i) {
                System.out.print(number + " ");
                number = number * (i - j) / (j + 1);
                j++;
            }
            System.out.println();
        }
    }
}
