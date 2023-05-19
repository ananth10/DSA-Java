package com.example.myapplication.datastructures.array.codingminutes.heaps;

import java.util.ArrayList;
import java.util.List;

public class Heap {
    private List<Integer> list;
    private HeapType heapType;

    public Heap(int defaultSize, HeapType heapType) {
        list = new ArrayList<>(defaultSize);
        list.add(-1);
        this.heapType = heapType;
    }

    public void push(int data) {
        list.add(data);

        int lastIndex = list.size() - 1;
        int parentIndex = lastIndex / 2;

        while (lastIndex > 1 && compare(list.get(lastIndex), list.get(parentIndex))) {
            swap(list, lastIndex, parentIndex);
            lastIndex = parentIndex;
            parentIndex = parentIndex / 2;
        }
    }

    public void pop() {
        //step 1 swap first and last element
        swap(list, 1, list.size() - 1);
        //step 2 remove last element
        list.remove(list.size() - 1);
        //step 3 , do hepify
        hepify(1);
    }

    public int getTop() {
        return list.get(1);
    }

    public boolean isEmpty() {
        return list.size() == 1;
    }

    public void printHeap() {
        System.out.println();
        for (int i = 1; i < list.size(); i++) {
            System.out.print(list.get(i) + ", ");
        }
    }

    private void hepify(int index) {
        int left = 2 * index;
        int right = 2 * index + 1;

        int targetIndex = index;

        if (left < list.size() && compare(list.get(left),list.get(index))) {
            targetIndex = left;
        }

        if (right < list.size() && compare(list.get(right),list.get(targetIndex))) {
            targetIndex = right;
        }

        if (targetIndex != index) {
            swap(list, targetIndex, index);
            hepify(targetIndex);
        }
    }

    private boolean compare(int a, int b) {
        if (heapType == HeapType.MIN_HEAP) {
            return a < b;
        } else {
            return a > b;
        }
    }

    private void swap(List<Integer> list, int a, int b) {
        int temp = list.get(a);
        list.set(a, list.get(b));
        list.set(b, temp);
    }
}

enum HeapType {
    MIN_HEAP,
    MAX_HEAP
}


