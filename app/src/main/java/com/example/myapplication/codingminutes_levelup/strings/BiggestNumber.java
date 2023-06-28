package com.example.myapplication.codingminutes_levelup.strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BiggestNumber {
    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>();
        input.add(10);
        input.add(11);
        input.add(20);
        input.add(30);
        input.add(3);

        String result = biggestNumber(input);
        System.out.println("Result: "+result);
    }

    static class MyComparator implements Comparator<String> {

        @Override
        public int compare(String s1, String s2) {
            return s2.concat(s1).compareTo(s1.concat(s2));
        }
    }

    static String biggestNumber(List<Integer> input) {
        List<String> output = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            output.add(String.valueOf(input.get(i)));
        }
        Collections.sort(output, new MyComparator());
        String ans = "";
        for (String s : output) {
            ans += s;
        }
        return ans;
    }
}
