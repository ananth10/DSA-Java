package com.example.myapplication.codingminutes_levelup.strings;

import java.util.Locale;
import java.util.StringTokenizer;

public class StringNormalisation {

    public static void main(String[] args) {
        String input = "This is SO MUCH FUN!";
        String output = stringNormalization(input);
        String output1 = normalize(input);
        System.out.println(output);
        System.out.println(output1);
    }

    //Approach 1
    static String stringNormalization(String input) {
        String copy = input;
        String output = "";
        StringTokenizer st = new StringTokenizer(copy, " ");
        while (st.hasMoreTokens()) {
            String str = st.nextToken();
            output += str.substring(0, 1).toUpperCase(Locale.ENGLISH) + str.substring(1).toLowerCase(Locale.ENGLISH) + " ";
        }
        return output;
    }

    //Approach 2
    static String normalize(String input){
        StringBuilder copy = new StringBuilder(input);
        int idx=0;
        while (idx<copy.length()) {
            idx = skipWhiteSpace(copy, idx);
            idx = normalizeWord(copy, idx);
        }

        return copy.toString();
    }

    static int skipWhiteSpace(StringBuilder copy,int idx){
        while (idx<copy.length() && copy.charAt(idx)==' '){
            idx++;
        }
        return idx;
    }

    static int normalizeWord(StringBuilder copy,int idx){
        if(idx<copy.length() && copy.charAt(idx)!=' '){
            copy.setCharAt(idx,Character.toUpperCase(copy.charAt(idx)));
            idx+=1;
        }
        while (idx<copy.length() && copy.charAt(idx)!=' '){
            copy.setCharAt(idx,Character.toLowerCase(copy.charAt(idx)));
            idx++;
        }
        return idx;
    }
}
