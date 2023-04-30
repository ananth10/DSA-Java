package com.example.myapplication.datastructures.array.codingminutes.queue;

import com.example.myapplication.datastructures.array.codingminutes.queue.using_linked_list.Queue;

public class MainLinkedList {
    public static void main(String[] args){
        Queue queue = new Queue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.print();
        queue.pop();
        queue.print();

        System.out.println(queue.getFront());
    }
}
