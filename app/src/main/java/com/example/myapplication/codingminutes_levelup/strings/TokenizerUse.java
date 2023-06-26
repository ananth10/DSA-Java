package com.example.myapplication.codingminutes_levelup.strings;

import java.util.StringTokenizer;

public class TokenizerUse {
    public static void main(String[] args){
        String s = "I am on the way";
        StringTokenizer stringTokenizer = new StringTokenizer(s);
        while (stringTokenizer.hasMoreTokens()){
            System.out.println(stringTokenizer.nextToken());
        }
    }
}
