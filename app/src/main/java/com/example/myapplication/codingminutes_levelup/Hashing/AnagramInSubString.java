package com.example.myapplication.codingminutes_levelup.Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * AnagramInSubString
 * -----------------
 * Two strings are anagrams of each other if the letter of one string can be rearranged to form the other string.
 * Given a string, find the number of pairs of substring of the string that are anagrams of each other.
 * <p>
 * INPUT:
 * "abba"
 * <p>
 * OUTPUT:
 * {a,a}
 * {ab,ba}
 * {b,b}
 * {abb,bba}
 */
public class AnagramInSubString {

    public static void main(String[] args) {
        String input = "abba";
        int result = anagramInSubString(input);
        System.out.println("Result :" + result);
    }


    private static int anagramInSubString(String input) {
        Map<List<Integer>, Integer> map = new HashMap<>();
        int answer = 0;
        //1. find sub string
        for (int i = 0; i < input.length(); i++) {
            for (int j = i; j < input.length(); j++) {
                List<Integer> hash = generateHash(input, i, j); //2.generate hash for each substring

                if (map.containsKey(hash)) { //3. put generated hash into map and increase freq if same hash comes.
                    map.put(hash, map.get(hash) + 1);
                } else {
                    map.put(hash, 1);
                }
            }
        }
        for (List<Integer> p : map.keySet()) { //4. Iterate over map and get freq
            int freq = map.get(p);
            if (freq >= 2) {
                answer += freq / 2;
            }
        }
        return answer;
    }

    private static List<Integer> generateHash(String input, int i, int j) {
        Integer[] hash = new Integer[26];
        Arrays.fill(hash, 0);
        List<Integer> list = new ArrayList<>(Arrays.asList(hash));
        for (int k = i; k <= j; k++) {
            char ch = input.charAt(k);
            list.set((ch - 'a'), list.get(ch - 'a') + 1);
        }
        return list;
    }


}
