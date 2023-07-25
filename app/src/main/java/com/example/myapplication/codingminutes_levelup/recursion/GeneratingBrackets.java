package com.example.myapplication.codingminutes_levelup.recursion;

/**
 * Write a function to generate all possible n pairs of balanced parentheses '(' and ')'
 *
 * input:
 * 2
 *
 * output:
 * () ()
 * (())
 * */
public class GeneratingBrackets {
    public static void main(String[] args){
        int n = 1;
        String output="";
        generateBrackets(output,n,0,0,0);
    }

    private static void generateBrackets(String output, int n, int open, int close, int i) {
        //base case
        if(i==2*n){
            System.out.println(output);
            return;
        }
        //recursive case
        if(open<n){
            generateBrackets(output+" (",n,open+1,close,i+1);
        }
        if(close<open){
            generateBrackets(output+" )",n,open,close+1,i+1);
        }
    }
}
