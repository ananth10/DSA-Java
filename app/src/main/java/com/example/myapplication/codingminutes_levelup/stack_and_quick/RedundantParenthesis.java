package com.example.myapplication.codingminutes_levelup.stack_and_quick;

import java.util.Stack;

/**
 * Redundant Parenthesis
 * ---------------------
 * Given string of balanced expression, find if it contains a redundant parenthesis or not.
 * a set of parenthesis are redundant if same sub-expression is surrounded by unnecessary or multiple brackets.
 * print true if redundant else false
 * Input:
 * 1. ((a+b))
 * 2. (a+(b+c))
 * <p>
 * Output:
 * 1. Yes
 * 2. No
 */
public class RedundantParenthesis {
    public static void main(String[] args) {
        String exp1 = "((a+b))";
        String exp2 = "(a+(b+c))";

        boolean result = isRedundantParenthesis(exp1);
        System.out.println("is given expression redundant? :"+result);

    }

    private static boolean isRedundantParenthesis(String exp1) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < exp1.length(); i++) {
            char ch = exp1.charAt(i);

            if (ch != ')') {
                stack.push(ch);
            } else {
                boolean operatorFound = false;
                while (!stack.isEmpty() && stack.peek() != '(') {
                    char top = stack.peek();
                    if (top == '+' || top == '-' || top == '*' || top == '/') {
                        operatorFound = true;
                    }
                    stack.pop();
                }
                stack.pop(); //pop '(' after while loop over
                if (!operatorFound) {
                    return true;
                }
            }
        }
        return false;
    }
}
