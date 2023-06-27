package com.example.myapplication.codingminutes_levelup.strings;

public class Subsets {

    public static void main(String[] args) {
        String s1 = "codingminutes";
        String s2 = "cines";
        boolean result = isSubSets(s1, s2);
        System.out.println("Result:" + result);
    }

    static boolean isSubSets(String s1, String s2) {
        int i = s1.length() - 1;
        int j = s2.length() - 1;

        while (j >= 0 && i >= 0) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i--;
                j--;
            } else {
                i--;
            }
        }
        if (j == -1) {
            return true;
        }
        return false;
    }
}
