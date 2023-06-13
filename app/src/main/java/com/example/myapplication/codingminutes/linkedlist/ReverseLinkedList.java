package com.example.myapplication.codingminutes.linkedlist;

public class ReverseLinkedList {

    public static void main(String[] args){
        LinkedList<Integer> list = new LinkedList<>();
        list.addFront(10);
        list.addBack(20);
        list.addBack(30);
        list.addBack(40);
        System.out.println(list);
        list.reverse();
        System.out.println(list);
    }
}
