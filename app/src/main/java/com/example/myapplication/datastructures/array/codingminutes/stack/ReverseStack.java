package com.example.myapplication.datastructures.array.codingminutes.stack;

import java.util.Stack;

public class ReverseStack {

    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        System.out.println(stack);
        reverseStack(stack);
        System.out.println(stack);
    }

    static void reverseStack(Stack<Integer> stack){
        //base condition
        if(stack.empty()){
            return;
        }

        //recursive case
        int temp = stack.peek();
        stack.pop();
        reverseStack(stack);
        insertAtBottom(stack,temp);
    }

    static void insertAtBottom(Stack stack, int data){
        //base case
        if(stack.empty()){
            stack.push(data);
            return;
        }

        //recursive case
        int temp = (int) stack.peek();
        stack.pop();
        insertAtBottom(stack,data);

        stack.push(temp);
    }
}
