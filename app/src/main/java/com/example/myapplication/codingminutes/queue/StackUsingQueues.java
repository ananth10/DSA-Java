package com.example.myapplication.codingminutes.queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {


    public static void main(String[] args) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        StackImpl stack = new StackImpl(q1, q2);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.getTop());
        stack.print();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.push(4);
        stack.print();
    }

    static class StackImpl {
        Queue<Integer> queue1;
        Queue<Integer> queue2;

        public StackImpl(Queue<Integer> q1, Queue<Integer> q2) {
            this.queue1 = q1;
            this.queue2 = q2;
        }

        public void push(int data) {
            if (!queue1.isEmpty())
                queue1.add(data);
            else
                queue2.add(data);
        }

        public void pop() {
            if (queue1.isEmpty()) {
                while (!queue2.isEmpty()) {
                    int front = queue2.peek();
                    queue2.remove();
                    if (queue2.isEmpty()) {
                        break;
                    }
                    queue1.add(front);
                }
            } else {
                while (!queue1.isEmpty()) {
                    int front = queue1.peek();
                    queue1.remove();
                    if (queue1.isEmpty()) {
                        break;
                    }
                    queue2.add(front);
                }
            }
        }

        public int getTop() {
            if (queue1.isEmpty()) {
                while (!queue2.isEmpty()) {
                    int front = queue2.peek();
                    queue2.remove();
                    queue1.add(front);
                    if (queue2.isEmpty()) {
                        return front;
                    }
                }
            } else {
                while (!queue1.isEmpty()) {
                    int front = queue1.peek();
                    queue1.remove();
                    queue2.add(front);
                    if (queue1.isEmpty()) {
                        return front;
                    }
                    queue2.add(front);
                }
            }
            return -1;
        }

        public boolean isEmpty() {
            return queue1.isEmpty() && queue2.isEmpty();
        }

        public void print() {
            if (queue1.isEmpty()) {
                System.out.println("Q2:" + Arrays.toString(queue2.toArray()));
            } else {
                System.out.println("Q1:" + Arrays.toString(queue1.toArray()));
            }
        }
    }
}

