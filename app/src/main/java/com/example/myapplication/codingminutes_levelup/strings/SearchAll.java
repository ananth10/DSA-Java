package com.example.myapplication.codingminutes_levelup.strings;

import java.util.ArrayList;
import java.util.List;

public class SearchAll {
    public static void main(String[] args) {
        String bigString = "I liked the movie acting in movie was great!";
        String smallString = "movie";
        List<Integer> result = searchAll(bigString, smallString);
        System.out.println("Result: " + result);
    }

    static List<Integer> searchAll(String big, String small) {
        List<Integer> result = new ArrayList<>();
        String match = "";
        for (int i = 0; i < big.length(); i++) {
            if (big.charAt(i) == ' ') {
                if (small.equals(match)) {
                    result.add(i - match.length());
                }
                match = "";
            } else {
                match = match + big.charAt(i);
            }
        }
        return result;
    }
}
