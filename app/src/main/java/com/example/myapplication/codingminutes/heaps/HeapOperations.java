package com.example.myapplication.codingminutes.heaps;

public class HeapOperations {

    public static void main(String[] args){
        Heap heap = new Heap(20,HeapType.MAX_HEAP);
        heap.push(10);
        heap.push(20);
        heap.push(30);
        heap.push(25);
        heap.push(40);
        heap.push(15);
        heap.printHeap();
        System.out.println("TOP:"+heap.getTop());
        heap.pop();
        heap.printHeap();
    }
}
