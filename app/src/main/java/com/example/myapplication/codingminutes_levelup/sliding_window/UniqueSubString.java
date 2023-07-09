package com.example.myapplication.codingminutes_levelup.sliding_window;

import java.util.HashMap;

public class UniqueSubString {
    public static void main(String[] args) {
        String input = "abcabed";
        String output = uniqueSubString(input);
        System.out.println("Result: "+output);
    }

    static String uniqueSubString(String input) {
        int i = 0;
        int j = 0;

        int window_length = 0;
        int max_window_length = 0;
        int start_window = -1;

        HashMap<Character, Integer> map = new HashMap<>();

        while (j < input.length()) {
            Character ch = input.charAt(j);

            //if current character already in the map and current index is greater than the start window
            if (map.containsKey(ch) && map.get(ch) >= i) {
                i = map.get(ch) + 1;
                window_length = j - i;
            }

            map.put(ch, j);
            window_length++;
            j++;

            if (window_length > max_window_length) {
                max_window_length = window_length;
                start_window = i;
            }
        }

        return input.substring(start_window);
    }
}
