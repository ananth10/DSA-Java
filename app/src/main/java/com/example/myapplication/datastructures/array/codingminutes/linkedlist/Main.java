package com.example.myapplication.datastructures.array.codingminutes.linkedlist;

public class Main {

    public static void main(String[] args){
        LinkedList<Integer> list = new LinkedList<>();
        list.addFront(10);
        list.addBack(20);
        list.addBack(30);
        list.addBack(40);
        list.insert(25,2);
        list.insert(5,0);
        list.insert(50,10);
        list.print();
        System.out.println();
//        int value = list.deleteFront();
//        int value1 = list.deleteBack();
        int value3 = list.deleteAt(3);
        list.print();

    }
}
