package com.example.myapplication.codingminutes_levelup.Hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Quick Brown Fox
 * ---------------
 * Given a string without spaces, and a list of words , write a function that finds the min bars to be added the
 * string, so that all resulting words in are found in the list
 * <p>
 * INPUT:
 * s = "thequickbrownfox"
 * OUTPUT:
 * 2
 */
public class QuickBrownFox {
    public static void main(String[] args) {
        String input = "thequickbrownfox";
        String[] words = {"the", "quickbrown", "fox", "quick", "brown"};

        int minBars = minBars(input, words);
        System.out.println("Result :" + minBars);
    }

    private static int minBars(String input, String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));
        int ans = minBarsHelper(input, 0, set);

        return ans - 1;
    }

    private static int minBarsHelper(String input, int index, Set<String> set) {
        //base case
        if (index == input.length()) {
            return 0;
        }
        //recursive case
        int ans = Integer.MAX_VALUE;
        StringBuilder currentString = new StringBuilder();
        for (int j = index; j < input.length(); j++) {
            currentString.append(input.charAt(j));
            if (set.contains(currentString.toString())) {
                int minAns = minBarsHelper(input, j + 1, set);
                if (minAns != -1) {
                    ans = Math.min(ans, 1 + minAns);
                }
            }
        }
        if (ans == Integer.MAX_VALUE) {
            return -1;
        }
        return ans;
    }
}
