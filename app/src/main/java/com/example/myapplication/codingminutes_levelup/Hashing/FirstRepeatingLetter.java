package com.example.myapplication.codingminutes_levelup.Hashing;

import android.annotation.SuppressLint;

import java.util.HashMap;
import java.util.Map;

/**
 * First repeating letter
 * ----------------------
 * Given a string, find the first repeating letter in a string in a single scan of the string.
 * Return '\0' if no such character exists.
 * <p>
 * Input:
 * codingminutes
 * <p>
 * Output:
 * i
 */
public class FirstRepeatingLetter {
    public static void main(String[] args) {
        String input = "codingminutes";
        char output = firstRepeatingLetter(input);
        System.out.println("Result:"+output);
    }

    @SuppressLint("NewApi")
    private static char firstRepeatingLetter(String input) {
        Map<Character, Boolean> map = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (map.get(ch)!=null && map.get(ch)) {
                return ch;
            } else {
                map.put(ch, true);
            }

        }
        return '\0';
    }
}
