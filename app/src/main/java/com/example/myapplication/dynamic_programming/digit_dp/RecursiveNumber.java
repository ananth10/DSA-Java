package com.example.myapplication.dynamic_programming.digit_dp;

public class RecursiveNumber {

    public static void main(String[] args) {
        String num = "2437";
        digitRecursive(num, "", 0, true);
    }

    private static void digitRecursive(String num, String ans, int index, boolean isLast) {
        //base case
        if (index == num.length()) {
            System.out.println(ans);
            return;
        }
        //recursive case
        int till = isLast ? (num.charAt(index) - '0') : 9;

        for (int i = 0; i <= till; i++) {
           digitRecursive(num,ans+ i,index+1,(isLast && i==till));
        }
    }
}
