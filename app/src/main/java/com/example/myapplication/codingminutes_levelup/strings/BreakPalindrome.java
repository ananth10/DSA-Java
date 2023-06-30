package com.example.myapplication.codingminutes_levelup.strings;

import androidx.core.util.Pair;

public class BreakPalindrome {

    public static void main(String[] args) {
        String input = "abccba";
        String output = breakPalindrome(input);
        System.out.println("Result:"+output);
    }

    static String breakPalindrome(String input) {
        if(input.isEmpty() || input.length()==1){
            return "";
        }
        char[] arr = input.toCharArray();
        int n = arr.length;

        for (int i = 0; i < n / 2; i++) {
            if (arr[i] == 'a') {
                continue;
            } else {
                arr[i] = 'a';
            }
            return String.valueOf(arr);
        }
        //if not able to assign 'a' for till half of array , then assign 'a' to the last char
        arr[n - 1] = 'a';
        return String.valueOf(arr);
    }
}
