package com.example.myapplication.codingminutes.backtracking;

import android.annotation.SuppressLint;
import android.os.Build;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class FindSubSet {

    public static void main(String[] args) {
//        int[] input = {1, 2};
//        ArrayList<ArrayList<Integer>> list = subSets(input);
//
//        for (ArrayList<Integer> innerList : list) {
//            System.out.print("{");
//            for (int val : innerList) {
//                System.out.print(val + " ");
//            }
//            System.out.println("}");
//        }

        call();
    }


    static ArrayList<ArrayList<Integer>> subSets(int[] input) {
        ArrayList<Integer> current = new ArrayList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        findSubSet(input, 0, current, result);
        return result;

    }

    static void findSubSet(int[] input, int index, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> result) {
        //base case
        if (index == input.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        //recursive case
        current.add(input[index]);
        findSubSet(input, index + 1, current, result);
        //backtracking code
        current.remove(current.size() - 1);
        findSubSet(input, index + 1, current, result);
    }


    @SuppressLint("NewApi")
    static void call() {
        char[] input = {'a', 'b', 'c'};
        char[] output = new char[5];
        int i = 0;
        int j = 0;
        ArrayList<String> list = new ArrayList<>();
        subset(input, output, i, j, list);
        Collections.sort(list);
//            list.sort(new Compare());
        print(list);

    }

    static void subset(char[] input, char[] output, int i, int j, ArrayList<String> list) {
        if (i == input.length) {
//            print(output);
            list.add(Arrays.toString(output));
            return;
        }
        output[j] = input[i];
        subset(input, output, i + 1, j + 1, list);
        //back tracking
        output[j] = '\0';
        subset(input, output, i + 1, j, list);
    }


    static void print(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            String inner = list.get(i);
            System.out.println();
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < inner.length(); j++) {
                if (Character.isLetter(inner.charAt(j))) {
                    builder.append(inner.charAt(j));
                }
            }
            System.out.print(builder);
        }
    }

    static class Compare implements Comparator<String>{

        @Override
        public int compare(String str1, String str2) {
            if(str1.length()==str2.length()){
                return str1.compareTo(str2);
            }
            return str2.compareTo(str1);
        }
    }
}
