package com.example.myapplication.codingminutes.queue;

import java.util.LinkedList;
import java.util.Queue;

public class SortQueue {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(11);
        queue.add(5);
        queue.add(4);
        queue.add(21);
        System.out.println("FRONT:" + queue.peek());
        sortGivenQueueWithoutExtraSpace(queue);
        while (queue.isEmpty() == false) {
            System.out.print(queue.peek() + " ");
            queue.poll();
        }
    }

    static Queue<Integer> sortGivenQueueWithoutExtraSpace(Queue<Integer> queue) {
        for (int i = 1; i <= queue.size(); i++) {
            int minIndex = minIndex(queue, queue.size() - i);
            insertMinimumToRear(queue, minIndex);
        }
        return queue;
    }

    static int minIndex(Queue<Integer> queue, int sortedIndex) {
        int minIndex = -1;
        int minValue = Integer.MAX_VALUE;
        int n = queue.size();

        for (int i = 0; i < n; i++) {
            int current = queue.poll();
            if (current <= minValue && i <= sortedIndex) {
                minIndex = i;
                minValue = current;
            }
            queue.add(current);
        }
        return minIndex;
    }

    static void insertMinimumToRear(Queue<Integer> queue, int minIndex) {
        int minValue = 0;
        int n = queue.size();
        for (int i = 0; i < n; i++) {
            int current = queue.poll();
            if (i != minIndex) {
                queue.add(current);
            } else {
                minValue = current;
            }
        }
        queue.add(minValue);
    }
}
