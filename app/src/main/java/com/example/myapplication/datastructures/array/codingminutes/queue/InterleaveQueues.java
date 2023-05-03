package com.example.myapplication.datastructures.array.codingminutes.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class InterleaveQueues {

    public static void main(String[] args) {
        int[] array = {11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        Queue<Integer> q = new LinkedList<>();
        q.add(11);
        q.add(12);
        q.add(13);
        q.add(14);
        q.add(15);
        q.add(16);
        q.add(17);
        q.add(18);
        q.add(19);
        q.add(20);
        List<Integer> result = interLeaveQueues(q);
        System.out.println(result);
    }

    static ArrayList<Integer> interLeaveQueues(Queue<Integer> input) {
        int n = input.size();
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        int mid = n / 2;
        for (int i = 0; i < n; i++) {
            if (i < mid) {
                queue.add(input.poll());
            } else {
                list.add(queue.poll());
                list.add(input.poll());
            }
        }
        return list;
    }
}
