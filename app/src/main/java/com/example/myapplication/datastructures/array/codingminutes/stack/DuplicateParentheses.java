package com.example.myapplication.datastructures.array.codingminutes.stack;

import java.util.Stack;

public class DuplicateParentheses {

    public static void main(String[] args) {
        String input = "((a+b)+(c+d))";
//        String input1 = "((a+b)+(c+d))";
        boolean result = duplicateParentheses(input);
        System.out.println(result);
    }

    static boolean duplicateParentheses(String input) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char val = input.charAt(i);
            if (val == ')') {
                char top = stack.peek();
                stack.pop();
                int elementInside = 0;
                while (top != '(') {
                    elementInside++;
                    top = stack.peek();
                    stack.pop();
                }

                if (elementInside < 1) {
                    return true;
                }
            } else {
                stack.push(val);
            }
        }
        return false;
    }
}
