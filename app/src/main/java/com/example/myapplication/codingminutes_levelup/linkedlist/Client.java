package com.example.myapplication.codingminutes_levelup.linkedlist;

public class Client {

    public static void main(String[] args){
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.printList();
        System.out.println("Search: "+list.search(20));
        System.out.println("isPresent: "+list.isPresent(20));
    }
}
