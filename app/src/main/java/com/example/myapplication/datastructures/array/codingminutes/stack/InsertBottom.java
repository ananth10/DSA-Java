package com.example.myapplication.datastructures.array.codingminutes.stack;

import java.util.Stack;

public class InsertBottom {

    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();
        stack.push(20);
        stack.push(30);
        stack.push(40);
        System.out.println(stack);
        System.out.println(stack.peek());

        insertAtBottom(stack ,10);
        System.out.println(stack);
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
