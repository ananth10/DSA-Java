package com.example.myapplication.codingminutes_levelup.bit_manipulation;

public class CheckOddEven {

    public static void main(String[] args) {
        int a = 2;
        String result = checkOddOrEven(a);
        System.out.println("Result: "+result);
    }

    private static String checkOddOrEven(int num) {
        if ((num & 1) != 1) {
            return "Even";
        } else {
            return "Odd";
        }
    }
}
