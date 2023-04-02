package com.example.myapplication.algorithm.sorting


/**
 * INSERTION SORT - Its an algorithm to sort an array of elements, insertion sort is going to consider part of the array as part of sorted array and part of the array as unsorted array
 * -> val num = [6,5,3,1,8,7,,4]
 * ->HOW IT WORKS - First item keep as it is and take 5 and compare with previous element , if its less than previous then put it there
 * -> TIME - Best Case - O(n) Linear time, we will get almost O(n) when list is sorted
 *
 * */
fun main(){

    val numbers = intArrayOf(7,4,6,5)
    insertionSort(numbers)
}

fun insertionSort(numbers:IntArray){
    for (i in 1 until numbers.size){
        var key = numbers[i]
        var space = i
        for (j in space-1 downTo 0) {
            if(numbers[j]>key){
                numbers[j+1] = numbers[j]
                space=j
                continue
            }
            break
        }
        numbers[space] = key
    }

    println(numbers.contentToString())
}
