package com.example.myapplication.algorithm.sorting

import kotlin.math.min


/**
 * SELECTION SORT
 * ->One of simplest possible way to sort list
 * ->The Algorithm works by scanning list of items for the smallest elements and swapping the element for one in the first position and it will continue until all elements sorted
 *
 *->TIME- O(n^2)
 * ->SPACE - 0(1)
 * */
fun main() {
    val numbers = intArrayOf(99, 44, 2, 1, 5, 63, 87, 283, 4, 0)
    selectionSort(numbers)
    val sortedList = selectionSort1(numbers)
    println("List::${sortedList.joinToString(",") }}")
}

fun selectionSort(numbers: IntArray) {
    for (i in numbers.indices) {
        // set current index as minimum
        var smallestItemPosition = i
        var smallestItemValue = numbers[i]

        for (j in i + 1 until numbers.size) {
            if (numbers[j] < numbers[smallestItemPosition]) {
                //update minimum if current is lower that what we had previously
                smallestItemPosition = j
            }
        }
        numbers[i] = numbers[smallestItemPosition]
        numbers[smallestItemPosition] = smallestItemValue
    }

    println(numbers.contentToString())
}


fun selectionSort1(array: IntArray): IntArray {
    var minIndex = 0

    for (i in 0 until array.size - 1) {
        minIndex = i
        for (j in i + 1 until array.size) {
            if (array[minIndex] > array[j]) {
                minIndex = j
            }
        }

        var temp = array[i]
        array[i] = array[minIndex]
        array[minIndex] = temp
    }
    return array
}