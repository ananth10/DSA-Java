package com.example.myapplication.codingminutes_levelup.linkedlist;

public class Client {

    public static void main(String[] args){
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(50);
        list.printList();
        System.out.println("Search: "+list.search(20));
        System.out.println("isPresent: "+list.isPresent(20));
        list.insertAt(3,40);
        list.insertAt(5,60);
        list.insertAt(8,70);
        list.printList();
        System.out.println("size:"+list.getSize());
        list.delete();
        list.delete();
        System.out.println("AFTER DELETE");
        list.insertAtHead(5);
        list.printList();
        list.printList();
    }
}
