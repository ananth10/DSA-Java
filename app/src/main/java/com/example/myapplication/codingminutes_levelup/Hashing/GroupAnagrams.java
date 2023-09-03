package com.example.myapplication.codingminutes_levelup.Hashing;

import android.hardware.biometrics.BiometricManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Group Anagrams
 * ---------------
 * Given a vector of strings strs, your task is to group the anagrams together.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 * <p>
 * Input:
 * strs = ["eat","tea","tan","ate","nat","bat"]
 * Output:
 * [["bat"],["nat","tan"],["ate","eat","tea"]]
 */
public class GroupAnagrams {

    public static void main(String[] args) {
        String[] arr = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> output = groupAnagram(arr);
        System.out.println("Result:"+output);
    }

    private static List<List<String>> groupAnagram(String[] arr) {
        List<List<String>> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {

            String word = sortString(arr[i]);
            if (map.containsKey(word)) {
                int location = map.get(word);
                result.get(location).add(arr[i]);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(arr[i]);
                result.add(temp);

                int location = result.size() - 1;
                map.put(word, location); //save word and list index
            }

        }

        return result;
    }

    private static String sortString(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        return Arrays.toString(chars);
    }
}
