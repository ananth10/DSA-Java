package com.example.myapplication.codingminutes.queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstNonRepeatingChar {

    public static void main(String[] args) {
        char[] input = {'a', 'a', 'b', 'c'};
        char[] result = firstNonRepeatingChars(input);
        System.out.println(result);
    }

    //brute force approach

    static char[] firstNonRepeatingChars(char[] input) {
        List<Character> list = new ArrayList<>();
        int n = input.length;
        list.add(input[0]);
        char temp = '-';
        boolean isFound = false;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < list.size(); j++) {
                if (input[i] == list.get(j)) {
                    isFound = true;
                    break;
                }
            }
            if (isFound) {
                list.add('-');
            } else {
                list.add(temp);
            }
        }
        System.out.println(Arrays.toString(list.toArray()));
        return null;
    }
}
