package com.example.myapplication.codingminutes_levelup.strings;

public class RunLengthEncoding {

    public static void main(String[] args) {
        String input = "bbbaaaadexxxxxx";
        String result = runLengthEncoding(input);
        String result1 = runLengthEncoding1(input);
        System.out.println(result);
        System.out.println(result1);
    }

    //approach 1
    static String runLengthEncoding(String input) {
        String output = "";
        char match = input.charAt(0);
        int count = 1;

        for (int i = 1; i < input.length(); i++) {
            if (match == input.charAt(i)) {
                count++;
            } else {
                output += match;
                output += String.valueOf(count);
                match = input.charAt(i);
                count = 1;
            }
        }

        if (match == input.charAt(input.length() - 1)) {
            output += match;
            output += String.valueOf(count);
        }

        return input.length() < output.length() ? input : output;
    }

    //approach 2

    static String runLengthEncoding1(String input) {
        String output = "";
        int n = input.length();

        for (int i = 0; i < n; i++) {
            int count = 1;

            while (i < n - 1 && input.charAt(i) == input.charAt(i + 1)) {
                count++;
                i++;
            }

            output += input.charAt(i);
            output += String.valueOf(count);
        }

        if (input.length() < output.length()) {
            return input;
        }
        return output;
    }
}
