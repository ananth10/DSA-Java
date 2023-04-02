package com.example.myapplication.algorithm.sorting

/**
 * HEAP SORT
 *
 * -> Its Comparison based sorting algorithm that uses binary heap data structure, like merge sort
 * -> Heapsort has running time of O(n log n) and like insertion sort heapsort in-place, no extra space needed during the sort
 * -> keep sort makes use of the efficient running time for inserting to and deleting from the heap.
 *
 * MIN-HEAP -> For every node 'X', X's children will always be larger than X
 * MAX-HEAP -> For every node 'X', X's children will always smaller than X
 *
 * INSERTION - Top down approach
 * -> step 1: Insert the element at first available space
 * -> step 2: Rearrange until satisfy the heap properties
 *
 * DELETION - Top down approach
 * -> step 1: Deleting the root
 * -> step 2: Replace the root with last element
 * -> step 3: Rearrange until satisfy the heap properties
 * -> Min Heap Note: Swap the parent with smaller child
 * -> Max Heap Note: Swap the parent with larger child
 *
 * HEAPS - Bottom Up
 *
 * -> bottom up approach relies on one principle
 *
 * SORTING HEAP
 *
 * -> 2 phases
 * -> phase 1 - constructing the heap
 * -> phase 2 - removing root of the heap one by one till no more elements in the heap.
 * -> Ascending Order  - Construct max heap
 * -> Descending Order - Construct min heap
 * */
fun main(){

}