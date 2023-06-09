package com.example.myapplication.codingminutes.queue.using_array;

import retrofit2.http.PUT;

public class Queue {
    private int[] queue;
    private int ms;//max size
    private int cs;//current size

    private int front;
    private int rear;

    public Queue(int ms) {
        this.ms = ms;
        queue = new int[ms];
        cs = 0;
        front = 0;
        rear = ms-1;
    }

    private boolean isFull() {
        return cs == ms;
    }

    private boolean isEmpty() {
        return cs == 0;
    }

    public void push(int data) {
        if (!isFull()) {
            rear = (rear + 1) % ms;
            queue[rear] = data;
            cs++;
        }
    }

    public int pop() {
        int data = -1;
        if (!isEmpty()) {
            data = queue[front];
            queue[front]=0;
            front = (front + 1) % ms;
        }
        return data;
    }

    public int getFront() {
        return queue[front];
    }

    public void print(){
        System.out.println();
        for(int i =0;i<ms;i++){
            System.out.print(queue[i]+", ");
        }
    }
}
