package com.example.myapplication.codingminutes.queue;

import com.example.myapplication.codingminutes.queue.using_array.Queue;

public class MainArray {

    public static void main(String[] args) {
        Queue queue = new Queue(6);
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.push(5);
        queue.push(6);
        queue.push(7);
        queue.print();
        queue.pop();
        queue.print();
        System.out.println("Front:"+queue.getFront());
    }
}
