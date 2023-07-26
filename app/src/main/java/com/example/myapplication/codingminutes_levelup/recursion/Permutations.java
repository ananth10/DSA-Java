package com.example.myapplication.codingminutes_levelup.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Permutations
 * --------------
 * Given  a string s, find all permutations of the string.
 * <p>
 * Input:
 * abc
 * <p>
 * output:
 * abc, acb, bac, bca, cab, cba
 */
public class Permutations {
    public  static List<String> list = new ArrayList<>();
    public static void main(String[] args) {
        String input = "abc";
        char[] chars = input.toCharArray();
        int n = chars.length;
        int i = 0;
        permutation(chars, n, i);
        Collections.sort(list);
        System.out.println("Result: "+list);
    }

    static void permutation(char[] arr, int n, int start) {
        //base case
        if (start == n) {
            list.add(Arrays.toString(arr));
            return;
        }

        //recursive case
        for (int j = start; j < n; j++) {
            swap(arr,j,start);
            permutation(arr, n, start + 1);
            swap(arr,j,start);
        }
    }

    static void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
