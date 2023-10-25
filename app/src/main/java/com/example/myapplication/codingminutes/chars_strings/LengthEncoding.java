package com.example.myapplication.codingminutes.chars_strings;

public class LengthEncoding {
    public static void main(String[] args) {
        String s = "aaabbcc";

        String result = lengthEncoding(s);
        System.out.println("Result:" + result);
    }

    private static String lengthEncoding(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int count = 1;
            while (i < n-1 && s.charAt(i + 1) == s.charAt(i)) {
                count++;
                i++;
            }
            sb.append(s.charAt(i));
            sb.append(count);
        }
        if(sb.length()>s.length()){
            return s;
        }
        return sb.toString();
    }
}
