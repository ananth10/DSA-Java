package com.example.myapplication.codingminutes_levelup.Hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * MinimumBars
 * ----------
 * Given a string without spaces, and a list of words.
 * Write a function that finds the min bars to be added the string,
 * so that all resulting words in are found in the list.
 *
 * INPUT:
 * string s ="helloworldhi";
 *
 * string words[] = {"world", "hi","hello","helloworld", "batman"};
 *
 * OUTPUT:
 * 1
 *
 * Sample Input - II
 * string s ="codingminutes";
 *
 * string words[] = {"coding", "minute","hours","s", "code","cod","ing"};
 *
 * Sample Output - II
 * 2
 * coding | minute | s
 * 2 bars should be placed.
 * */
public class MinimumBars {

    public static void main(String[] args){
        String s ="helloworldhi";
        String[] words = {"world", "hi","hello","helloworld", "batman"};

        String s1 ="codingminutes";
        String[] words1 = {"coding", "minute","hours","s", "code","cod","ing"};

        int minBars = minimumBars(s1,words1);
        System.out.println("Result: "+minBars);
    }

    private static int minimumBars(String s, String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));

        int ans = minimumBarHelper(s,0,set);

        return ans-1; //ignore last bar by doing minus 1
    }

    private static int minimumBarHelper(String s, int index, Set<String> set) {
        //base case
        if(index==s.length()){
            return 0;
        }

        int minBar = Integer.MAX_VALUE;
        StringBuilder currentWord = new StringBuilder();

        for (int i = index; i < s.length(); i++) {
            currentWord.append(s.charAt(i));
            if(set.contains(currentWord.toString())){
                int ans = minimumBarHelper(s,i+1,set);
                if(ans!=-1) {
                    minBar = Math.min(minBar, ans+1); //1 means include current bar
                }
            }
        }
        if(minBar==Integer.MAX_VALUE){
            return -1;
        }

        return minBar;
    }
}
