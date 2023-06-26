package com.example.myapplication.codingminutes_levelup.strings;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Tokenization {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        StringTokenizer stringTokenizer = new StringTokenizer(input);
        int i = stringTokenizer.countTokens();
        System.out.println(i);
    }
}
