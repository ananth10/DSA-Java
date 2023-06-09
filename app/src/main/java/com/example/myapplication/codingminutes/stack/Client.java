package com.example.myapplication.codingminutes.stack;


import com.example.myapplication.codingminutes.stack.using_linked_list.Stack;

public class Client {
    public static void main(String[] args){
        //using linked list
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        printStack(stack);

        //using vector
        com.example.myapplication.codingminutes.stack.using_vector.Stack<Integer> stack1 = new com.example.myapplication.codingminutes.stack.using_vector.Stack<Integer>();
        stack1.push(5);
        stack1.push(6);
        stack1.push(7);
        stack1.push(8);
        printStack1(stack1);
    }

    static void printStack(Stack<Integer> stack){
        while (!stack.empty()){
            System.out.println(stack.getTop());
           stack.pop();
        }
    }

    static void printStack1(com.example.myapplication.codingminutes.stack.using_vector.Stack<Integer> stack){
        while (!stack.empty()){
            System.out.println(stack.getTop());
            stack.pop();
        }
    }

}
