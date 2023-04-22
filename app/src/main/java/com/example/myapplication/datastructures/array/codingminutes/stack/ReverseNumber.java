package com.example.myapplication.datastructures.array.codingminutes.stack;

import java.util.Stack;

public class ReverseNumber {

    public static void main(String[] args){
       int number = 456;
       int result = reverseNumber(number);
        System.out.println(result);
    }

    static int reverseNumber(int num){
        Stack<Integer> stack = new Stack<>();
       while (num>0){
           int lastDigit = num%10;
           stack.push(lastDigit);
           num = num/10;
       }

       int rev = 0;
       int i= 1;

       while (!stack.empty()){
           rev = rev+(stack.peek()*i);
           stack.pop();
           i=i*10;
           System.out.println(rev);
           System.out.println(i);
       }
       return rev;
    }
}
