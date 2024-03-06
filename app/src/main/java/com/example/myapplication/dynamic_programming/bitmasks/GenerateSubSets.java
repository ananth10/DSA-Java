package com.example.myapplication.dynamic_programming.bitmasks;

public class GenerateSubSets {

    public static void main(String[] args) {

        String s = "abc";
        generateSubSet(s);
    }

    static void generateSubSet(String s) {
        int n = s.length();

        for (int i = 0; i < (1 << n); i++) {
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 1) {
                    System.out.print(s.charAt(j));
                }
            }
            System.out.println();
        }
    }
}
