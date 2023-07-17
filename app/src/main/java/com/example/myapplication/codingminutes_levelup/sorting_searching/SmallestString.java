package com.example.myapplication.codingminutes_levelup.sorting_searching;

import java.util.Arrays;

public class SmallestString {
    public static void main(String[] args){
        String[] a = {"a","ab","aba"};
        Arrays.sort(a, (o1, o2) -> (o1+o2).compareTo(o2+o1));
        for(String s:a){
            System.out.println(s);
        }
    }
}
