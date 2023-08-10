package com.example.myapplication.codingminutes_levelup.stack_and_quick;

import java.util.Stack;

/**
 * Balanced Parenthesis
 * --------------------
 * Given an expression string, write a program to check all
 * the pairs of parenthesis are valid
 * <p>
 * Input:
 * ((a+b)*x-d)
 * ((a+b]+c)*(d-e)
 * <p>
 * Output:
 * True
 * False
 */
public class BalancedParenthesis {

    public static void main(String[] args) {
        String expression = "((a+b)*x-d)]";
        boolean isBalanced = balancedParenthesis(expression);
        System.out.println("Result:" + isBalanced);
    }

    private static boolean balancedParenthesis(String expression) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            Character ch = expression.charAt(i);
            if (ch.equals('(') || ch.equals('[') || ch.equals('{')) {
                stack.push(ch);
            } else if (ch.equals(')')) {
                if (!stack.empty() && stack.peek().equals('(')) {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (ch.equals('}')) {
                if (!stack.empty() && stack.peek().equals('{')) {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (ch.equals(']')) {
                if (!stack.empty() && stack.peek().equals('[')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.empty();
    }
}
